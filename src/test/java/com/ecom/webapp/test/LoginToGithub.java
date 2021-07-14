package com.ecom.webapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginToGithub {
	
	public static void userLogin() {
		String siteURL = "https://github.com/login";
		WebDriver driver = RuntimeDriver.getDriver();
		driver.get(siteURL);
		// find elements and enter creds
		driver.findElement(By.id("login_field")).sendKeys(LoginCredentials.username);
		driver.findElement(By.id("password")).sendKeys(LoginCredentials.password);
		
		// submit action
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]")).submit();
		
	}
}
