package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//Defining pagefactory
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(name="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(name="register-button")
	WebElement REGISTER;
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement Register_Complete;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement Continue;
	
//Defining Action methods
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd) {
		ConfirmPassword.sendKeys(pwd);
	}
	public void clickRegister() {
		REGISTER.click();
	}
	public boolean verifyRegistrationStatus() {
		try {
			return Register_Complete.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public void clickContinue() {
		Continue.click();
	}
	
	

}
