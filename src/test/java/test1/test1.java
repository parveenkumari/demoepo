package test1;

import java.io.File;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test1 {
	
	@Test
	public void tc_1() {
		
		System.out.println("we are in 1st test class");
		
		 ExtentReports extent = new ExtentReports("C:\\Users\\parveen\\Downloads\\maven\\test1\\test-output\\extent.html", true);
		ExtentTest test = null;
		
	System.out.println("running test case");
		
		test = extent.startTest("verify page title");
		
		extent.loadConfig(new File("C:\\Users\\parveen\\Downloads\\maven\\test1\\ReportsConfig.xml"));
		extent.addSystemInfo("selenium version", "environment");
		
		 
		test.log(LogStatus.INFO, "in test case");

		
		extent.endTest(test);
		extent.flush();
		 

}
}
