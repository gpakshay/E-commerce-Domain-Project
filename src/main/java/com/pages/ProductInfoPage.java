package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Test_Class;
import com.util.TestUtil;

public class ProductInfoPage extends Test_Class {
	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addToCartBtn;
	
	public ProductInfoPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnaddToCartBtn()
	{
		TestUtil.JSClick(driver, addToCartBtn);
		
	}
}
