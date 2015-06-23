package com.ctrlz.service;

import java.util.List;

import com.ctrlz.enums.Type;
import com.ctrlz.model.Message;

public enum MessageService {
	messageService;
	public List<Message> messages(int sid) {
		List<Message> messages = Message.dao.findAll(sid);
		return messages;
	}

	public boolean delete(int mid) {
		Message m = Message.dao.findById(mid);
		if (m != null && Type.broadcastMsg.getValue() == m.getInt("type")) {
			return m.delete();
		} else {
			return false;
		}
	}

	public Message view(int mid) {
		return Message.dao.findOne(mid);
	}
}
