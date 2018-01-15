package com.pom.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.base.DriverScript;
import com.pom.pages.ContactPage;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;
import com.pom.utils.GenericFunctions;

public class ContactPageTest extends DriverScript {

	LoginPage loginpage;
	HomePage homePage;
	GenericFunctions gfunction;
	ContactPage contactpage;
	
	public ContactPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		getBrowser();
		loginpage = new LoginPage();
		homePage = new HomePage();
		gfunction = new GenericFunctions();
		contactpage = new ContactPage();
		homePage = loginpage.login(prop.getProperty("uname"),prop.getProperty("pwd"));
		gfunction.switchFramebyName("mainpanel");
	}
	
	@DataProvider
	public Object[][] getContactsData(){
		Object data[][]=gfunction.getTestData();
		return data;
	}
	
	
	//@Test(dataProvider="getContactsData")
	@Test
	public void enterContactDetails(String title,String fname, String lname, String company){
		homePage.clickonNewContactLink();
		contactpage.createNewContact(title, fname, lname, company);
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
	
}
