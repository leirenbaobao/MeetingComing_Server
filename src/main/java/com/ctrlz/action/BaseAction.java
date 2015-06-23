package com.ctrlz.action;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.ctrlz.model.Info;
import com.ctrlz.service.BaseService;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

public class BaseAction extends Controller {
	private BaseService baseService = BaseService.baseService;

	public void signIn() {
		Map<String, Object> m = new HashMap<String, Object>();
		Info info = baseService.signIn(getPara("loginId"), getPara("password"));
		if (info == null) {
			m.put("code", -1);
			m.put("value", "用户名或密码错误");
		} else {
			m.put("code", 0);
			m.put("value", info);
		}
		renderJson(JsonKit.toJson(m));
	}

	public void contacts() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", baseService.contacts());
		renderJson(JsonKit.toJson(m));
	}

	public void categorys() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", baseService.categorys());
		renderJson(JsonKit.toJson(m));
	}

	public void rooms() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", baseService.rooms());
		renderJson(JsonKit.toJson(m));
	}

	public void usedRooms() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", baseService.usedRooms());
		renderJson(JsonKit.toJson(m));
	}

	public void useableRooms() {
		String start = getPara("startTime");
		String duration = getPara("duration");
		String end = String.valueOf(new DateTime(Long.valueOf(start))
				.plusMinutes(Integer.valueOf(duration)).getMillis());
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", baseService.useableRooms(start, end));
		renderJson(JsonKit.toJson(m));
	}
}
