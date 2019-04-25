<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	if(session.getAttribute("USER")==null){
		session.setAttribute("USER","");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/page/js/jquery-easyui-1.4.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/page/js/jquery-easyui-1.4.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/page/js/jquery-easyui-1.4.2/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/page/js/jquery-easyui-1.4.2/themes/color.css">
	<script type="text/javascript" src="<%=path%>/page/js/jquery-easyui-1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/page/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/page/js/jquery-easyui-1.4.2/datagrid-detailview.js"></script>
	<script type="text/javascript" src="<%=path%>/page/js/jquery-easyui-1.4.2/datagrid-filter.js"></script>
	<script type="text/javascript" src="<%=path%>/page/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>	
   </head>

  <body>
			
  <div class="easyui-panel" title="新增代码"  iconCls="icon-search" style="width:99%;">
        <div style="padding:5px 10px 5px 10px">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
            <table cellpadding="5">
                <tr>
                    <td width='6%'>代码类别:</td>
                    <td><input class="easyui-combobox"  name="dmlb" id="dmlb" data-options="
	                    url:'<%=path%>/dmglAction!getDmlbs.action',
	                    valueField:'dmlb',
	                    textField:'dmlb',
	                    editable:false
	                    
	                   "></td>
                    <td  width='6%'>代码值:</td>
                    <td><input class="easyui-textbox"  name="dmz" id="dmz"  value=""></input></td>
               		<td  width='6%'>代码名称:</td>
                    <td><input class="easyui-textbox"  name="dmmc" id="dmmc"  value=""></input></td>
               		<td  width='6%'>代码描述:</td>
                    <td><input class="easyui-textbox"  name="dmms" id="dmms"  value=""></input></td>
                 </tr>
                 <tr>
                    <td width='6%'>代码状态:</td>
                    <td><select class="easyui-combobox" name="sfky" id="sfky" style="width:150px;">
							<option value="1" selected>有效</option>
							<option value="0">无效</option>
						</select></td>
               		<td  width='6%'>排序号:</td>
                    <td><input class="easyui-textbox"  name="pxsx" id="pxsx"  value=""></input></td>
                 </tr>
                
                 <tr>
                    <td colspan="10" align="center">
            		<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px" iconCls="icon-save">保存</a>
            		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()"  style="width:100px" iconCls="icon-clear">清空</a></td>
               		
                </tr> 
            </table>
        </form>
        </div>
    </div>
    
   <div id="menu" class="easyui-menu" style="width: 50px; display: none;">
			    <div onclick="showCpxx();">查看产品</div>
			</div>
    
	</body>
</html>

<script type="text/javascript">
function submitForm(){
		
            $('#ff').form('submit',{
            	url:'<%=path%>/dmglAction!saveOrUpdateDmxx.action?czlx=add',
            	onSubmit:function(){
            		var dmlb = $("#dmlb").combobox('getValues');
			       	if(dmlb==""){
			       		$.messager.alert("系统提示","代码类别不能为空！");
			       		return false;
			       	}
			       	var dmz = $("#dmz").val();
			       	if(dmz==""){
			       		$.messager.alert("系统提示","代码值不能为空！");
			       		return false;
			       	}
			       	var dmmc = $("#dmmc").val();
			       	if(dmmc==""){
			       		$.messager.alert("系统提示","代码名称不能为空！");
			       		return false;
			       	}
			       	
            	},
                success:function(data){ 
                	if(data!="true"){
                		$.messager.alert("系统提示",data);
                	}else{
                		$.messager.alert("操作提示", "新增成功！", "info", function () {  
					      	var currTab =  window.parent.$('#tt').tabs('getTab',"代码管理");
					      	if(currTab){
							    var url = $(currTab.panel('options').content).attr('src');
							    window.parent.$('#tt').tabs('update', {
							      tab : currTab,
							      options : {
							         content : window.parent.createFrame(url)
							      }
							     });
							    
							}
							window.parent.$('#tt').tabs('close','新建代码');
	               		}); 
                	}
                		
                	}
        			
            });
        }
        
</script>