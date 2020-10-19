package com.ssafy.model.service;

import com.ssafy.model.MemberDto;
import com.ssafy.model.dao.LoginDao;
import com.ssafy.model.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao;
	
	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}
	
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		if(userid == null || userpwd == null)
			return null;
		return loginDao.login(userid, userpwd);
	}

}
