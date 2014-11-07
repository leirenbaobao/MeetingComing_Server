package com.ctrlz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.ctrlz.kit.PushKit;
import com.ctrlz.model.Meeting;
import com.ctrlz.model.Message;
import com.ctrlz.model.Participant;
import com.ctrlz.model.Staff;

public enum MeetingService {
	meetingService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public boolean launch(Meeting meeting, String... ids) throws Exception {
		if (meeting.save()) {
			int mid = meeting.get("meetingId");
			Participant.dao.save(mid, ids);
			Message.dao.save(meeting, ids);
		}
		return true;
	}

	public List<Meeting> meetings(String id) {
		changeStatus();
		return Meeting.dao.meetings(id);
	}

	public boolean sign(String sid, String mid) {
		return Participant.dao.sign(mid, sid);
	}

	public boolean delay(String mid, String time) throws Exception {
		Meeting m = Meeting.dao.findById(mid);
		long t = m.get("startTime");
		int duration = m.get("duration");
		boolean b = m
				.set("startTime", time)
				.set("endTime",
						new DateTime(Long.valueOf(time)).plusMinutes(duration)
								.getMillis()).update();
		if (b) {

			List<Participant> ps = Participant.dao.query(mid);
			for (Participant p : ps) {
				Message msg = new Message()
						.set("title", "会议推迟")
						.set("content",
								sdf.format(new Date(t))
										+ "的"
										+ m.get("name")
										+ "推迟到"
										+ sdf.format(new Date(Long.valueOf(m
												.getStr("startTime")))))
						.set("receiver", p.get("staffId"))
						.set("sender", m.get("sponsor")).set("type", 0)
						.set("time", System.currentTimeMillis());
				msg.save();
				new PushKit().push(msg);
			}
		}
		return b;
	}

	public List<Meeting> history(String id) {
		return Meeting.dao.history(id);
	}

	public boolean cancel(String mid) throws Exception {
		Meeting m = Meeting.dao.findById(mid);
		boolean b = m.set("status", 3).set("summary", "会议取消").update();
		if (b) {
			List<Participant> ps = Participant.dao.query(mid);
			for (Participant p : ps) {
				Message msg = new Message()
						.set("title", "会议取消")
						.set("content",
								sdf.format(new Date(Long.valueOf(m
										.getLong("startTime"))))
										+ "的"
										+ m.get("name") + "已取消")
						.set("receiver", p.get("staffId"))
						.set("sender", m.get("sponsor")).set("type", 0)
						.set("time", System.currentTimeMillis());
				msg.save();
				new PushKit().push(msg);
			}
		}
		return b;
	}

	public boolean refuse(String mid, String sid) throws Exception {
		Participant p = Participant.dao.query(mid, sid);
		Meeting m = Meeting.dao.findById(mid);
		Staff s = Staff.dao.findById(sid);
		boolean b = p.set("leave", 1).update();
		if (b) {
			Message msg = new Message().set("title", "不参加会议")
					.set("content", s.get("name") + "因故无法参加" + m.get("name"))
					.set("receiver", m.get("sponsor"))
					.set("sender", p.get("staffId")).set("type", 1)
					.set("time", System.currentTimeMillis());
			new PushKit().push(msg);
		}
		return b;
	}

	private void changeStatus() {
		List<Meeting> meetings = Meeting.dao.find("select * from meeting");
		for (Meeting meeting : meetings) {
			// System.out.println(meeting);
			if (System.currentTimeMillis() > meeting.getLong("startTime")
					&& 0 == meeting.getInt("status")) {
				meeting.set("status", 3).update();
			}
		}
	}
}
