package com.ctrlz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Participant extends Model<Participant> {

	public static final Participant dao = new Participant();

	public boolean save(int mid, String... sids) {
		for (String sid : sids) {
			new Participant().set("meetingId", mid).set("staffId", sid).save();
		}
		return true;
	}

	public boolean sign(String mid, String sid) {
		System.out.println(mid);
		System.out.println(sid);
		return dao
				.findFirst(
						"select * from participant where meetingId=? and staffId=?",
						mid, sid).set("sign", 1)
				.set("signTime", System.currentTimeMillis()).update();
	}

	public List<Participant> query(String mid) {
		return dao.find("select * from participant where meetingId=?", mid);
	}

	public Participant query(String mid, String sid) {
		return dao.findFirst(
				"select * from participant where meetingId=? and staffId=?",
				mid, sid);
	}
}
