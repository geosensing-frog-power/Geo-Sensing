package com.shdic.dao.dmgl;

import java.util.List;
import java.util.Map;


public interface DmglDao {


	String insertName(Map conditions)throws Exception;
	
	List getName(Map conditions)throws Exception;

	List updatePassword(Map conditions)throws Exception;
	
	List deleteName(Map conditions)throws Exception;
}
