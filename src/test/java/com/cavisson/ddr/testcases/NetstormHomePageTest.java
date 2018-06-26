package com.cavisson.ddr.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.pages.NetstormHomePage;
import com.cavisson.ddr.pages.NetstormLogin;
import com.cavisson.ddr.pages.NetstormSessionPage;



public class NetstormHomePageTest extends TestBase{

	
	NetstormLogin loginobj;
	NetstormHomePage homepageobj;
	NetstormSessionPage sessionpageobj;
	
	// Logger Class for enabling logging
	Logger log = Logger.getLogger(NetstormHomePageTest.class);
	public NetstormHomePageTest() {
			super();
			log.info("Called Super class constructor TestBase from NetstormHomePageTest");
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Called setUp method");
		initialized();
		log.info("Called initialized method from NetstormHomePageTest");
		loginobj = new NetstormLogin();
		sessionpageobj = new NetstormSessionPage();
		homepageobj = loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("May be InterruptedException because of Thread Wait ");
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void validateNetstormHomeTest() {
		log.info("Started:validateNetstormHomeTest TestCase-3");
		boolean homepagelabel= homepageobj.validateNetstormHome();
		
		Assert.assertTrue(homepagelabel, "User not in Home Page");
		log.info("Completed:validateNetstormHomeTest TestCase-3");
	}
	
	@Test(priority=2)
	public void validateNetstormReleaseTest() {
		log.info("Started:validateNetstormReleaseTest TestCase-4");
		String netstormrelease=homepageobj.validateNetstormRelease();
		Assert.assertTrue(netstormrelease.startsWith("Release -"), "User not able to find Release information");
		log.info("Completed:validateNetstormReleaseTest TestCase-4");
	}
	
	@Test(priority=3)
	public void clickonSessionTest() {
		log.info("Started:clickonSessionTest TestCase-5");
		sessionpageobj=homepageobj.clickOnSessionLink();
		log.info("Completed:clickonSessionTest TestCase-5");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Called tearDown: Quiting driver");
		driver.quit();
	}
	
}
