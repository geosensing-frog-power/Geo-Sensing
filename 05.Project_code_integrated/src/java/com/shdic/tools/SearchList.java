//package com.shdic.tools;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
////import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.swing.table.DefaultTableModel;
//import org.apache.struts2.ServletActionContext;
//import org.springframework.stereotype.Repository;
//
//import com.shdic.dao.dmgl.DmglDao;
//import com.shdic.dao.login.LoginDao;
//
//
//@Repository("loginDao")
//
//public class SearchList  {
//	@SuppressWarnings("null")
//	
//	
//	
//	 public static void main(String[] args) {
//		try {
//
//			select();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   }
//	
//	
//	public static String select() throws Exception {
//		// TODO Auto-generated method stub
//    	String result = "";
//    	Connection conn=null;ResultSet rs = null;
//    	PreparedStatement ps=null;
//    	String parkingName = "PARKING_A";
//    	ResultSetMetaData rms=null;
// //   	ArrayList<String> parkingN = new ArrayList<String>();
////    	ArrayList<String> slotNum = new ArrayList<String>();
////		+conditions.get("email") 
////		+conditions.get("password")
//    	DefaultTableModel   dtm   =   new   DefaultTableModel();
//    	String [] columnNames={"PARKING_ID","SLOT_ID","PARKING_STATION","STATUS"};
//    	dtm=new DefaultTableModel(columnNames,0);
//		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.19.110:1521:karldb", "karl", "karldb");  
//			//conn.setAutoCommit(false);
//			StringBuffer sql = new StringBuffer("select * from T_PARKING_SLOTS where PARKING_STATION=? and status =1");
//			ps = conn.prepareStatement(sql.toString());
//			ps.setString(1, parkingName);
//			rs=ps.executeQuery();
//			for (int i = 0; rs.next(); i++) 
//			{
//				Vector   data   =   new   Vector();
//				data.add(rs.getString("PARKING_ID"));
//				data.add(rs.getString("PARKING_STATION"));
//				data.add(rs.getString("SLOT_ID"));
//				data.add(rs.getString("STATUS"));
//				dtm.addRow(data);
//				
//			}
//			System.out.println("before select");
//			System.out.println(dtm.getValueAt(2,dtm.findColumn("SLOT_ID")));
//			System.out.println("after select");
//			System.out.println(dtm.getDataVector()+"\n");
//		}catch(Exception e){
//			result = "error,please try again";	
//			try{
//				conn.rollback();
//			}catch(SQLException ex){
//				ex.printStackTrace();
//				System.err.println("rollback error");
//			}
//			e.printStackTrace();
//			throw e;			
//		}finally{
//			if (rs != null)
//	        {
//	            try
//	            {
//	                rs.close();
//	            } catch (Exception e)
//	            {
//	            }
//	        }
//			if (ps != null)
//	        {
//	            try
//	            {
//	            	ps.close();
//	            } catch (Exception e)
//	            {
//	            }
//	        }
//			 if (conn != null)
//		        {
//		            try
//		            {
//		                conn.close();
//		            } catch (Exception e)
//		            {
//		            }
//		        }
//		        conn = null;
//		}
//		return result;
// }
//}
