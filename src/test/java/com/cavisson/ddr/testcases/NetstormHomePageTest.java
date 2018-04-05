package com.cavisson.ddr.testcases;

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
	public NetstormHomePageTest() {
			super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialized();
		loginobj = new NetstormLogin();
		sessionpageobj = new NetstormSessionPage();
		homepageobj = loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void validateNetstormHomeTest() {
		String homepagelabel= homepageobj.validateNetstormHome();
		Assert.assertEquals(homepagelabel, "Cavisson", "User not in Home Page");
	}
	
	@Test(priority=2)
	public void validateNetstormReleaseTest() {
		String netstormrelease=homepageobj.validateNetstormRelease();
		Assert.assertTrue(netstormrelease.startsWith("Release -"), "User not able to find Release information");
	}
	
	@Test(priority=3)
	public void clickonSessionTest() {
		sessionpageobj=homepageobj.clickOnSessionLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
