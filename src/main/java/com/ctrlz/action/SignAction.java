package com.ctrlz.action;

import com.ctrlz.model.Staff;
import com.ctrlz.service.SignService;
import com.jfinal.core.Controller;

public class SignAction extends Controller {
	private SignService signService = SignService.signService;

	public void index() {
		signService.login(getModel(Staff.class));
	}

}
