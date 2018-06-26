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

public class NetstormSessionPageTest extends TestBase{

	NetstormLogin loginobj;
	NetstormHomePage homepageobj;
	NetstormSessionPage sessionpageobj;
	NetstormEDPage edpageobj;
	// Logger Class for enabling logging
	Logger log = Logger.getLogger(NetstormSessionPageTest.class);
	public NetstormSessionPageTest() {
		
		super();
		log.info("Called Super class constructor TestBase from NetstormSessionPageTest");
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Called setUp method");
		initialized();
		log.info("Called initialized method from NetstormSessionPageTest");
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
		
	}
	
	@Test(priority=1)
	public void validateSessionPageTest() {
		log.info("Started:validateSessionPageTest TestCase-6");
		String sessionpagelabel=sessionpageobj.validateSessionPage();
		Assert.assertEquals(sessionpagelabel, "Test Name", "User not in SessionPage");
		log.info("Completed:validateSessionPageTest TestCase-6");
	}
	
	@Test(priority=2)
	public void clickonEDLinkTest() {
		log.info("Started:clickonEDLinkTest TestCase-7");
		edpageobj=sessionpageobj.clickonEDLink();
		log.info("Completed:clickonEDLinkTest TestCase-7");
		
	}
	@AfterMethod
	public void tearDown() {
		log.info("Called tearDown: Quiting driver");
		driver.quit();
	}
}
