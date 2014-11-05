package meeting;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ctrlz.enums.Duration;
import com.ctrlz.model.Meeting;
import com.ctrlz.model.Participant;
import com.ctrlz.model.Staff;
import com.ctrlz.service.SignService;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.Sqlite3Dialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

public class DbTest {
	@BeforeClass
	public static void init() {
		DruidPlugin druidPlugin = new DruidPlugin("jdbc:sqlite:db/test.db",
				"root", "root", "org.sqlite.JDBC");
		druidPlugin.start();
		new ActiveRecordPlugin(druidPlugin).addMapping("staff", Staff.class)
				.addMapping("participant", Participant.class)
				.addMapping("meeting", Meeting.class).setShowSql(true)
				.setDialect(new Sqlite3Dialect()).start();
		new EhCachePlugin().start();
	}

	@Test
	public void test() {
		Staff s = Staff.dao.findById(1);
		System.out.println(s.toJson());
	}

	@Test
	public void saveStaff() {
		Staff s = new Staff();
		System.out.println(s.set("loginId", "2").set("password", "2")
				.set("name", "bb").set("gender", "男").set("position", 1)
				.set("department", 1).save());
	}

	@Test
	public void saveMeeting() {
		Meeting m = new Meeting();
		System.out.println(m.set("name", "员工培训").set("subject", "培训")
				.set("launcher", 1).set("startTime", new Date())
				.set("endTime", new DateTime().plusHours(1).toDate())
				.set("duration", 60).set("type", "部门会议").save());
		List<Integer> ss = Arrays.asList(1, 2, 3, 4);
		System.out.println(m.get("id"));
		for (Integer integer : ss) {
			new Participant().set("mid", m.get("id")).set("sid", integer)
					.save();
		}
	}
	@Test
	public void meeting() {
		System.out.println(Meeting.dao.findById(2).toJson());
	}
	@Test
	public void duration() {
		for (Duration d : Duration.values()) {
			// System.out.println(d);
			System.out.println(d.getName());
			System.out.println(d.getValue());
		}

	}

	@Test
	public void service() {
		Staff s = new Staff();
		s.set("loginId", "2").set("password", "2");
		System.out.println(SignService.signService.login(s));
	}
}
