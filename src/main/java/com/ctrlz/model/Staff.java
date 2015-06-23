package com.ctrlz.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Staff extends Model<Staff> {

	public static final Staff dao = new Staff();

	public int login(String loginId, String password) {
		Staff staff = dao.findFirst(
				"select * from staff where loginId=? and password=?", loginId,
				password);
		return staff == null ? 0 : staff.getInt("staffId");

	}

	// TODO:部门和员工表变动时清除cache
	public List<Staff> findAll() {
		return dao
				.findByCache(
						"base",
						"contacts",
						"SELECT s.staffId,s.name,p.name AS position,d.name AS department FROM	staff s JOIN position p ON p.positionId = s.position JOIN department d ON d.departmentId = s.department");
	}
}
