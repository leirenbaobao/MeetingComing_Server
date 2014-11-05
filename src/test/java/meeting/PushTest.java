package meeting;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.ddpush.im.v1.client.appserver.Pusher;
import org.junit.Test;

public class PushTest {
	@Test
	public void test() {
		Pusher pusher;
		try {
			pusher = new Pusher("www.lofver.com", 9999, 1000);
			byte[] bs = md5Byte("qq");
			boolean result = pusher.push0x20Message(bs, "push".getBytes());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void test1() {
		System.out.println(md5Byte("1"));
	}

	public static byte[] md5Byte(String encryptStr) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			try {
				md.update(encryptStr.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md.digest();
	}
}
