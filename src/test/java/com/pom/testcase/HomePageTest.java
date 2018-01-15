package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.DriverScript;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;
import com.pom.utils.GenericFunctions;

public class HomePageTest extends DriverScript {
	LoginPage loginpage;
	HomePage homePage;
	GenericFunctions gfunction;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		getBrowser();
		loginpage = new LoginPage();
		homePage = new HomePage();
		gfunction = new GenericFunctions();
		homePage = loginpage.login(prop.getProperty("uname"),prop.getProperty("pwd"));
		
	}
	
	
	@Test
	public void HomePageUserTest(){
		gfunction.switchFramebyName("mainpanel");
		String User = homePage.checkUser();
		Assert.assertEquals("User: pankaj gupta", User.trim());	
	}
	
	
	@Test(enabled=false)
	public void ContactsClick(){
		gfunction.switchFramebyName("mainpanel");
		homePage.contactsLink();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
