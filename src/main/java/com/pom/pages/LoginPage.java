package com.pom.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.DriverScript;

public class LoginPage extends DriverScript {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[@class='btn']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive' and contains(@src,'freecrm')]")
	WebElement crmLogo;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();	
	}
	
	
	public HomePage login(String uname, String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();		
	}
	
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	
}



