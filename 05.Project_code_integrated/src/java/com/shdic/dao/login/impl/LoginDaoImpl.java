package com.shdic.dao.login.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shdic.dao.dmgl.DmglDao;
import com.shdic.dao.login.LoginDao;

@SuppressWarnings("unchecked")
@Repository("loginDao")

public class LoginDaoImpl implements LoginDao {

	@Override
	public String insertUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
		return "successful!~ dao";
	}

}
