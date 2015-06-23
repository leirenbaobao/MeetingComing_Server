package com.ctrlz.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ctrlz.kit.PushKit;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Message extends Model<Message> {

	public static final Message dao = new Message();

	public List<Message> findAll(int sid) {
		return dao
				.find("SELECT m.messageId,title,content,s.name AS sender,time,type FROM message m JOIN staff s ON s.staffId = m.sender WHERE receiver = ? AND deleted = 0",
						sid);
	}

	public Message findOne(int mid) {
		return dao
				.findFirst(
						"SELECT m.messageId,title,content,s.name AS sender,time,type FROM message m JOIN staff s ON s.staffId = m.sender WHERE m.messageId = ?",
						mid);
	}

	// TODO: 构建message
	public boolean save(Meeting meeting, String... sids) throws Exception {
		for (String sid : sids) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime = sdf.format(new Date(Long.valueOf(meeting
					.getStr("startTime"))));
			Message m = new Message()
					.set("title", meeting.get("name"))
					.set("content",
							startTime + "于" + meeting.get("room") + "召开"
									+ meeting.get("name") + ",请各位准时参加.")
					.set("time", System.currentTimeMillis())
					.set("sender", meeting.get("sponsor")).set("receiver", sid)
					.set("type", 0);
			m.save();
			new PushKit().push(m);
		}
		return true;
	}
}
