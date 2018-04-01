package RelearnPack;

import java.io.File;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportcls {

	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest

	public void Starttest()
	{
		extent = new ExtentReports(System.getProperty("C:/Users/user/Desktop/output/reports.html"),true);
		extent.addSystemInfo("Host Name","Abilash Babu")
		.addSystemInfo("Environment","testing")
		.addSystemInfo("User Name","Extent Reports");
		extent.loadConfig(new File(System.getProperty("C:\\Users\\user\\Desktop\\Abilash\\SeleniumBrushUp\\extent-config.xml")));
	}

	@Test
	public void passTest()
	{
		logger = extent.startTest("PassTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS,"The testcase is passes");

	}
	@Test
	public void failTest()
	{
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL,"The testcase is failed");
	}
	@Test
	public void skipTest()
	{
		logger = extent.startTest("skipTest");
		throw new SkipException("This method is not ready for testing");

	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL,"Information of Failure"+result.getName());
			logger.log(LogStatus.FAIL,"Information of Failure"+result.getThrowable());

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP,"Information of Failure"+result.getName());
			logger.log(LogStatus.SKIP,"Information of Failure"+result.getThrowable());	
		}
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endTest()
	{
		extent.flush();
		extent.close();
	}
}
