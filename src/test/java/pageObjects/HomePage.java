package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//Defining pageFactory
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement Login;
	
//Actions
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clickLogin() {
		Login.click();
	}

}
