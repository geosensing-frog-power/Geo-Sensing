<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	if(session.getAttribute("USER")==null){
		session.setAttribute("USER","");
	}
	
	String dmmc = request.getParameter("dmmc")==null?"":request.getParameter("dmmc");
	System.out.println("dmlb==before======="+dmmc);
	//dmmc=new String(dmmc.getBytes("ISO8859-1"),"UTF-8");
	//System.out.println("dmlb========="+dmmc);
	String result = "";
	
	/* if(!"".equals(dmmc)){
		String retStr = "";
		Connection conn=null;ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement ps=null;
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); //MYSQL驱动
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/orcl", "root", "root"); 
		//conn.setAutoCommit(false);
		StringBuffer sql = new StringBuffer("insert into test (name) values (?) ");
		ps = conn.prepareStatement(sql.toString());
		ps.setString(1, dmmc);
		ps.executeUpdate();
		//conn.commit();
		result = "Success!";
		dmmc = "";
	} */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
   </head>

  <body>
        <form name="insertname" class="easyui-form" method="post" action="<%=path%>/dmglAction!insertName.action">
            <table cellpadding="5">
                <tr>
               		<td  width='120px'>Insert Name:</td>
                    <td><input   name="name" id="name"  value=""></input> <button onclick="insertnameForm();" type="button">Click Me!</button></td>
                 </tr>
            </table>
        </form>
        
        
        <form name="getname" class="easyui-form" method="post" action="<%=path%>/dmglAction!getName.action">
             <table cellpadding="5">
                <tr>
               		<td  width='120px'>Search Name:</td>
                    <td><input   name="name" id="name"  value=""></input> <button onclick="getnameForm();" type="button">Click Me!</button></td>
                	<td  width='400px'>Confidentiality :In this case,hacker use this input box to search for important info.</td>
                 </tr>
            </table>
        </form>
        
        <form name="updatepassword" class="easyui-form" method="post" action="<%=path%>/dmglAction!updatePassword.action">
             <table cellpadding="5">
                <tr>
               		<td  width='120px'>Update password:</td>
                    <td><input   name="password" id="password"  value=""></input> <button onclick="updatepasswordForm();" type="button">Click Me!</button></td>
                 	<td  width='400px'>Integrity:   In this case,hacker use this input box to update other's password</td>
                 </tr>
            </table>
        </form>
        
        
        <form name="deletename" class="easyui-form" method="post" action="<%=path%>/dmglAction!deleteName.action">
             <table cellpadding="5">
                <tr>
               		<td  width='120px'>Delete Name:</td>
                    <td><input   name="name" id="name"  value=""></input> <button onclick="deletenameForm();" type="button">Click Me!</button></td>
                    <td  width='400px'>Availability:In this case,hacker use this input box to delete all account</td>
                 </tr>
            </table>
        </form>
        
        <%=result %>
    
    
	</body>
</html>
<script type="text/javascript">
function insertnameForm(){
	document.insertname.submit();
}

function getnameForm(){
	document.getname.submit();
}

function updatepasswordForm(){
	document.updatepassword.submit();
}

function deletenameForm(){
	document.deletename.submit();
}
    </script>