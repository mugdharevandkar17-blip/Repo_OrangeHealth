package com.ty.orangehealth.business_utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	@BeforeSuite
	public void configBS() {
		System.out.println("DB coonection created");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("DB coonection closed");
	}
	
}
