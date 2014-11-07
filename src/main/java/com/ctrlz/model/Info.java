package com.ctrlz.model;
import com.jfinal.plugin.activerecord.Model;
@SuppressWarnings("serial")
public class Info extends Model<Info> {

	public static final Info dao = new Info();

	public Info getInfo(int id) {
		if (id != 0) {
			return Info.dao.findFirst("select * from info where staffId=?", id);
		}
		return null;
	}
}
