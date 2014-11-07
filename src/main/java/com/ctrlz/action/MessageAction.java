package com.ctrlz.action;

import java.util.HashMap;
import java.util.Map;

import com.ctrlz.service.MessageService;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

public class MessageAction extends Controller {
	private MessageService messageService = MessageService.messageService;

	public void query() {
		int sid = getParaToInt("staffId");
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", messageService.messages(sid));
		renderJson(JsonKit.toJson(m));
	}

	public void view() {
		int mid = getParaToInt("messageId");
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", 0);
		m.put("value", messageService.view(mid));
		renderJson(JsonKit.toJson(m));
	}
	
	public void delete() {
		int mid = getParaToInt("messageId");
		Map<String, Object> m = new HashMap<String, Object>();
		boolean b=false;
		try {
			b=messageService.delete(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.put("code", 0);
		m.put("value", b);
		renderJson(JsonKit.toJson(m));
	}

}
