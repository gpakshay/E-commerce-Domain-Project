package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Test_Class;
import com.util.TestUtil;
public class LoginPage extends Test_Class {
	@FindBy(id="loginusername")
	WebElement loginUserName;
	
	@FindBy(id="loginpassword")
	WebElement loginPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath = "//button[text()='Log in']//preceding-sibling::button")
	WebElement closeButton;
	
	public LoginPage()
	{
		
		 PageFactory.initElements(driver, this);
	}
	

	
	public void login(String un, String pwd) throws Exception
	{
		
		TestUtil.sendKeys(driver, loginUserName, un);
		TestUtil.sendKeys(driver, loginPassword, pwd);
		
		Thread.sleep(2000);
		TestUtil.JSClick(driver, loginButton);
		Thread.sleep(2000);
	}
	
	
	public void clickOnClose()
	{
		TestUtil.JSClick(driver, closeButton);
	}
}
