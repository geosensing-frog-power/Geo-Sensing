package com.shdic.dao.dmgl.impl;

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

import com.shdic.conn.CreateConn;
import com.shdic.dao.dmgl.DmglDao;

@SuppressWarnings("unchecked")
@Repository("dmglDao")

public class DmglDaoImpl  implements DmglDao{
	

	@Override
	public String insertName(Map conditions) throws Exception {
    	// TODO Auto-generated method stub
    	String retStr = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String name = (String) conditions.get("name");
		try{
			conn =  (Connection) new CreateConn().createDBSession();
			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //ORACLE驱动
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 
			//Class.forName("com.mysql.jdbc.Driver").newInstance(); //ORACLE驱动
			//conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1", "root", "root"); 
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("insert into t_user (name) values (?) ");
			
			System.out.println("SQL="+sql+"*"+name);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, name);
			ps.executeUpdate();
			conn.commit();
			retStr = "Success";
				
		}catch(Exception e){
			retStr = "error,please try again";	
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
		return retStr;
	}

	@Override
	public List getName(Map conditions) throws Exception {
    	// TODO Auto-generated method stub
    	String retStr = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String name = (String) conditions.get("name");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //ORACLE driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 
			
			//SQL injection
			StringBuffer sql = new StringBuffer("select name from t_user where name = '"+name+"'");
				
			//prevent sqli
			//StringBuffer sql = new StringBuffer("select * from t_user where name = ? ");
			System.out.println("SQL="+sql);
			ps = conn.prepareStatement(sql.toString());
			//prevent sqli
			//ps.setString(1, name);

			rs = ps.executeQuery();
		    reList = getPreInfo(rs,ps.toString());
		    retStr = "Success";
				
		}catch(Exception e){
			retStr = "Failed!";	
			System.out.println("SQL,Failed!");
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("Rollback!");
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
		return reList;
	}
	
	@Override
	public List updatePassword(Map conditions) throws Exception {
    	// TODO Auto-generated method stub
    	String retStr = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String password = (String) conditions.get("password");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //ORACLE驱动
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 
			//StringBuffer sql = new StringBuffer("insert into t_user (name) values (?) ");
			//ps.setString(1, name);
			StringBuffer sql = new StringBuffer("update t_user set password = '"+password+"' where name='KARL'");
			 System.out.println("SQL="+sql);
			ps = conn.prepareStatement(sql.toString());
			retStr = "Success";
			
			ps.executeUpdate();

				
		}catch(Exception e){
			retStr = "Failed!";	
			System.out.println("SQL,Failed!");
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
		return reList;
	}
	
	
	
	@Override
	public List deleteName(Map conditions) throws Exception {
    	// TODO Auto-generated method stub
    	String retStr = "";
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	List reList = new ArrayList();
    	String name = (String) conditions.get("name");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //Oracle驱动
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb"); 
			//StringBuffer sql = new StringBuffer("insert into t_user (name) values (?) ");
			//ps.setString(1, name);
			StringBuffer sql = new StringBuffer("delete karl.t_user  where name='"+name+"'");
			 System.out.println("SQL="+sql);
			ps = conn.prepareStatement(sql.toString());
			retStr = "Success";
			
			ps.executeUpdate();

		}catch(Exception e){
			retStr = "Failed!";
			System.out.println("SQL,Failed!");
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
		return reList;
	}
	
	
	
	//查询返回集合
	public List getPreInfo(ResultSet rs,String ps) throws java.sql.SQLException{
		List list = new ArrayList();
		try{
			if(rs == null){return Collections.EMPTY_LIST;}
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			
			Map rowData = new HashMap();
			while(rs.next()){
				rowData = new HashMap(columnCount);
				for(int i = 1;i<=columnCount; i++){
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
			}
			
			
			
			
		}catch(SQLException e){
			throw e;
		}/*finally{
			DBAdapter.close(rs);
		}*/
		return list;
	}

}
