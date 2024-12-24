package com.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.base.Test_Class;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductInfoPage;
import com.util.TestUtil;

public class ProductInfoPageTest extends Test_Class{
	ProductInfoPage phone;
	ProductInfoPage lappy;
	ProductInfoPage monitor;
	ProductInfoPage prod;
	
	HomePage homePage;
	CartPage cartPage;
	
	Alert alert;
	String alertTxt;
	
	@BeforeMethod
	public void set()
	{
		driver.get(prop.getProperty("url"));
		homePage = new HomePage();
	}
	
	
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectPhone() throws Exception
	{
		phone = homePage.getPhone();
		phone.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	
	}
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectLappy() throws Exception
	{
		lappy = homePage.getLappy();
		lappy.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	}
	
	@Test(groups = {"ProductInfoPageTest.addProduct"})
	public void selectMonitor() throws Exception
	{
		monitor = homePage.getMonitor();
		monitor.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = TestUtil.handleAlert(driver, alert);
		
		Assert.assertEquals(alertTxt, "Product added.");
		
	}
}
