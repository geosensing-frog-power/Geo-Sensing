package com.shdic.dao.login;

import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

public interface LoginDao {
	String searchUser(Map conditions) throws Exception;
	
	DefaultTableModel listParkingArea() throws Exception;
}
