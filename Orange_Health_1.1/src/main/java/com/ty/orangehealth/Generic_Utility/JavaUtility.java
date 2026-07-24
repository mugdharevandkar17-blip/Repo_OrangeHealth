package com.ty.orangehealth.Generic_Utility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random = new Random();
		int num=random.nextInt(1000);
		return num;
	}
	
	public LocalDate getSysDate()
	{
		LocalDate currentDate= LocalDate.now();
		return currentDate;
		
	}

}
