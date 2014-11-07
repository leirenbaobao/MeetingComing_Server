package com.ctrlz.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.ctrlz.model.Meeting;
import com.ctrlz.service.MeetingService;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

public class MeetingAction extends Controller {
	private MeetingService meetingService = MeetingService.meetingService;

	public void launch() {
		String id = getPara("staffIds");
		String[] ids = id.split(",");
		String startTime = getPara("startTime");
		int duration = getParaToInt("duration");
		Meeting meeting = new Meeting();
		meeting.set("name", getPara("name"));
		meeting.set("subject", getPara("subject"));
		meeting.set("sponsor", getPara("sponsor"));
		meeting.set("startTime", startTime);
		meeting.set("duration", duration);
		meeting.set("emergency", getPara("emergency"));
		meeting.set("importance", getPara("importance"));
		meeting.set("remarks", getPara("remarks"));
		meeting.set("room", getPara("room"));
		meeting.set("endTime", new DateTime(Long.valueOf(startTime))
				.plusMinutes(duration).getMillis());
		meeting.set("number", ids.length);
		boolean b = false;
		try {
			b = meetingService.launch(meeting, ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}

	public void query() {
		String id = getPara("staffId");
		List<Meeting> meetings = meetingService.meetings(id);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", meetings);
		renderJson(JsonKit.toJson(m));
	}

	public void sign() {
		String sid = getPara("staffId");
		String mid = getPara("meetingId");
		Map<String, Object> m = new HashMap<String, Object>();
		boolean b = false;
		try {
			b = meetingService.sign(sid, mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}

	public void delay() {
		String mid = getPara("meetingId");
		String time = getPara("time");
		Map<String, Object> m = new HashMap<String, Object>();
		boolean b = false;
		try {
			b = meetingService.delay(mid, time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}

	public void history() {
		String id = getPara("staffId");
		List<Meeting> meetings = meetingService.history(id);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", meetings);
		renderJson(JsonKit.toJson(m));
	}

	public void cancel() {
		String id = getPara("meetingId");
		boolean b = false;
		try {
			b = meetingService.cancel(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}

	public void refuse() {
		String mid = getPara("meetingId");
		String sid = getPara("staffId");
		boolean b = false;
		try {
			b = meetingService.refuse(mid, sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}
}
