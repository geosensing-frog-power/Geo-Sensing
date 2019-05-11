package com.shdic.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.ARRAY;
import oracle.sql.CharacterSet;

public class Test_search {

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		String result = "";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String id1 = new String();
//    	String id2 = new String();
    	  int oracleId = CharacterSet.ZHS16GBK_CHARSET;
    	  CharacterSet dbCharset = CharacterSet.make(oracleId);
		try{
			System.out.println("new oracle driver begin!");
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.177.128:1521:karldb", "karl", "karldb");  
			System.out.println("new oracle driver end!"+conn.equals(null));
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("select *from karl.t where id = ? " 
					);
			
			 Statement stmt = conn.createStatement();
			 rs = stmt.executeQuery("SELECT * FROM karl.t");
			 System.out.println ("rs" +rs.getRow());
			 while (rs.next()) {
				 ARRAY my_array = (ARRAY) (rs).getArray(1);

					// return the SQL type names, integer codes, 
					// and lengths of the columns
					System.out.println ("Array is of type " + my_array.getSQLTypeName());
					System.out.println ("Array element is of typecode " + my_array.getBaseType());
					System.out.println ("Array is of length " + my_array.length());

					// get Array elements
					String[] values = (String[]) my_array.getArray();
					for (int i = 0; i < values.length; i++) 
					{
					oracle.sql.CHAR out_value = new oracle.sql.CHAR(values[i], dbCharset);
					System.out.println(">> index " + i + " = " + out_value);
					}

			 }
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

