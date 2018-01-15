package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.DriverScript;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;

public class LoginPageTest extends DriverScript {
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		getBrowser();
		loginpage = new LoginPage();		
	}
	
	
	@Test
	public void loginTitleTest(){
		String title = loginpage.getTitle();
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);	
	}
	
	@Test
	public void crmLogoTest(){
		Assert.assertTrue(loginpage.validateCRMImage());
	}
	
	@Test
	public void login(){
		homePage = loginpage.login(prop.getProperty("uname"),prop.getProperty("pwd"));
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
	
	
}
