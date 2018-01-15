package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pom.base.DriverScript;
import com.pom.utils.GenericFunctions;

public class HomePage extends DriverScript {
	GenericFunctions genericfunction;
	
	
	@FindBy(xpath = "//*[contains(text(),'User: pankaj')]")
	WebElement HomePageUser;
	
		
	@FindBy(xpath = "//a[(@title='Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[(@title='Deals')]")
	WebElement DealsLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkUser(){
		String hometxt = HomePageUser.getText();
		return hometxt;
	}
	
	
	public ContactPage contactsLink(){
		ContactsLink.click();
		return new ContactPage();
	}
	
	public void clickonNewContactLink(){
		Actions act = new Actions(driver);
		act.moveToElement(ContactsLink).build().perform();		
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
	}
	
	
	
}
