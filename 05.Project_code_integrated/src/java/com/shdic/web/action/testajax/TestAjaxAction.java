package com.shdic.web.action.testajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.shdic.test.Countries;
import com.shdic.web.action.BaseAction;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("unchecked")
@ParentPackage("struts-default")
@Namespace("/")
@Action(value="testAjaxAction")
public class TestAjaxAction extends BaseAction {

	public String testAjax(){
		String name ="karl";
		String email ="123@123.com";
		
		Countries c1 =new Countries("A1","B1");
		Countries c2 =new Countries("A2","B2");
		ArrayList<Countries> country=new ArrayList<Countries>();
		country.add(c1);
		country.add(c2);

		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(country, new TypeToken<List<Countries>>(){}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
