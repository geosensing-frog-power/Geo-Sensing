package com.shdic.test;

import com.shdic.tools.ValidateInput;

public class Test {

public static void main(String[] args) throws Exception {

String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";

ValidateInput va = new ValidateInput();

//System.out.println(va.validatePassword("123"));
//System.out.println(va.validatePassword("1234aaaa3"));
System.out.println(va.validateStr("123",1,3));
System.out.println(va.validateStr("abc",1,3));
System.out.println(va.validateStr("1234aaa@a3",1,3));
System.out.println(va.validateStr("Aaaaaa@aa.com",1,3));
System.out.println(va.validateNum("123",3,3));



StringBuffer amoutSql = new StringBuffer(
		"(CASE  WHEN to_char(sysdate,'HH24:mi') > '06:00' and to_char(sysdate,'HH24:mi') < '07:00' "+
		"THEN 1"+
		"WHEN to_char(sysdate,'HH24:mi') >= '07:00' and to_char(sysdate,'HH24:mi') <= '15:00' "+
		"THEN 2"+
		"WHEN to_char(sysdate,'HH24:mi') > '15:00' and to_char(sysdate,'HH24:mi') < '16:00' " +
		"THEN 1 " +
		"ELSE 0  END) * " + 3
		);
StringBuffer sql = new StringBuffer(
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

//
//String value = "aaa";  // 长度不够
//
//System.out.println(value.matches(regex));
//
//
//
//value = "1111aaaa1111aaaaa";  // 太长
//
//System.out.println(value.matches(regex));
//
//
//
//value = "111111111"; // 纯数字
//
//System.out.println(value.matches(regex));
//
//
//
//value = "aaaaaaaaa"; // 纯字母
//
//System.out.println(value.matches(regex));
//
//
//
//value = "####@@@@#"; // 特殊字符
//
//System.out.println(value.matches(regex));
//
//
//
//value = "1111aaaa";  // 数字字母组合
//
//System.out.println(value.matches(regex));
//
//
//
//value = "aaaa1111"; // 数字字母组合
//
//System.out.println(value.matches(regex));
//
//
//
//value = "aa1111aa";// 数字字母组合
//
//System.out.println(value.matches(regex));
//
//
//
//value = "11aaaa11";// 数字字母组合
//
//System.out.println(value.matches(regex));
//
//
//
//value = "aa11aa11"; // 数字字母组合
//
//System.out.println(value.matches(regex));

}
}
