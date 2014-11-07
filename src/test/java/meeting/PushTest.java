package meeting;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.joda.time.DateTime;
import org.junit.Test;

public class PushTest {
	// @Test
	// public void test() {
	// Pusher pusher;
	// try {
	// pusher = new Pusher("www.lofver.com", 9999, 1000);
	// byte[] bs = md5Byte("1");
	// boolean result = pusher.push0x20Message(bs, "push".getBytes());
	// System.out.println(result);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	@Test
	public void test1() {
		// System.out.println(EncryptionKit.md5Encrypt("1"));
	}

	public static byte[] md5Byte(String encryptStr) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(encryptStr.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return md.digest();
	}

	@Test
	public void test2() throws Exception {
		// byte[] bs = StringUtil.md5Byte("1");
		// for (byte b : bs) {
		// System.out.println(b);
		// }
	}

	@Test
	public void test3() {
		// List<Duration> lst = Arrays.asList(Duration.values());
		// for (Duration d : lst) {
		// System.out.println(d.getName());
		// System.out.println(d.getValue());
		// }
	}

	@Test
	public void test4() {
		System.out.println(new DateTime(Long.valueOf("1416770122432"))
				.plusMinutes(60).getMillis());
	}

}
