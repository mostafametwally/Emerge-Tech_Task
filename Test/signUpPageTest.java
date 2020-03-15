package com.pixelogic.Test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.thread.IFutureResult;

import com.Pixelogic.Base.TestBase;
import com.Pixelogic.Pages.LoginPage;
import com.Pixelogic.Pages.SignupPage;
import com.Pixelogic.Util.ReadFromExcel;
import com.Pixelogic.Util.Takescreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class signUpPageTest extends TestBase {

	public String filePath;
	public String fileName;
	public String newUserSheet;

	public SignupPage signuppage;
	public LoginPage loginpage;
	public ExtentReports extents;
	public ExtentTest extenttest;
	int count;

	public signUpPageTest() {
		super();
		filePath = prop.getProperty("filePath");
		fileName = prop.getProperty("fileName");
		newUserSheet = prop.getProperty("newUserSheet");
		count = 0; // this var is created to be added to the screenshot file name
	}

	@BeforeTest
	public void extentscreenshoot() {
		extents = new ExtentReports(System.getProperty("uer.dir") + "/test-output/extentreport.html", true);
		extents.addSystemInfo("host name", "user name");
	}

	
	  @AfterTest void EndReport() { extents.flush(); extents.close(); }
	 
	@BeforeMethod
	public void setup() {
		Initialzation();
		signuppage = new SignupPage();
	}

	@AfterMethod
	public void Teardown(ITestResult tresult) throws Exception {

		if (tresult.getStatus() == ITestResult.FAILURE) {
			extenttest.log(LogStatus.FAIL, tresult.getName());
			extenttest.log(LogStatus.FAIL, tresult.getThrowable());
			extenttest.log(LogStatus.FAIL, extenttest
					.addScreenCapture(Takescreenshot.takeSnapShot(driver, "target/RegScreen_" + (count++) + ".png")));
		} else if (tresult.getStatus() == ITestResult.SKIP) {
			extenttest.log(LogStatus.SKIP, tresult.getName());
			extenttest.log(LogStatus.SKIP, tresult.getThrowable());
		}
		extents.endTest(extenttest);
		driver.quit();
	}

	@DataProvider
	public String[][] GetUserData() throws IOException {

		String[][] data = ReadFromExcel.getTestData(filePath, fileName, newUserSheet);

		return data;
	}

	@Test(dataProvider = "GetUserData")
	void LoginVerification(String firstname, String lastname, String mobile, String email, String password,
			String confirmpassword) throws Exception {

		extenttest = extents.startTest("LoginVerification");

		signuppage.SignupUrlOpen(prop.getProperty("Reg_url"));

		signuppage.SignupRegistration(firstname, lastname, mobile, email, password, confirmpassword);
		Thread.sleep(1000);
		signuppage.SignupLogout().UserLogin(email, password);

		/* try { */

		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("Account_url"));

		/*
		 * } catch (AssertionError e) {
		 * 
		 * Takescreenshot.takeSnapShot(driver, "target/RegScreen_" + (count++) +
		 * ".png"); }
		 */

	}
}
