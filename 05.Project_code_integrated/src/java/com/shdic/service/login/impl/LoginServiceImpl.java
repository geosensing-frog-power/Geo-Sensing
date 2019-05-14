package com.shdic.service.login.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.table.DefaultTableModel;

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
	public String searchUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  loginDao.searchUser(conditions);
	}
	
	
	@Override
	public DefaultTableModel listParkingArea() throws Exception{
		// TODO Auto-generated method stub
		return  loginDao.listParkingArea();
	}
}
