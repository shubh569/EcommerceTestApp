package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.Base;


public class SignInPage extends Base {
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement emailTextbox;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	WebElement signInSubmitBtn;
	
	public SignInPage() { 
		PageFactory.initElements(driver, this);
		//page factory will create the object of Page classes so we can use it any without creating every time by = new class() statement 
	}
	
	public HomePage login(String uname,String pwd) throws Throwable{
		Action.type(emailTextbox, uname);
		Action.click(driver, continueBtn);
		Action.Wait(driver, 5);
		Action.type(passwordTextbox, pwd);
		Action.click(driver, signInSubmitBtn);
		Action.Wait(driver, 40);
		return new HomePage();
	}

}
