package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.Base;

public class IndexPage extends Base{
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	WebElement navToSignIn;
	

	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SignInPage clickOnSignInBtn() throws Throwable{
		Action.click(driver,navToSignIn);
//		Action.click(driver, signInBtn);
		return new SignInPage();		
	}

}
