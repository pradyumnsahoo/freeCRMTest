package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH="D:\\Automation\\Java\\.metadata\\freeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\freeCRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

public static Object[][] getTestData(String sheetName){
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	}catch(FileNotFoundException e){
		e.printStackTrace();
		
	}
	try {
		book=WorkbookFactory.create(file);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}

}
