package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pom.base.DriverScript;

public class ContactPage extends DriverScript {
	
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="title")
	WebElement contactitle;
		
	public void createNewContact(String title, String fname, String lname, String company){
		Select select = new Select(contactitle);
		select.selectByVisibleText(title);
		
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("surname")).sendKeys(lname);
		driver.findElement(By.name("client_lookup")).sendKeys(company);
		driver.findElement(By.xpath("(//input[@value='Save' and @class='button'])")).click();

	}


	
	
	
	
	
	
	

}
