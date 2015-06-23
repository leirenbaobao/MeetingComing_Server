package com.ctrlz.model;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
@SuppressWarnings("serial")
public class Category extends Model<Category> {

	public static final Category dao = new Category();

	// TODO:会议类型表变动时清除cache
	public List<Category> findAll() {
		return dao.findByCache("base", "categorys", "select * from category");
	}
}
