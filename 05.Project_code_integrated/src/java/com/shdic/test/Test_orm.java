package com.shdic.test;

/*
 * 使用javabean对象来封装一条记录
 * 使用List<javabean>存储多条记录
 */
public class Demo02 {
	public static void main(String[] args) {
//		single();
		mulity();
	}
	
	public static void single(){
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Emp emp =null;
		try {
			conn = JDBCUtil.getMysqlConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ps=conn.prepareStatement("select empname,salary,age from emp where id=?");
			ps.setObject(1, 1);
			rs =ps.executeQuery();
			
			while(rs.next()){
				emp=new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		System.out.println(emp.getUsername()+"--"+emp.getSalary()+"--"+emp.getAge());
		
	}
	
	public static void mulity(){
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<Emp> list= new ArrayList<Emp>();
		try {
			conn = JDBCUtil.getMysqlConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ps=conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setObject(1, 1);
			rs =ps.executeQuery();
			
			while(rs.next()){
				Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		//遍历List，就是遍历这一行的多列的信息
		for(Emp emp:list){
			System.out.println(emp.getUsername()+"--"+emp.getSalary()+"--"+emp.getAge());
		}
		
	}
}
