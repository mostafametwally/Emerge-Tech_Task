package com.Pixelogic.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Pixelogic.Base.TestBase;

public class SignupPage extends TestBase {
	
    /*
     * All WebElements are identified by @FindBy annotation
     */
	
	// first name element locator
	@FindBy(xpath="//input[@type=\"text\" and @name=\"firstname\"]")
	@CacheLookup
	WebElement firstName;
	
	// Last name element locator
	@FindBy(xpath="//input[@type=\"text\" and @name=\"lastname\"]")
	@CacheLookup
	WebElement lastName;

	// phone element locator
	@FindBy(xpath="//input[@type=\"text\" and @name=\"phone\"]")
	@CacheLookup
	WebElement phoneNumber;
	
	//input[@type="text" and @name="email"]	// email element locator
	@FindBy(xpath="//input[@type=\"text\" and @name=\"email\"]")
	@CacheLookup
	WebElement email;
	
	// password element locator
	@FindBy(xpath="//input[@type=\"password\" and @name=\"password\"]")
	@CacheLookup
	WebElement password;	
	
	// confirmpassword element locator
	@FindBy(xpath="//input[@type=\"password\" and @name=\"confirmpassword\"]")
	@CacheLookup
	WebElement confirmpassword;
	
	
	// signUpButton element locator
	@FindBy(xpath="//button[@type=\"submit\" and @class=\"signupbtn btn_full btn btn-success btn-block btn-lg\"]")
	@CacheLookup
	WebElement signUpButton;
	
	
	@FindBy(xpath="//li[@class= \"d-none d-md-block fl\"]")
	WebElement userButton;
	
	@FindBy(xpath="//a[@class=\"dropdown-item tr\"]")
	WebElement logoutButton;
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	

	public void ValidatesignUpButton() {
		email.sendKeys("mostafametwaly@uuu.com");
	}
	
	public void SignupRegistration(String S1,String S2,String S3,String S4,String S5,String S6) {
		
		firstName.sendKeys(S1);
		lastName.sendKeys(S2);
		phoneNumber.sendKeys(S3);
		email.sendKeys(S4);
		password.sendKeys(S5);
		confirmpassword.sendKeys(S6);
		signUpButton.submit();
		
	}
	
	public void SignupUrlOpen (String regurl) {
		OpenUrl(regurl);		
	}
	
	public LoginPage SignupLogout () throws InterruptedException {
		
		Actions mouse = new Actions(driver);
		mouse.moveToElement(userButton).click().build().perform();
		logoutButton.click();
		return new  LoginPage();
		
	}
	
}
