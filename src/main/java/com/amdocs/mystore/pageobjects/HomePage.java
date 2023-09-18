package com.amdocs.mystore.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.Base;

public class HomePage extends Base{
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchSubmitBtn;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement firstProduct;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
	WebElement AddToCart;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchProduct() throws Throwable {
		Action.type(searchBar, "Smart Watches");
		Action.click(driver, searchSubmitBtn);
	}
	
	public AddToCartPage SelectFirstProduct() throws Exception {
		Action.click(driver, firstProduct);
	      Action.Wait(driver, 5);

	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("tab switched");
	      Action.Wait(driver, 5);	  
	      Action.click(driver, AddToCart);	
	      return new AddToCartPage();
	}

}
