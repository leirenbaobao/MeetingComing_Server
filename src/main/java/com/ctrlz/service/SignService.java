package com.ctrlz.service;

import com.ctrlz.model.Staff;


public enum SignService {
	signService;
	public Staff login(String loginId, String password) {
		Staff s = new Staff();
		s = s.findFirst(
				"SELECT	s.id,s.name,s.gender,p.name AS position,d.name AS department "
						+ "FROM	staff s JOIN position p ON p.id = s.position "
						+ "JOIN department d ON d.id = s.department JOIN meeting m"
						+ " ON m.sponsor = s.id where loginId=? and password=?",
				loginId, password);
		if (s != null) {
			return s;
		}
		return null;

	}

	public Staff login(Staff model) {
		Staff s = new Staff();
		s = s.findFirst(
				"SELECT	s.id,s.name,s.gender,p.name AS position,d.name AS department "
						+ "FROM	staff s JOIN position p ON p.id = s.position "
						+ "JOIN department d ON d.id = s.department JOIN meeting m"
						+ " ON m.sponsor = s.id where loginId=? and password=?",
				model.get("loginId"), model.get("password"));
		if (s != null) {
			return s;
		}
		return null;
	}

}
