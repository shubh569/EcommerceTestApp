package com.amdocs.mystore.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amdocs.mystore.base.Base;
import com.amdocs.mystore.pageobjects.AddToCartPage;
import com.amdocs.mystore.pageobjects.CheckOut;
import com.amdocs.mystore.pageobjects.HomePage;
import com.amdocs.mystore.pageobjects.IndexPage;
import com.amdocs.mystore.pageobjects.SignInPage;


public class IndexPageTest extends Base{
	private IndexPage indexPage;
	
	
	 @BeforeMethod
	    public void setup() throws Throwable {
		 	loadConfig();
			launchApp();
	      
	        indexPage = new IndexPage();
	    }
	  
	 @Test
	    public void loginTest() throws Throwable {
	        SignInPage signin= indexPage.clickOnSignInBtn();
	        HomePage home= signin.login(getUsername(), getPassword());
	        home.SearchProduct();
	        AddToCartPage cart= home.SelectFirstProduct();
	        CheckOut checkout=cart.ClickOnProceedToBuy();
	        checkout.checkoutProcess();
	    }
}
