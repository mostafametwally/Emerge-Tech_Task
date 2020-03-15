package com.Pixelogic.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	
	public static String[][] getTestData(String filePath,String fileName,String sheetName) throws IOException {
		File file =new File(filePath + fileName);
		Workbook ExcelWorkbook =null;
		
		FileInputStream inputStream  = new FileInputStream(file);
		
		String fileExtentionName=fileName.substring(fileName.indexOf("."));
		if(fileExtentionName.equals(".xls")) {
			
			ExcelWorkbook=new HSSFWorkbook(inputStream);
		}
		else if(fileExtentionName.equals(".xlsx")) {
			
			ExcelWorkbook=new XSSFWorkbook(inputStream);
		}
		
		Sheet sheet_One =ExcelWorkbook.getSheetAt(0);
		
		int Row = sheet_One.getLastRowNum();
		int Coloumn= sheet_One.getRow(0).getLastCellNum();	
		System.out.println(Row+","+Coloumn);
		
		String[][] data=new String[Row][Coloumn];
		
		for(int i=0; i<Row; i++) {
			
			for(int j=0; j< Coloumn; j++ ) {

				data[i][j]=sheet_One.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println("data["+i+"]["+j+"]="+data[i][j]);
			}
		}
		ExcelWorkbook.close();
		return data;
	}
}
