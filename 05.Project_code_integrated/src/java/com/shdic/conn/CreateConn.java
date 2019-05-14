package com.shdic.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateConn {
	 public static void main(String[] args) {
		 try {
			Connection conn = createDBSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	public static Connection createDBSession() throws Exception {
		String retStr = "";
	   	PreparedStatement ps=null;
	   	ResultSet rs = null;
    	List reList = new ArrayList();
    	Connection conn=null;
		try{
			//System.out.println("before conn is created");
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //ORACLE驱动
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 
			if(conn !=null){
				System.out.println("conn is not null");
				return conn;
			}else{
				System.out.println("conn is null");
				return null;
			}
		}catch(Exception e){
			retStr = "create conn fail!";	
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("rollback fail!");
			}
			e.printStackTrace();
			throw e;			
		}
	}	
}
