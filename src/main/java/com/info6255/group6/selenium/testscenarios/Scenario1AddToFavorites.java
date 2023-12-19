package com.info6255.group6.selenium.testscenarios;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.info6255.group6.selenium.Utils;
import java.util.concurrent.TimeUnit;


public class Scenario1AddToFavorites {
	static Logger logger = Logger.getLogger(Scenario1AddToFavorites.class.getName());

	public static void runScenario(WebDriver driver, ExtentTest test) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
//		Selecting the search input
		
		System.out.print("Scenario1--------AddToFavorites");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement e = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]"))));
//		e.sendKeys(new String[] { "Course Registration (NEW)" });
//		Utils.takeScreenShot(driver, "scenario1_enter_in_search");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//i[@data-gtm-event-action=\"Course Registration (NEW)\"]")).click();
//		Utils.takeScreenShot(driver, "scenario1_add_fav");
		
		
		
//		WebElement w = wait.until(ExpectedConditions.elementToBeClickable(
//				));
//		w.click();
//		driver.quit();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]")).click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Utils.takeScreenShot(driver, "scenario1_enter_in_search");
		driver.findElement(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[1]/div[2]/div/div[1]/div/div/img")).click();
		driver.manage().timeouts().wait(100);
		driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[5]/div/i")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[9]/div/i")).click();
		Utils.takeScreenShot(driver, "scenario1_add_fav");
		
		System.out.print("Scenario1--------AddToFavorites----fiished");

//		test.log(Status.INFO, "Expected: Add Course Registration to Favorites, Actual: Added Course Registration to Favorites");
	}

}
