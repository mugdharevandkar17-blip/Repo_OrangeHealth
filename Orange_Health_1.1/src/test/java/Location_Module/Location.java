package Location_Module;

import com.ty.orangehealth.Generic_Utility.FileUtility;

public class Location 
{
	public static void main(String[] args) 
	{
		FileUtility fu=new FileUtility();
		String data = fu.getDataFromProperties("url");
		System.out.println(data);	
		
		String data1 = fu.getDataFromExcel("Sheet1", 0, 0);
		double num = Double.parseDouble(data1);
		System.out.println(num);
		
	}

}
