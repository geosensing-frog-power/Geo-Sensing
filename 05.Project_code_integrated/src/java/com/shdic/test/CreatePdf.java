package com.shdic.test;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.shdic.bean.OrderDetailBean;
import com.shdic.bean.SlotBean;

public class CreatePdf {
	public static final String spectator = File.separator;

    public  Boolean createRecepitPDF(OrderDetailBean orderDetail) throws DocumentException, FileNotFoundException{
        //testing
//    	String order_id = "order123";
//    	String lastName = "Wang";
//    	String parking_id = "Parking_A";
//    	String slot_id = "02";
//    	String start_time = "2019/05/14 6:59:09";
//    	String end_time = "2019/05/14 8:59:09";
//    	String order_status = "Paid";
//    	String recepit_no = "recepit123";
//    	String email = "asdjk@gmail.com";
//    	double amount = 3;
    	
    	String order_id	 		= orderDetail.getOrder_id();
    	String parking_id	  	= orderDetail.getParking_id()  ;
    	String slot_id		    = orderDetail.getSlot_id();
    	String start_time	    = orderDetail.getStart_time();
    	String end_time	   		= orderDetail.getEnd_time() ;
    	String recepit_no	   	= orderDetail.getRecepit_no() ;
    	String order_status    	= orderDetail.getOrder_status();
    	String amount		   	= orderDetail.getAmount() ;
    	String email           	= orderDetail.getEmail();
    	String send_email_status  = orderDetail.getSend_email_status();  
    	
    	System.out.println("order_id : "+order_id);
    	System.out.println("parking_id : "+parking_id);
    	System.out.println("slot_id : "+slot_id);
    	System.out.println("start_time : "+start_time);
    	System.out.println("end_time : "+end_time);
    	System.out.println("recepit_no : "+recepit_no);
    	
    	if(order_id ==null){
    		System.out.println("create pdf ,order_id is null");
    		return false;
    	}
    	// 生成File所在文件夹
        //String filename = "./Receipt/"+recepit_no+".pdf";
    	System.out.println("craetepdf class root path=>"+CreatePdf.class.getResource("/"));
    	//String filename = "./Receipt/"+recepit_no+".pdf";
    	//String filename =CreatePdf.class.getResource("/")+"Receipt/"+recepit_no+".pdf";
    	String filename = "C:"+spectator+"Receipt"+spectator+recepit_no+".pdf";
        File file = new File(filename);
        file.getParentFile().mkdirs();
		
		
		
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.addTitle("Parking Receipt");//添加标题
        
        document.open();
        document.add(new Paragraph("Hello Dear. This is your receipt for order "+order_id+", If you have any question,please feel free to contact us."));
        document.add(new Paragraph(" "));
        
        //创建一个有3列的表格
        PdfPTable table = new PdfPTable(7);
        //定义一个表格单元
        PdfPCell cell = new PdfPCell(new Paragraph("Invoice for " + recepit_no));
        cell.setHorizontalAlignment(1);
        cell.setFixedHeight(50);
        //定义一个表格单元的跨度
        cell.setColspan(7);
        //把单元加到表格中
        table.addCell(cell);        
        //Add title
        
        table.addCell("orderNumber");
        table.addCell("email");
        table.addCell("parkingId");
        table.addCell("slotID");
        table.addCell("startTime");
        table.addCell("endTime");
        table.addCell("order_status");
        
        //把下面这9项顺次的加入到表格中，当一行充满时候自动折行到下一行
        table.addCell(order_id);
        table.addCell(email);
        table.addCell(parking_id);
        table.addCell(slot_id);
        table.addCell(start_time);
        table.addCell(end_time);
        table.addCell(order_status);
        //重新定义单元格
        cell = new PdfPCell(new Paragraph("cell test2"));
        //定义单元格的跨度
        cell.setColspan(2);
        //增加到表格上
        table.addCell(cell);
        //增加到文档中
        document.add(table);
        
        document.close();
        
        return true;
    }
}