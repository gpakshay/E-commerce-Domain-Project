package com.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.base.Test_Class;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends Test_Class {
	public LoginPage loginPage;
	HomePage homePage;
	Alert alert;

	@BeforeMethod
	public void start() {
		homePage = new HomePage();
		System.out.println("Going to Login Page");
		loginPage = homePage.goToLoginPage();
	}

	@Test(priority = 0)
	public void loginTest() throws Exception {
		takeScreenshot(driver, "login");
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(true);
		System.out.println("Valid user-"+ prop.getProperty("username"));

	}
	
	@Test(priority = 1)
	public void logoDisplayTest() {
		System.out.println(homePage.isLogoDisplayed());
	}
}
