package com.ctrlz.service;

import java.util.List;

import com.ctrlz.model.Category;
import com.ctrlz.model.Info;
import com.ctrlz.model.Room;
import com.ctrlz.model.Staff;

public enum BaseService {
	baseService;

	public Info signIn(String loginId, String password) {
		int id = Staff.dao.login(loginId, password);
		if (id == 0) {
			return null;
		} else {
			return Info.dao.getInfo(id);
		}
	}

	public List<Staff> contacts() {
		return Staff.dao.findAll();
	}

	public List<Category> categorys() {
		return Category.dao.findAll();
	}

	public List<Room> rooms() {
		return Room.dao.findAll();
	}

	public List<Room> usedRooms() {
		return Room.dao.usedRooms();
	}

	public List<Room> useableRooms(String start, String end) {
		return Room.dao.usableRooms(start, end);
	}
}
