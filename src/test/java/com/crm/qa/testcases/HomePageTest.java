package com.crm.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Listener;
public class HomePageTest extends BaseClass
{
	HomePage home;
	LoginPage login;

	@BeforeMethod()
	public void setup()
	{
		inilization();
		home=new HomePage();
		login=new LoginPage();
	}
	
	@Test(priority=1)
	public void validatePageTitle()
	{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		String title=home.validateHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void Homepage()
	{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		home.HomeButton();	
		
		Assert.assertEquals(home.HomeButton(), "https://ui.cogmento.com/home");
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
