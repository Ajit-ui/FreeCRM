package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass
{
	
	//Inilization of page object
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Pass;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUpButton;
	
	//for inilization all elements in driver object;
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public HomePage login(String email,String pwd)
	{
		Email.sendKeys(email);
		Pass.sendKeys(pwd);
		loginButton.click();
		
		
		return new HomePage();
		
		
		
		
	}
	
	

}
