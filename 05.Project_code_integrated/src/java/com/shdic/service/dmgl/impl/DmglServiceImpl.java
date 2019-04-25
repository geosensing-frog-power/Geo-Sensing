package com.shdic.service.dmgl.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shdic.dao.dmgl.DmglDao;
import com.shdic.service.dmgl.DmglService;

@Service("dmglService")
public class DmglServiceImpl implements DmglService{

	@Resource(name="dmglDao")
	private DmglDao dmglDao;


	Logger logger = LoggerFactory.getLogger(DmglServiceImpl.class);


	@Override
	public String insertName(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  dmglDao.insertName(conditions);
	}

	@Override
	public List getName(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  dmglDao.getName(conditions);
	}
	
	@Override
	public List updatePassword(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  dmglDao.updatePassword(conditions);
	}
	@Override
	public List deleteName(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return  dmglDao.deleteName(conditions);
	}
}
