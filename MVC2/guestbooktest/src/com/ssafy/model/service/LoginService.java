package com.ssafy.model.service;

import com.ssafy.model.MemberDto;

public interface LoginService {

	public MemberDto login(String userid, String userpwd) throws Exception;
	
}
