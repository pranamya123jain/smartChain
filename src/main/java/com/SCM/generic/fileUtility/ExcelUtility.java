package com.SCM.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDtaFromExcel(String sheetName,int rowNum,int CelNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/manufacturerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();
		return data;
		}
	public int getRowCount(String sheetName) throws Throwable, IOException
	{
	FileInputStream fis=new FileInputStream("./src/test/resources/manufacturerData.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	int rowCount= wb.getSheet(sheetName).getLastRowNum();
	return rowCount;
	}
	public void setDataIntoExcel(String sheetName,int rowNum,int CelNum, String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/manufacturerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(CelNum).setCellValue(data);
		FileOutputStream fos= new FileOutputStream("./src/test/resources/manufacturerData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
