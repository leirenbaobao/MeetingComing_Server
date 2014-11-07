package com.ctrlz.kit;

import org.ddpush.im.util.StringUtil;
import org.ddpush.im.v1.client.appserver.Pusher;

import com.ctrlz.model.Message;

public class PushKit {
	private Pusher pusher;

	public PushKit() {
		try {
			pusher = new Pusher("www.lofver.com", 9999, 3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean pushMessage(Message message) throws Exception {
		byte[] bs = StringUtil.md5Byte(message.get("receiver").toString());
		return pusher.push0x20Message(bs,
				message.keep("messageId", "title", "type").toJson().getBytes());
	}

	public boolean push(Message message) throws Exception {
		byte[] bs = StringUtil.md5Byte(message.get("receiver").toString());
		boolean b = pusher.push0x10Message(bs);
		pusher.close();
		return b;
	}
}
