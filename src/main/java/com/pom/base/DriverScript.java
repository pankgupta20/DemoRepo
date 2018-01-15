package com.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.pom.utils.WebEventListener;

public class DriverScript {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public DriverScript(){
				prop = new Properties();
				try {
					FileInputStream fis = new FileInputStream("C:\\Selenium\\POM\\src\\main\\java\\com\\pom\\config\\config.properties");
					prop.load(fis);			
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
	 }
			
			
		public void getBrowser(){
			if((prop.getProperty("browser")).equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver =  new ChromeDriver();
				
			}else if(prop.getProperty("browser").equals("FF")){
				driver = new FirefoxDriver();
			}else if(prop.getProperty("browser").equals("IE")){
				driver = new InternetExplorerDriver();				
			}	
			
				e_driver = new EventFiringWebDriver(driver);
				eventListener = new WebEventListener();	
				e_driver.register(eventListener);
				driver = e_driver;
			

				driver.get(prop.getProperty("url"));
				long impwaittime = Long.parseLong(prop.getProperty("implicitwait"));
				long pageloadtime = Long.parseLong(prop.getProperty("pageload"));
				driver.manage().timeouts().implicitlyWait(impwaittime, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(pageloadtime, TimeUnit.SECONDS);
				driver.manage().window().maximize();
	    }


}