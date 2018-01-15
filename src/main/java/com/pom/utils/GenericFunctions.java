package com.pom.utils;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pom.base.DriverScript;

public class GenericFunctions extends DriverScript {
	
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public void switchFramebyName(String fname){
		driver.switchTo().frame(fname);	
	}
	
	
	
	
	public  Object[][] getTestData(){
		String path = "C:\\Selenium\\POM\\src\\main\\java\\com\\pom\\testdata\\TestData.xlsx";
	try{
		//FileInputStream	 file = new FileInputStream("C:\\Selenium\\POM\\src\\main\\java\\com\\pom\\testdata\\TestData.xlsx");
		InputStream is = new BufferedInputStream(new FileInputStream(path));
		try {
				book = new XSSFWorkbook(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			   sheet = book.getSheet("Sheet1");
			   Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	   
			   for(int i=0;i<sheet.getLastRowNum();i++){
				   for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					   data[i][j]=sheet.getRow(i+1).getCell(j).toString();   
				   }
			   }
				return data;
		} catch(Exception e){
		System.out.println("ERROR OCCURED WHILE READING EXCEL"+e);
		}
		return null;
	}
	
	
	
	public void TakeScreenShotonFail() throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(currentDir+"/Screenshots/"+System.currentTimeMillis()+ ".png"));
	}
	
	
	
}
