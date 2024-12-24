package com.testCases;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


import com.base.Test_Class;
import com.pages.HomePage;
import com.pages.SignUpPage;
import com.util.TestUtil;

public class SignUpPageTest extends Test_Class {
	SignUpPage signUpPage;
	Alert alert;
	HomePage homePage;

	private String un;
	private String pwd;

	public String getUsername() {
		return un;
	}

	public String getPassword() {
		return pwd;
	}

	@BeforeMethod
	public void set() {
		homePage = new HomePage();
		signUpPage = homePage.goToSignUpPage(); // Clicking on Sign Up link
	}

	@Test()
	public void registerUser() {
		String pwd = TestUtil.randomString(); // Creating random string for username and password
		String un = pwd + "@gmail.com";

		System.out.println("Registering new user on DemozBlaze " + "User: " + un);
		signUpPage.signUp(un, pwd);

		String txt = TestUtil.handleAlert(driver, alert); // Handling expected alert

		try {
			Assert.assertEquals(txt,"Sign up successful.");	 // Validating pop up's message
			System.out.println("New User successfully created");

			saveCredentialsToPropertiesFile(un, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void saveCredentialsToPropertiesFile(String username, String password) {

		// Specify the path to the properties file
		current_project_dir = System.getProperty("user.dir");
		File propFile = new File(current_project_dir + "\\src\\main\\java\\com\\config\\config.properties"); 

		try (FileOutputStream outputStream = new FileOutputStream(propFile)) {
			// Store the username and password in the properties object
			prop.setProperty("username", username);
			prop.setProperty("password", password);

			// Save the properties to the file
			prop.store(outputStream, "User credentials for login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
