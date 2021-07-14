package com.ecom.webapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class UploadProfileToGithubTest {
	
	WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		InitializeDriver.init();
		driver = RuntimeDriver.getDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}

	@Test
	@DisplayName("Test Upload Github Profile")
	void testUploadGithubProfile() throws InterruptedException, IOException {
		// 1) Login 
		LoginToGithub.userLogin();
		Thread.sleep(2000);
		
		// 2) navigate to profile setting
		String siteURL ="https://github.com/settings/profile";
		driver.get(siteURL);
		Thread.sleep(2000);

		// 3) click update profile      ------------------> 3.1 ) windows upload popup
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/div[2]/dl/dd/div/details/summary/div")).click();
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/div[2]/dl/dd/div/details/details-menu/label")).click();
		Thread.sleep(2000);
		
		// 4) Run upload-profile.exe -> autoIT
		Runtime.getRuntime().exec("AutoIT\\upload-profile.exe");
		
		// 5) confirm upload 
		driver.findElement(By.xpath("/html/body/details/details-dialog/form/div[2]/button")).click();
		Thread.sleep(3000);

	}

}
