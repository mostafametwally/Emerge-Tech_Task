package com.Pixelogic.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Pixelogic.Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@type=\"email\" and @name=\"username\"]")
	@CacheLookup
	WebElement L_email;
	
	@FindBy(xpath="//input[@type=\"password\" and @name=\"password\"]")
	@CacheLookup
	WebElement L_passWord;
	
	@FindBy(xpath="//button[contains(text(),\"Login\")]")
	@CacheLookup
	WebElement L_loginButton;
	
	LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	void OpenloginUrl (String login_url) {
		OpenUrl(login_url);		
	}
	
	public void UserLogin(String email,String passWord) {
		L_email.sendKeys(email);
		L_passWord.sendKeys(passWord);
		L_loginButton.click();

	}
	

}
