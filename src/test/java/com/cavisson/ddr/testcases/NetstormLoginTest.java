package com.cavisson.ddr.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.pages.NetstormHomePage;
import com.cavisson.ddr.pages.NetstormLogin;
import com.cavisson.ddr.util.RetryAnalyzer;

public class NetstormLoginTest extends TestBase{

	NetstormLogin loginobj;
	NetstormHomePage homepageobj;
	
	// Logger Class for enabling logging
	Logger log = Logger.getLogger(NetstormLoginTest.class);
	
	public NetstormLoginTest() {
		
		super();
		log.info("Called Super class constructor TestBase from NetstormLoginTest");
	}
	
	@BeforeMethod
	public void setUp() {
		
		log.info("Called setUp method");
		initialized();
		log.info("Called initialized method from NetstormLoginTest");
		
		loginobj = new NetstormLogin();
		
	}
	
	@Test(priority=1)
	public void loginNetstormTitletest() {
		log.info("Started:loginNetstormTitletest TestCase-1");
		
		String netstormlogintitile = loginobj.loginNetstormTitle();
		Assert.assertEquals(netstormlogintitile, "Cavisson NetDiagnostics Enterprise","User Not in Netstorm Login page");
		
		log.info("Completed:loginNetstormTitletest TestCase-1");
	}
	
	@Test(priority=2, retryAnalyzer =RetryAnalyzer.class)
	public void loginNetstormTest() {
		log.info("Started:loginNetstormTest TestCase-2");
		
		homepageobj=loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
		
		log.info("Completed:loginNetstormTest TestCase-2");
	}
	
	@AfterMethod
	public void tearDown() {
		
		log.info("Called tearDown: Quiting driver");
		driver.quit();
	}
}
