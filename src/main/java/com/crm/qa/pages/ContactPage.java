package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class ContactPage extends BaseClass
{
	@FindBy(xpath="//a/button[@class='ui linkedin button']")
	WebElement CreateButton;
	
	@FindBy(xpath="//button/i[@class='download icon']")
	WebElement ExportButton;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String CreateButton()
	{
		CreateButton.click();
		String CreateContactPage= driver.getCurrentUrl();
		return CreateContactPage;
		
	}

}
