package com.info6255.group6.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.concurrent.TimeUnit;

import com.info6255.group6.selenium.testscenarios.*;
import com.info6255.group6.selenium.Utils.*;


/**
 * Group 4 Selenium Testing Assignment. Main Driver class for testing the
 * scenarios
 *
 */
public class App {

	static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws InterruptedException {
		try (InputStream input = new FileInputStream("./config.properties")) {

			
			   // -----------------------SETUP-------------------------------------- long
			   long scriptStartTime = System.currentTimeMillis(); 
			   Properties prop = new
			   Properties(); prop.load(input);
			   
			   // setting the driver executable
			   System.setProperty("webdriver.chrome.driver", "chromedriver");
			   
			   // -------------------------------------------------------------------
			   
			   
			   // --------------------PERFORM TESTS----------------------------------
			   //Scenario 1
				 
			 
			   // Initiating your chromedriver 
			   WebDriver driver = new ChromeDriver();
			   
			   driver.manage().window().maximize(); 
			   // Login 
			   performLogin(driver, prop, null);
			   
			   Scenario1AddToFavorites.runScenario(driver, null);
			   
			 //Scenario 3
				 
			
//			  // Initiating your chromedriver driver = new ChromeDriver();
//			  
//			  driver.manage().window().maximize();
//			  
//			  // login performLogin(driver, prop, test); // Browse Classes
//			  Scenario3BrowseClasses.runScenario(driver);
			  
			 
			   /**
				 * Scenario 5
				 *//*
					 * // Initiating your chromedriver driver = new ChromeDriver();
					 * 
					 * driver.manage().window().maximize();
					 * 
					 * // login performLogin(driver, prop);
					 * 
					 * // Create a course plan Scenario5CoursePlan.runScenario(driver);
					 * 
					 * long scriptEndTime = System.currentTimeMillis();
					 * 
					 * logger.log(Level.INFO, "Script took " + (scriptEndTime - scriptStartTime) /
					 * 1000 + " seconds to complete"); // driver.close();
					 */
			// ---------------------------------------------------------------------
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static void performLogin(WebDriver driver, Properties prop, ExtentTest test) {
		driver.get("https://me.northeastern.edu/");
		Utils.takeScreenShot(driver, "meneu_main_page");
		Utils.takeSnapShot(driver, "./screenshot/test.png");
		
		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(prop.getProperty("NEU_USERNAME"));
		WebDriverWait wait = new WebDriverWait(driver, 500);

		//*[@id="idSIButton9"]
		
		

		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
//
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

		username.sendKeys(prop.getProperty("NEU_USERNAME"));

		WebElement password = driver.findElement(By.id("password"));

		password.sendKeys(prop.getProperty("NEU_PASSWORD"));
		Utils.takeScreenShot(driver, "myneu_login_page_credentials");
		driver.findElement(By.xpath("/html/body/section/div/div[1]/div/form/div[3]/button")).click();

		// code to switch to iframe for duo two factor notification

		
		driver.switchTo().frame("duo_iframe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Utils.takeScreenShot(driver, "login_duo");
		driver.findElement(By.xpath(" //*[@id=\"login-form\"]/fieldset/div/select/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"auth_methods\"]/fieldset[2]/div[1]/button")).click();
//		test.log(Status.INFO, "Expected: Login with 2FA, Actual: Logged in with 2FA");
		driver.switchTo().defaultContent();
		

		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();	
		
		
		
	}
}
