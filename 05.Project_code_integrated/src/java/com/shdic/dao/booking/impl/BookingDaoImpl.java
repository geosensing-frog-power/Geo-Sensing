package com.shdic.dao.booking.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shdic.bean.SlotBean;
import com.shdic.conn.CreateConn;
import com.shdic.dao.booking.BookingDao;

@SuppressWarnings("unchecked")
@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao {
	
	@Override
	public ArrayList<SlotBean> listSlots(String parking_id) throws Exception {
		ArrayList<SlotBean> listSlots = new ArrayList();
		SlotBean slot = null;
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	
		try{
			conn =  (Connection) new CreateConn().createDBSession();	

			//conn.setAutoCommit(false);
//			StringBuffer sql = new StringBuffer(
//				"SELECT  PARKING_ID, COUNT(SLOT_ID) AVAILABLE_SPACES ,PRICE,CHARGING_FROM,CHARGING_TO " +
//				"FROM T_PARKING_SLOTS WHERE STATUS ='Available' and PARKING_ID=? " +
//				"GROUP BY PARKING_ID  ,PRICE, CHARGING_FROM,CHARGING_TO "
//				);
			StringBuffer sql = new StringBuffer(
					"SELECT  PARKING_ID,SLOT_ID,STATUS,PRICE,CHARGING_FROM,CHARGING_TO " +
					"FROM T_PARKING_SLOTS " +
					"WHERE STATUS ='Available' AND PARKING_ID=? "	
				);
				System.out.println("SQL="+sql+"*"+parking_id);
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, parking_id);
				rs = ps.executeQuery();
				//conn.commit();
				// create slot bean , add it to Arrarylist 
				if (rs!=null){
					for (int i = 0; rs.next(); i++){	
						slot = new SlotBean(rs.getString("PARKING_ID")
								,rs.getString("SLOT_ID")
								,rs.getString("STATUS")
								,rs.getString("PRICE")
								,rs.getString("CHARGING_FROM")
								,rs.getString("CHARGING_TO"));
						listSlots.add(slot);	
					}
					System.out.println("listing slots success!");
					
				}else{
					System.out.println("listing slots fail!");
					return null;
				}

		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("listing slots rollback error");
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
		
		return listSlots;
	}

	
	
	@Override
	public ArrayList<SlotBean> bookingSlot(String parking_id,String slot_id, String email) throws Exception {
		ArrayList<SlotBean> listSlots = new ArrayList<SlotBean>();
		SlotBean slot = null;
    	Connection conn=null;ResultSet rs = null;
    	PreparedStatement ps=null;
    	String charging_from = null;
    	String charging_to = null;
    	String price = null;
    	String amout = null;
		try{			
			new CreateConn();
			conn =  (Connection) CreateConn.createDBSession();	
			conn.setAutoCommit(false);
			
			//Transaction begins : 
			//Step 1 : update slot status from 'Available' => 'Unavailable' , 
			//return ArrayList with SlotBean.status = 'Unavailable' 


			//update slot status
			StringBuffer sql = new StringBuffer(
					"UPDATE KARL.T_PARKING_SLOTS SET STATUS = 'Unavailable' " +
					"WHERE  PARKING_ID = ? AND SLOT_ID = ? " 	
				);
				System.out.println("SQL="+sql+"*"+parking_id+slot_id);
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, parking_id);
				ps.setString(2, slot_id);
				ps.executeUpdate();
			
			//Query slotBean => ArrayList -> back to booking page to update slot status
				sql = new StringBuffer(
						"SELECT  PARKING_ID,SLOT_ID,STATUS,PRICE,CHARGING_FROM,CHARGING_TO " +
						"FROM T_PARKING_SLOTS " +
						"WHERE PARKING_ID=? and SLOT_ID=? "	
					);
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, parking_id);
				ps.setString(2, slot_id);
				rs = ps.executeQuery();		

				if (rs!=null){
					for (int i = 0; rs.next(); i++){	
						slot = new SlotBean(rs.getString("PARKING_ID")
								,rs.getString("SLOT_ID")
								,rs.getString("STATUS")
								,rs.getString("PRICE")
								,rs.getString("CHARGING_FROM")
								,rs.getString("CHARGING_TO"));
						listSlots.add(slot);	
						System.out.println("before slot is null?"+slot.equals(null));
				    }
					System.out.println("listing single slots success!");
					System.out.println("after slot is null?"+slot.equals(null));
					
				}else{
					System.out.println("listing single slots fail!");
					return null;
				}
				//Step 2 : Booking slot , create booking order including calculate time	
				//It assumes that customer has paid.
				price = slot.getPrice();
				StringBuffer amoutSql = new StringBuffer(
						"(CASE  WHEN to_char(sysdate,'HH24:mi') > '06:00' and to_char(sysdate,'HH24:mi') < '07:00' "+
						"THEN 1"+
						"WHEN to_char(sysdate,'HH24:mi') >= '07:00' and to_char(sysdate,'HH24:mi') <= '15:00' "+
						"THEN 2"+
						"WHEN to_char(sysdate,'HH24:mi') > '15:00' and to_char(sysdate,'HH24:mi') < '16:00' " +
						"THEN 1 " +
						"ELSE 0  END) * " + price
						);
				sql = new StringBuffer(
						"INSERT INTO KARL.T_ORDER_DETAILS VALUES " +
						"(KARL.Q_ORDER_DETAILS.NEXTVAL" +
						",?" +
						",?" +
						",SYSDATE" +
						",SYSDATE+120/1440" +
						",KARL.Q_ORDER_DETAILS_RECEPIT.NEXTVAL" +
						",'PAID'" +
						"," +amoutSql+
						",?) "
					);
				System.out.println("create order sql=>"+sql);
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, parking_id);
				ps.setString(2, slot_id);
				ps.setString(3, email);
				ps.executeUpdate();		
				
				//Step 3 : Send email with receipt 
				
				
				
				//after commit & traction ends 
				conn.commit();			
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
				System.err.println("listing slots rollback error");
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
		
		return listSlots;
	}
}
