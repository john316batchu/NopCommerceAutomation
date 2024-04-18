package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//Defining pageFactory
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement Login;
	
//Defining Action methods
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	public void clickLogin() {
		Login.click();
	}
	
	

}
