package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//div[@class='header item']")
	WebElement CRMlogo;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement UserName;
	
	@FindBy(xpath="//a[@href='/home']")
	WebElement HomeButton;
	
	@FindBy(xpath="//a[@href='/calendar']")
	WebElement CalenderButton;
	
	@FindBy(xpath="//div[text()='Contacts activity stream']")
	WebElement contactsActivityStream;
	
	@FindBy(xpath="//div[text()='Deals']")
	WebElement Deals;
	
	@FindBy(xpath="//span[text()='Call Queue']")
	WebElement CallQueue;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement Contact;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String clickContactPage()
	{
		Contact.click();
		String url=driver.getCurrentUrl();
		return url;
		
	}
	
	public String HomeButton()
	{
		HomeButton.click();
		String url=driver.getCurrentUrl();
		return url;
	}
	  
	
	
	

}
