package test1;

import java.io.File;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test2 {
	public class testclass  {
		
		ExtentReports extent ;
		ExtentTest test = null;
		String a = "test ";
		


		@BeforeTest
		public void tc() {
			Date d = new Date();
			String Filename = d.toString().replace(":", "_").replace(" ","_")+".html";
			extent = new ExtentReports("D:\\report_e\\" +Filename +".html" ,true);
			
			extent.loadConfig(new File("C:\\Users\\parveen\\Downloads\\maven\\mavengmail1\\ReportsConfig.xml"));
			extent.addSystemInfo("selenium version", "environment");
			 
		}
		
		
		@AfterMethod
		public void atcm(ITestResult result ) {
			if (result.getStatus()== ITestResult.FAILURE) {
				
				test.log(LogStatus.FAIL, "testcase failed is " +result.getName());
				test.log(LogStatus.FAIL, "testcase failed is " +result.getThrowable());
				
			}
			else
				if (result.getStatus()== ITestResult.SKIP) {
					test.log(LogStatus.SKIP, "testcase skipped is " +result.getName());
					
				}
		extent.endTest(test);
		}
		
		
		

		
		
		@Test
		public void failtest() {
			 
			 test = extent.startTest("failtest");
			  if (!a.equals(null)) {
			 test.log(LogStatus.FAIL, "test is failed");
			 
			 
			  }
		}
		
		
		
		@Test
		public void passtest() {
			 
			 test = extent.startTest("passtest");
			 if (!a.equals(null)) {
			 test.log(LogStatus.PASS, "test is passed");
			 }
			 
			 
			 
		}
		
		

		@Test
		public void skiptest() {
			test = extent.startTest("skiptest");
if (true) {
			 throw new SkipException("test is skip");
		}
		}
		
		
		
		@AfterTest
		public void atc() {
			extent.endTest(test);
			extent.flush();
			
		}
	}


}
