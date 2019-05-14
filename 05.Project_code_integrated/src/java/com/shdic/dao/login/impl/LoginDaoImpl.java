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
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Repository;

import com.shdic.conn.CreateConn;
import com.shdic.dao.dmgl.DmglDao;
import com.shdic.dao.login.LoginDao;

@SuppressWarnings("unchecked")
@Repository("loginDao")

public class LoginDaoImpl implements LoginDao {
	@Override
	public String searchUser(Map conditions) throws Exception {
		// TODO Auto-generated method stub
    	String result = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String email = (String) conditions.get("email");
    	String password = (String) conditions.get("password");
    	
//		+conditions.get("email") 
//		+conditions.get("password")
		try{
			conn =  (Connection) new CreateConn().createDBSession();
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb");  
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("select * from T_USER_INFO where EMAIL=? and PASSWORD=?");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			System.out.println("email:"+email+" password"+password);
			if (rs.next())
				{
					System.out.println("login success!");
					result = "success";
			    }
				
			else
				{
					System.out.println("login failed.");
					result = "The email or password is incorrect!";
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
	
	public DefaultTableModel listParkingArea() throws Exception{
		// TODO Auto-generated method stub
    	String result = "";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();

		try{
			System.out.println("before conn:out of create");
			conn =  (Connection) new CreateConn().createDBSession();
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb");  

			//conn.setAutoCommit(false);
			/**/
			StringBuffer sql = new StringBuffer("SELECT  PARKING_ID, COUNT(SLOT_ID) AVAILABLE_SPACES ,PRICE,CHARGING_FROM,CHARGING_TO FROM T_PARKING_SLOTS WHERE STATUS ='Available' GROUP BY PARKING_ID  ,PRICE, CHARGING_FROM,CHARGING_TO");
	    	DefaultTableModel   dtm   =   new   DefaultTableModel();
	    	String [] columnNames={"PARKING_ID","AVAILABLE_SPACES","PRICES","CHARGING_FROM","CHARGING_TO"};
	    	dtm=new DefaultTableModel(columnNames,0);
	    	if(conn==null){
	    		System.out.println("conn is null:");
	    	}
			ps = conn.prepareStatement(sql.toString());
			rs=ps.executeQuery();
			System.out.println("rs_getrows:"+rs.getRow());
			
			if(rs!=null){
				for (int i = 0; rs.next(); i++) 
				{
					Vector   data   =   new   Vector();
					data.add(rs.getString("PARKING_ID"));
					data.add(rs.getString("AVAILABLE_SPACES"));
					data.add(rs.getString("PRICE"));
					data.add(rs.getString("CHARGING_FROM"));
					data.add(rs.getString("CHARGING_FROM"));
					data.add(rs.getString("CHARGING_TO"));
					dtm.addRow(data);	
					System.out.println(dtm.getDataVector()+"\n");

				}
				return dtm;
			}else{
				return null;
			}
			//return null;
		}catch(Exception e){
			result = "error,please try again";	
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
	}
}
