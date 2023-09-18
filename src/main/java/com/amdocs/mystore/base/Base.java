package com.amdocs.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
    public static Properties prop;
    
    public static void loadConfig()
    {
        try {
            prop=new Properties();
            System.out.println("super construtor invoked");
            FileInputStream ip=new FileInputStream("C:\\AmdocsAQE\\ECommerceTestApp\\Configuration\\Config.properties");
            prop.load(ip);
            System.out.println("driver : "+driver);
            }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void launchApp() throws IOException
    
    {
        WebDriverManager.edgedriver().setup();
        String browserName=prop.getProperty("browser");
        if(browserName.contains("Edge"))
        {
        	driver=new EdgeDriver();
        }
        else if(browserName.contains("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(browserName.contains("FireFox"))
        {
            driver=new FirefoxDriver();
        }
        else if(browserName.contains("IE"))
        {
            driver=new InternetExplorerDriver();
        }
//        Actions.implicitWait(driver,10);
//        Actions.pageLoadTimeOut(driver,30);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);

//        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
    
    public static String getUsername() {
     return prop.getProperty("username");
    }
    
    public static String getPassword() {
        return prop.getProperty("password");
       }

}
