package meeting;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ctrlz.model.Meeting;
import com.ctrlz.model.Room;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

public class DbTest {
	@BeforeClass
	public static void init() {
		DruidPlugin druidPlugin = new DruidPlugin(
				"jdbc:mysql://127.0.0.1/meeting?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull",
				"root", "root");
		druidPlugin.start();
		new ActiveRecordPlugin(druidPlugin)
		// .addMapping("staff", "staffId", Staff.class)
		// .addMapping("participant", "participantId", Participant.class)
				.addMapping("meeting", "meetingId", Meeting.class)
				// .addMapping("app", "appId", App.class)
				// .addMapping("category", "categoryId", Category.class)
				// .addMapping("department", "departmentId", Department.class)
				// .addMapping("message", "messageId", Message.class)
				// .addMapping("position", "positionId", Position.class)
				.addMapping("room", "roomId", Room.class)
				// .addMapping("info", "staffId", Info.class).setShowSql(true)
				.start();
		new EhCachePlugin().start();
	}

	@Test
	public void test() {

		System.out.println(Room.dao
				.usableRooms("141677012222", "1416770122433").size());
		// Staff s = Staff.dao.findById(1);
		// System.out.println(s.toJson());
	}

	@Test
	public void saveStaff() {
		// Staff s = new Staff();
		// System.out.println(s.set("loginId", "2").set("password", "2")
		// .set("name", "bb").set("gender", "男").set("position", 1)
		// .set("department", 1).save());
	}

	@Test
	public void saveMeeting() {
	}

	@Test
	public void meeting() {
		// System.out.println(Meeting.dao.findById(2).toJson());
	}

	@Test
	public void duration() {
		// for (Duration d : Duration.values()) {
		// // System.out.println(d);
		// System.out.println(d.getName());
		// System.out.println(d.getValue());
		// }
	}

	@Test
	public void staffLogin() {
	}

	@Test
	public void contact() {
		// System.out.println(JsonKit.toJson(BaseService.baseService.contacts()));
	}

	@Test
	public void messages() {
		// System.out.println(JsonKit.toJson(MessageService.messageService
		// .messages(1)));
	}

	@Test
	public void deleteMessage() {
		// System.out.println(Type.broadcastMsg.getValue() == Message.dao
		// .findById(1).getInt("type"));
	}

	@Test
	public void pushMessage() throws Exception {
	}

	@Test
	public void message() throws Exception {
		// System.out.println(MessageService.messageService.view(4).toJson());
	}

	@Test
	public void time() {
		// DateTime dt = new DateTime(2014, 11, 13, 20, 6, 0);
		// Date date = dt.toDate();
		// System.out.println(date);
	}
}
