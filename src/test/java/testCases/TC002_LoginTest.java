package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test
	public void verifyLogin() {
		logger.info("***Starting TC002_LoginTest***");
		logger.debug("Application logs");
		//HomePage
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on login link");
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp =new LoginPage(driver);
		
		try
		{
			logger.info("Entering Email");
			lp.setEmail(prop.getProperty("email"));
			logger.info("Entering password");
			lp.setPassword(prop.getProperty("password"));
			logger.info("clicking login button");
			lp.clickLogin();
			logger.info("Validating MyAccount link");
			MyAccountPage myacc=new MyAccountPage(driver);
			boolean status=myacc.verifyMyAccountLink();
			if(status==true) {
				logger.info("Login Successful...Test case Passed");
				Assert.assertTrue(true);
			}else {
				logger.error("Login unsuccessful...Test case failed");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			logger.error("Test case failed");
			logger.error(e);
			Assert.fail();
		}
		logger.info("***TC002_LoginTest execution completed***");
		}

}
