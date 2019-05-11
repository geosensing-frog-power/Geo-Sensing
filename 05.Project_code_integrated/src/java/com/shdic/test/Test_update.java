package com.shdic.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test_update {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	String result = "";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String id1 = new String();
    	String id2 = new String();
		try{
			System.out.println("new oracle driver begin!");
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.177.128:1521:karldb", "karl", "karldb");  
			System.out.println("new oracle driver end!"+conn.equals(null));
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("update karl.t set id =? " +
					"where id = ? ");
			//StringBuffer sql2 = new StringBuffer("update karl.t set id =2 where id = 1 "
				//);
			id1 = "1";
			id2 = "3";
//			
			//System.out.println("sql=》0"+sql2);
			//ps = conn.prepareStatement(sql2.toString());
			//System.out.println("SQL="+sql+"*"+email);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, id1);
			ps.setString(2, id2);
			ps.executeUpdate();
			conn.commit();
//			System.out.println("register success!");
//			result = "success";
				
		}catch(Exception e){
			result = "error,please try again";	
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("rollback error");
			}
			e.printStackTrace();
			//throw e;			
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
	}

}
