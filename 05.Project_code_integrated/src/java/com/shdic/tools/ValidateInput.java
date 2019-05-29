package com.shdic.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


@Service("validateInput")
public class ValidateInput {
	
	String regStr = "";
	public boolean validatePassword(String inputStr){
		//password length from 8-16 , combined with number & character
		regStr="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		return inputStr.matches(regStr);
	};
	
	public boolean validateStr(String inputStr,Integer begin,Integer end){
		//characters allowed only
		regStr="^[A-Za-z]{"+begin+","+end+"}$";
		return inputStr.matches(regStr);
	};
	
	public boolean validateNum(String inputNum,Integer begin,Integer end){  
	    //number allowed only
		    regStr="^[0-9]{"+begin+","+end+"}$";
	        Pattern pattern = Pattern.compile(regStr);
	        Matcher matcher = pattern.matcher(inputNum);  
	          
	        if (matcher.matches())  
	        {  
	            return true;  
	        }  
	        return false;  
	    }  
	
	
	public boolean validateEmail(String inputEmail){ 
	    //E-mail pattern allowed only :   xxx@xxx.xxx
	    regStr="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(inputEmail);  
          
        if (matcher.matches())  
        {  
            return true;  
        }  
        return false;  
	}
	
	public void setRegStr(String newStr){
		regStr = newStr;
	}
	
	public String getRegStr(){
		return regStr;
	}
	
}
