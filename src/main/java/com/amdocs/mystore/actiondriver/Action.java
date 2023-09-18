package com.amdocs.mystore.actiondriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amdocs.mystore.base.Base;

public class Action extends Base{

	public static void click(WebDriver driver,WebElement locatorName) throws Exception{
		Actions act = new Actions(driver);
		act.moveToElement(locatorName).click().build().perform();
		System.out.println("clicked on" + locatorName);
	}
	
	public static void conditionalClick(WebDriver driver, WebElement locatorName) throws Exception
	{
		
		//Actions act = new Actions(driver);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(locatorName.toString()))).click();
		
	}
	 public static void selectDropdownOption(WebElement element, String optionText) {
	        Select select = new Select(element);
	        select.selectByVisibleText(optionText);
	        element.sendKeys(Keys.ENTER);
	    }
	
	public static boolean type(WebElement ele, String text)
    {
        boolean flag =false;
        try
        {
            flag=ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            flag=true;
        }
        catch(Exception e)
        {
            System.out.println("location not found");
            flag=false;
        }
        finally
        {
            if(flag)
            {
                System.out.println("successfully enetered value");
            }
            else
            {
                System.out.println("unable to enter value");
            }
        }
        return flag;
    }
	
	public static void Wait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
}
