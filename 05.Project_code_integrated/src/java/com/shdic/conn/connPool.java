package com.shdic.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class connPool {
	public String createDBSession() throws Exception {
		String retStr = "";
	   	PreparedStatement ps=null;
	   	ResultSet rs = null;
    	List reList = new ArrayList();
    	Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //ORACLE驱动
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 

			StringBuffer sql = new StringBuffer("insert into t_user (name) values (?) ");
			ps = conn.prepareStatement(sql.toString());
			

			retStr = "Success";
				
		}catch(Exception e){
			retStr = "操作失败，请重试！";	
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("回滚执行失败！");
			}
			e.printStackTrace();
			throw e;			
		}finally{
			if (rs != null)
	        {
	            try
	            {
	                rs.close();
	            } catch (Exception e)
	            {
	            }
	        }
			if (ps != null)
	        {
	            try
	            {
	            	ps.close();
	            } catch (Exception e)
	            {
	            }
	        }
			 if (conn != null)
		        {
		            try
		            {
		                conn.close();
		            } catch (Exception e)
		            {
		            }
		        }
		        conn = null;
		}
		return retStr;
	}
}
