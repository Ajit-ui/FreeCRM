package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Listener;



public class Contact_PageTest extends BaseClass
{ 
	BaseClass base;
	LoginPage login;
	HomePage home;
	ContactPage contact;
	CreateNewContactPage create;

	@BeforeMethod
	public void setup()
	{
		inilization();
		base=new BaseClass();
		login=new LoginPage();
		home=new HomePage();
		contact=new ContactPage();
		create=new CreateNewContactPage();
	}
	
	
	@Test
	public void savecontactTest() throws InterruptedException
	{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		home.clickContactPage();
		Thread.sleep(5000);
		contact.CreateButton();
		Thread.sleep(5000);
		create.createNewContact("ajit", "pujari","abc@gamil.com");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
