package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener listener;
	
	public BaseClass()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void inilization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\\\SELINUM\\\\Driver\\\\chromedriver_win32\\\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		listener=new WebEventListener();
		e_driver.register(listener);
		driver=e_driver;
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
	}
	
	public void failed(String testMehodName)
	{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	    	FileUtils.copyFile(scr, new File("D://screenshot//"+testMehodName+"_"+".jpg"));
	    }catch(IOException e){
	    	
	    	e.printStackTrace();
	    }
		
		
	}

}
