package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Listener;
public class LoginPageTest extends BaseClass
{
	LoginPage loginpage;
	HomePage homepage;
	
	//reson is need to access properties file (without also its working.)
	public LoginPageTest()
	{
		//super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		inilization();
		 loginpage=new LoginPage();
		 
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test (priority=2)
	public void login()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
