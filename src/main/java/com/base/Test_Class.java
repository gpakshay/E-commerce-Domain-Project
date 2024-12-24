package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.pages.LoginPage;

public class Test_Class {
	public static WebDriver driver;
	public LoginPage loginPage;
	public static Properties prop= new Properties();
	public static String current_project_dir;
	
	public Test_Class() {
		try
		{
			current_project_dir=System.getProperty("user.dir");
			File propFile = new File(current_project_dir+"\\src\\main\\java\\com\\config\\config.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
			
		}
		catch(IOException e)
		{
			e.getMessage();
			e.getStackTrace();
		}
	}
	
	public static void takeScreenshot(WebDriver driver,String name)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+name+System.currentTimeMillis()+".png");
		  
		  try {
			FileHandler.copy(temp,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialazation()
	{
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));	
		driver.get(prop.getProperty("url"));
		
	}
	
	@BeforeSuite
	public void setUp()
	{
		
		initialazation();
		loginPage = new LoginPage();
		
	}
	
	@AfterSuite
	public void closeDown()
	{
		driver.quit();
	}
}
