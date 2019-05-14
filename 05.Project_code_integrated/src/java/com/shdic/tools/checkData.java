package com.shdic.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class checkData {
	
    public checkData(){};
    
	public boolean emailValidation(String email) throws Exception{
	boolean result = false;
	Connection conn=null;ResultSet rs = null;
	PreparedStatement ps=null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb");  
		//conn.setAutoCommit(false);
		StringBuffer sql = new StringBuffer("select * from T_USER_INFO where EMAIL=?");
		ps = conn.prepareStatement(sql.toString());
		ps.setString(1, email);
		rs=ps.executeQuery();
		if (rs.next())
			{
				result = true;
		    }
			
		else
			{
				result = false;
			}
	}catch(Exception e){
		result = false;
		try{
			conn.rollback();
		}catch(SQLException ex){
			ex.printStackTrace();
			System.err.println("rollback error");
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
	return result;
	}
}
