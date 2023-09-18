package com.amdocs.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.base.Base;
import com.amdocs.mystore.actiondriver.Action;

public class CheckOut extends Base{
	@FindBy(xpath = "//div[@class='a-box pmts-instrument-box']//input[@type='radio']")
	List<WebElement> paymentMethod;

	
	@FindBy(xpath = "//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")
	WebElement useThisPayment;
	
	@FindBy(xpath="//*[@id=\"submitOrderButtonId\"]/span/input")
	WebElement placeYourOrder;
	
	@FindBy(xpath="//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")
	WebElement useThisAddress;
	
	public CheckOut() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutProcess() throws Throwable {
		Action.click(driver, useThisAddress);
		//Thread.sleep(10000);
		Action.Wait(driver, 7);
		Action.click(driver, paymentMethod.get(0));
		//Action.click(driver,paymentMethod);
		Action.Wait(driver, 7);
		Action.click(driver, useThisPayment);
//		Action.Wait(driver, 7);
//		Action.click(driver, placeYourOrder);
	}
	

}
