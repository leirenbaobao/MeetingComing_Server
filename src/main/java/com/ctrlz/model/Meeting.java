package com.ctrlz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Meeting extends Model<Meeting> {

	public static final Meeting dao = new Meeting();

	public List<Meeting> meetings(String id) {
		return dao
				.find("SELECT m.meetingId,m.name,m.subject,s.name as sponsor,s.staffId as staffId,m.startTime,m.endTime,m.duration,m.emergency,m.importance,m.remarks,m.number,r.name as room FROM	meeting m JOIN participant p ON m.meetingId = p.meetingId JOIN staff s ON s.staffId = m.sponsor JOIN room r on r.roomId=m.room WHERE	p.staffId = ? AND m.status in (0,1)  AND startTime > ?",
						id, System.currentTimeMillis());
	}

	public List<Meeting> history(String id) {
		return dao
				.find("SELECT p.leave,p.sign,m.meetingId,m.name,m.subject,s.staffId as staffId,s.name as sponsor,m.startTime,m.endTime,m.duration,m.emergency,m.remarks,m.number,r.name as room,m.summary FROM meeting m JOIN participant p ON m.meetingId = p.meetingId JOIN staff s ON s.staffId = m.sponsor JOIN room r on r.roomId=m.room WHERE p.staffId = ? AND m.status in (2,3)",
						id);
	}
}
