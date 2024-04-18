package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utility.DataProviderClass;

public class TC003_LoginTestDDT extends BaseClass {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviderClass.class)
	public void verifyLogin(String email, String password, String result) {

		logger.info("***Starting TC003_LoginTestDDT***");
		logger.debug("Application logs");
		// HomePage
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on login link");
		hp.clickLogin();

		// LoginPage
		LoginPage lp = new LoginPage(driver);

		try {
			logger.info("Entering Email");
			lp.setEmail(email);
			logger.info("Entering password");
			lp.setPassword(password);
			logger.info("clicking login button");
			lp.clickLogin();
			logger.info("Validating MyAccount link");
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean status = myacc.verifyMyAccountLink();
			if (result.equalsIgnoreCase("valid")) {
				if (status == true) {
					logger.info("Login Successful...Test case Passed");
					myacc.logOut();
					Assert.assertTrue(true);
				} else {
					logger.error("Login unsuccessful on valid data...Test case failed");
					Assert.assertTrue(false);
				}
			}
			if (result.equalsIgnoreCase("invalid")) {
				if (status == true) {
					logger.error("login successful on invalid credentials...TestCase Failed");
					myacc.logOut();
					Assert.assertTrue(false);
				} else {
					logger.info("Login unsuccessful on invalid credentials...Test case passed");
					Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
			logger.error("Test case failed");
			logger.error(e);
			Assert.fail();
		}
		logger.info("***TC002_LoginTest execution completed***");
	}

}