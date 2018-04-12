package com.cavisson.ddr.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.pages.NetstormEDPage;
import com.cavisson.ddr.pages.NetstormHomePage;
import com.cavisson.ddr.pages.NetstormLogin;
import com.cavisson.ddr.pages.NetstormSessionPage;
import com.cavisson.ddr.util.TestUtil;

public class NetstormEDPageTest extends TestBase {
	
	NetstormLogin loginobj;
	NetstormHomePage homepageobj;
	NetstormSessionPage sessionpageobj;
	NetstormEDPage edpageobj;
	TestUtil testutilobj;
	// Logger Class for enabling logging
	Logger log = Logger.getLogger(NetstormEDPageTest.class);
	public NetstormEDPageTest() {
		super();
		log.info("Called Super class constructor TestBase from NetstormEDPageTest");
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Called setUp method");
		//Calling initialing method
		initialized();
		log.info("Called initialized method from NetstormEDPageTest");
		loginobj = new NetstormLogin();
		homepageobj = loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("May be InterruptedException because of Thread Wait ");
			e.printStackTrace();
		}
		
		sessionpageobj=homepageobj.clickOnSessionLink();
		edpageobj=sessionpageobj.clickonEDLink();
		testutilobj = new TestUtil();
		//testutilobj.switchToEDWindow();
		
	}
	
	@Test(priority=1)
	public void validateEDPageTest() {
		
		log.info("Started:validateEDPageTest TestCase-8");
		
		//Switching to ED
		//driver.switchTo().window(childwindow);
		String parentwindow=testutilobj.switchToChildWindow();

		String edhomepagecheck= edpageobj.validateEDPage();
		Assert.assertEquals(edhomepagecheck, "Executive Dashboard", "Failed:User not present in Executive Dashboard Page");
		
		//Switching Back to SessionPage
		
		testutilobj.switchBackToParentWindow(parentwindow);
		
		log.info("Completed:validateEDPageTest TestCase-8");
	}
	
	@Test(priority=2)
	public void validateShowDashboardTest() {
		
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		edpageobj.validateShowDashboard();
		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		log.info("Called tearDown: Quiting driver");
		driver.quit();
	}
}
