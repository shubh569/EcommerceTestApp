package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amdocs.mystore.base.Base;
import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.pageobjects.CheckOut;

public class AddToCartPage extends Base{
	@FindBy(xpath = "//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
	WebElement ProceedToBuy;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckOut ClickOnProceedToBuy() throws Throwable {
		
//		Action.Wait(driver, 40);
	
		//Action.conditionalClick(driver, ProceedToBuy);
	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ProceedToBuy));
	Action.click(driver, ProceedToBuy);	
	return new CheckOut();
	}


}
