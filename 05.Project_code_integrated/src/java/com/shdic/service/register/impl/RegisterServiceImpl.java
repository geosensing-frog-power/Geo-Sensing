package com.shdic.service.register.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.shdic.dao.register.RegisterDao;
import com.shdic.service.register.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Resource(name="registerDao")
	private RegisterDao registerDao;

	Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	@Override
	public String registerUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  registerDao.registerUser(conditions);
	}

}
