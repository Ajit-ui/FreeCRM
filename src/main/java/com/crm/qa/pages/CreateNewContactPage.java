package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class CreateNewContactPage extends BaseClass 
{
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstNameTextField;
	

	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastNameTextField;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement MiddleNameTextField;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement CompanyNmeTextField;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']")
	WebElement PrivateButton;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement EmailTextFiled;
	
	@FindBy(xpath="//input[@placeholder='Personal email, Business, Alt...']")
	WebElement bussinessMailTextField;
	
	@FindBy(xpath="//button/i[@class='save icon']")
	WebElement savebutton;
	
    @FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement save;
	
	public CreateNewContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String name,String lastname,String email) throws InterruptedException 
	{
		FirstNameTextField.sendKeys(name);
		LastNameTextField.sendKeys(lastname);
		//MiddleNameTextField.sendKeys(MiddleN);
		Thread.sleep(5000);
		//CompanyNmeTextField.sendKeys(cname);
		Thread.sleep(5000);
		PrivateButton.click();
		Thread.sleep(5000);
		EmailTextFiled.sendKeys(email);
		Thread.sleep(5000);
		//savebutton.click();
		save.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
