package com.ty.orangehealth.business_utility;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;


public class BaseClassTest {
	WebDriver driver;
	@BeforeSuite
	public void configBS() {
		System.out.println("DB coonection created");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("DB coonection closed");
	}
	
	@BeforeClass
	public void configBC(XmlTest test) {
//		WebDriverUtility proUtil = new WebDriverUtility();
		String browser = System.getProperty("browser");
		if(browser == null || browser.isBlank()) {
			browser = test.getParameter("browser");
			if(browser == null || browser.isBlank()) {
				browser = "chrome";
			}
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new IllegalArgumentException("Invalid browser : " + browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.orangehealth.in/");
		System.out.println("before class");
		
	}
	
	
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	
}
