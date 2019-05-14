package com.shdic.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.shdic.bean.SlotBean;

public class FetchData {
	
	
	 public static void main(String[] args) {
		try {

			fetch();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	
	public static String fetch() throws Exception {
		// TODO Auto-generated method stub
   	String result = "";
   	Connection conn=null;ResultSet rs = null;
   	PreparedStatement ps=null;
   	String parkingName = "PARKING_A";
   	ResultSetMetaData rms=null;
   	SlotBean slot = new SlotBean();
   	ArrayList<SlotBean> slots =new ArrayList<SlotBean>();
//   	ArrayList<String> parkingN = new ArrayList<String>();
//   	ArrayList<String> slotNum = new ArrayList<String>();
//		+conditions.get("email") 
//		+conditions.get("password")
   	DefaultTableModel   dtm   =   new   DefaultTableModel();
   	String [] columnNames={"PARKING_ID","SLOT_ID","PARKING_STATION","STATUS"};
   	dtm=new DefaultTableModel(columnNames,0);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //oracle driver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.109.110:1521:karldb", "karl", "karldb");  
			//conn.setAutoCommit(false);
			StringBuffer sql = new StringBuffer("select * from T_PARKING_SLOTS where status ='01'");
			ps = conn.prepareStatement(sql.toString());
			//ps.setString(1, parkingName);
			rs=ps.executeQuery();
			
//			private String parking_id;
//			private String slot_id;
//			private String parking_station;
//			private String status;
//			private String price ;
			
			for (int i = 0; rs.next(); i++) 
			{	
//				slot = new SlotBean(rs.getString("PARKING_ID")
//						,rs.getString("SLOT_ID")
//						,rs.getString("PARKING_STATION")
//						,rs.getString("STATUS")
//						,rs.getString("PRICE")
//						);
				System.out.println("i="+i);
				System.out.println(rs.getString("SLOT_ID"));
//				slot.setParking_id(rs.getString("PARKING_ID");
//				slot.setParking_station(rs.getString("PARKING_STATION"));
//				slot.setSlot_id(rs.getString("SLOT_ID"));
//				slot.setStatus(rs.getString("STATUS"));
				
				slots.add(slot);
//				Vector   data   =   new   Vector();
//				data.add(rs.getString("PARKING_ID"));
//				data.add(rs.getString("PARKING_STATION"));
//				data.add(rs.getString("SLOT_ID"));
//				data.add(rs.getString("STATUS"));
//				dtm.addRow(data);
			}
			System.out.println("before select");
			//System.out.println(dtm.getValueAt(2,dtm.findColumn("SLOT_ID")));
			System.out.println("arraylist size:"+slots.size());
			System.out.println("after select");
			//System.out.println(dtm.getDataVector()+"\n");
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
}
