package com.ty.orangehealth.generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility 
{
	public String getDataFromProperties(String key)
	{
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Jyoti\\git\\Repo_OrangeHealthJyoti\\Orange_Health_1.1\\Test-Data\\OH_CD.properties");
			Properties pobj=new Properties();
			pobj.load(fis);
			String data = pobj.getProperty(key);
			return data;	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getDataFromExcel(String path,String sheet,int rownum,int cellnum)
	{String data="";
		try {
			FileInputStream fis =new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			data = sh.getRow(rownum).getCell(cellnum).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;	
	}
	
	public String getDataFromExcel(String sheet,int rownum,int cellnum)
	{String data="";
		try {
			FileInputStream fis =new FileInputStream("C:\\Users\\Jyoti\\git\\Repo_OrangeHealthJyoti\\Orange_Health_1.1\\Test-Data\\TestScriptData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			data = sh.getRow(rownum).getCell(cellnum).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;	
	}

}
