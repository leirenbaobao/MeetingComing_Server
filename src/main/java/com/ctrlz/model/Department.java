package com.ctrlz.model;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
@SuppressWarnings("serial")
public class Department extends Model<Department> {

	public static final Department dao = new Department();

	public List<Department> findAll() {
		return Department.dao.find("select departmentId,name as department from department");
	}
}
