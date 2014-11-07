package com.ctrlz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Room extends Model<Room> {

	public static final Room dao = new Room();

	public List<Room> findAll() {
		return dao.findByCache("base", "rooms", "select * from room");
	}

	public List<Room> usedRooms() {
		return dao
				.find("select r.roomId,r.name ,m.startTime,m.endTime from room r join meeting m on m.room=r.roomId where m.startTime>?",
						System.currentTimeMillis());
	}

	public Room room(String roomId) {
		return dao
				.findFirst(
						"select r.name ,m.startTime,m.endTime from room r join meeting m on m.room=r.roomId where r.roomId=? and m.startTime>?",
						roomId, System.currentTimeMillis());
	}

	public List<Room> usableRooms(String start, String end) {
		return dao
				.find("SELECT * FROM room WHERE roomId NOT IN (SELECT r.roomId FROM room r JOIN meeting m ON m.room = r.roomId WHERE (? BETWEEN m.startTime AND m.endTime) OR (? BETWEEN m.startTime AND m.endTime))",
						start, end);
	}

}
