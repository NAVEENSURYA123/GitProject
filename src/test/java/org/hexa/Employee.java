package org.hexa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.simple.Simpe;

public class Employee {
	public static void main(String[] args) throws IOException {
		
		Simpe call = new Simpe();
		
		WebDriver driver = call.browser();
		
		call.loadUrl(driver, "https://www.facebook.com/");
		
		WebElement txtName = driver.findElement(By.id("email"));
		call.txtNamePass(txtName, "14567896324");
		
		WebElement txtpass = driver.findElement(By.id("pass"));
		call.txtNamePass(txtpass, "xdrgyhnmjklpo");
		
		/*WebElement login = driver.findElement(By.name("login"));
		call.login(login);*/
		
		call.excel("sns", 0, 1);
		
		
		
		
		
		
		
		//call.closeBrowser(driver);
		
		
		
	}
}
