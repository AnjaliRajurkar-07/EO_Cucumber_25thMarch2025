package StepsDefinations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import EOFactory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	 Properties p;
	  int rowNo=1;
	 
	 @Before
	 public void setup() throws IOException
	    {
	    	driver=BaseClass.initilizeBrowser();
	   	   // driver.manage().deleteAllCookies();
	   	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	p=BaseClass.getProperties();
	    	driver.get(p.getProperty("appURL"));
	    	driver.manage().window().maximize();
	    
	    			
		}
	 
	 /*
	 @After
	    public void tearDown(Scenario scenario ) throws IOException {
	        		
	        	FileInputStream file=new FileInputStream (System.getProperty("user.dir") +"//testData//TC SHEET.xlsx");
	        	XSSFWorkbook  workbook = new XSSFWorkbook (file);
	            XSSFSheet sheet=  workbook.getSheet("Sheet1"); //by sheet name
	          //XSSFSheet sheet=  workbook.getSheetAt(0);     //by sheet index (sheet index will be start from 0)
	            Row row= sheet.getRow(rowNo);
	            
	            if (row == null) {
	                row = sheet.createRow(rowNo);
	            }
	            
	            Cell cell = row.getCell(6);  // Column index 6 (7th column)
	            if (cell == null)
	            {
	                cell = row.createCell(6);
	            }
	            
	            if (scenario.isFailed()) {
	                cell.setCellValue("Fail");
	            } else {
	                cell.setCellValue("Pass");
	            } 
	            
	      /*      if(scenario.isFailed())
	            {
	            	row.createCell(6).setCellValue("Fail");
	                //row.getCell(6).setCellValue("Fail");           
	            }
	    
	            else {
	            	row.createCell(6).setCellValue("Pass");
	                //row.getCell(6).setCellValue("Pass");
	            }
	        */    
	            //Closing file before opening in writing mode
	           // file.close();
	            
	            //opening file in writing mode
	           /* FileOutputStream fileOutput = new FileOutputStream(System.getProperty("user.dir") +"//testData//TC SHEET.xlsx");
	            workbook.write(fileOutput); 
	            fileOutput.close();   
	            workbook.close();
	            rowNo++;  		
              
	            
	           // driver.quit();
	    }           */
 
	 @AfterStep
	    public void addScreenshot(Scenario scenario) throws FileNotFoundException {
		 
	    	// this is for cucumber j-unit report
	        if(scenario.isFailed()) 
	        {	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        
	        }
	        
/*
* byte[] is used because it stores the screenshot data in a raw binary format (byte array), 
is memory-efficient and flexible for further processing.
	         * Memory Efficient-->No need to save a file first, reducing I/O operations.
	         * Fast Processing-->Can be directly used in reporting without writing to disk.
	         * Flexibility-->Easily converted to different formats (Base64, Image files).
	         */
	        
	     
	
	
	 }
}

