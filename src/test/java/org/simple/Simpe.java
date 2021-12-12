package org.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Simpe {
	
	public WebDriver browser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void loadUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public void txtNamePass(WebElement e,String s) {
		e.sendKeys(s);
	}
	
	public void login(WebElement e) {
		e.click();
	}
	
	public String excel(String sheet,int row,int cell) throws IOException {
		String value = null;
		File excelLoc = new File("C:\\Users\\Acer\\eclipse-workspace\\ProjectName\\Excel\\simple.xlsx");
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		if (cellType==1) {
			value = c.getStringCellValue();
			System.out.println(value);
		}
		if (cellType==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
				System.out.println(value);
			}else {
				double cellValue = c.getNumericCellValue();
				long l = (long) cellValue;
				value = String.valueOf(l);
			}
			
		}
		return value;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*public void closeBrowser(WebDriver driver) {
		driver.close();
	}*/
	
	
	
}
