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

public class CreatePdf {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //下面的需要从参数传递
    	String orderNumber = "10239920";
    	String lastName = "Wang";
    	String parkingId = "Parking_A";
    	String slotID = "02";
    	String startTime = "2019/05/14 6:59:09";
    	String endTime = "2019/05/14 8:59:09";
    	String status = "Paid";
    	String email = "asdjk@gmail.com";
    	double amount = 3;
    	
    	
    	// 生成File所在文件夹
        String filename = "./Receipt/"+orderNumber+".pdf";
        File file = new File(filename);
        file.getParentFile().mkdirs();
		
		
		
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.addTitle("Parking Receipt");//添加标题
        
        document.open();
        document.add(new Paragraph("Hello Dear. "+lastName+" This is your receipt for order "+orderNumber+", If you have any question,please feel free to contact us."));
        document.add(new Paragraph(" "));
        
        //创建一个有3列的表格
        PdfPTable table = new PdfPTable(6);
        //定义一个表格单元
        PdfPCell cell = new PdfPCell(new Paragraph("Invoice for " + orderNumber));
        cell.setHorizontalAlignment(1);
        cell.setFixedHeight(50);
        //定义一个表格单元的跨度
        cell.setColspan(6);
        //把单元加到表格中
        table.addCell(cell);
        
        //Add title
        
        table.addCell("orderNumber");
        table.addCell("email");
        table.addCell("parkingId");
        table.addCell("slotID");
        table.addCell("startTime");
        table.addCell("endTime");
        table.addCell("status");
        
        //把下面这9项顺次的加入到表格中，当一行充满时候自动折行到下一行
        table.addCell(orderNumber);
        table.addCell(email);
        table.addCell(parkingId);
        table.addCell(slotID);
        table.addCell(startTime);
        table.addCell(endTime);
        table.addCell(status);
        //重新定义单元格
        cell = new PdfPCell(new Paragraph("cell test2"));
        //定义单元格的跨度
        cell.setColspan(2);
        //增加到表格上
        table.addCell(cell);
        //增加到文档中
        document.add(table);
        
        
        
        
        
        
        
        
        
        document.close();
        
    }
}