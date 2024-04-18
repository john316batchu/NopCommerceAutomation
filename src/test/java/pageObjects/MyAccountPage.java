package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Defining pagefactory
	@FindBy(xpath = "//div[@class='header-links']//a[text()='My account']")
	WebElement Myaccount;

	@FindBy(xpath = "//div[@class='header-links']//a[text()='Log out']")
	WebElement LogOut;

//Defining Action methods

	public boolean verifyMyAccountLink() {
		try {
			return Myaccount.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public void logOut() {
		LogOut.click();
	}
	

}
