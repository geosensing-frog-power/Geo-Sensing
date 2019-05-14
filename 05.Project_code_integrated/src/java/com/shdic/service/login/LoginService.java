package com.shdic.service.login;

import java.util.Map;

import javax.swing.table.DefaultTableModel;

public interface LoginService {
	String searchUser(Map conditions) throws Exception;
	
	DefaultTableModel listParkingArea() throws Exception;
}
