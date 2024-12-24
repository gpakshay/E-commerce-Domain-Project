package com.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.base.Test_Class;
import com.pages.HomePage;

public class HomePageTest extends Test_Class {
HomePage homePage;
	
	@BeforeMethod
	public void set()
	{
		homePage = new HomePage();
		System.out.println("Initiating HomePage Contructor");
	}
	
	@Test
	public void verifyTitle()
	{	
		try
		{
		Assert.assertEquals(homePage.validateHomePageTitle(), "STORE");
		System.out.println("Title is correct");
		}
		catch(Exception e)
		{
			System.out.println("Title is incorrect");
		}
	}
	
	@Test
	public void verifyLogo()
	{	
		System.out.println("Validating Logo of DemoBlaze");
		Assert.assertTrue(homePage.isLogoDisplayed());
	}
}
