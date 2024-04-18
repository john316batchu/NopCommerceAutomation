package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass {

	@Test
	public void registrationTest() {
		
		logger.info("****Starting TC001_RegistrationTest****");
		logger.debug("Application logs...");
		HomePage hp = new HomePage(driver);
		logger.info("clicking on register link");
		hp.clickRegister();
		RegisterPage rp = new RegisterPage(driver);
		
		try {
			
			logger.info("Entering Registration Details");
			rp.setFirstName(generateRandomAlphabet());
			rp.setLastName(generateRandomAlphabet());
			rp.setEmail(generateRandomAlphabet() + "@gmail.com");
			String pwd = generateAlphaNumeric();
			rp.setPassword(pwd);
			rp.setConfirmPassword(pwd);
			logger.info("Clicking on Register Button");
			rp.clickRegister();
			logger.info("Verifying registration status");
			boolean status = rp.verifyRegistrationStatus();
			if (status == true) {
				logger.info("Registration is successful...Testcase passed");
				Assert.assertTrue(true);
			} else {
				logger.error("Registration is unsuccessful...Testcase failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			logger.error(e);
			Assert.fail();
		}
		logger.info("TC001_RegistrationTest execution completed");
	}
}
