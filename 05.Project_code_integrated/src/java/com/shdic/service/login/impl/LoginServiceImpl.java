package com.shdic.service.login.dmpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.shdic.dao.login.LoginDao;
import com.shdic.service.login.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDao loginDao;


	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


	@Override
	public String insertUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  loginDao.insertUser(conditions);
	}

}
