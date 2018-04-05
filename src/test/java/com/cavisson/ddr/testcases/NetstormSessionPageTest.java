package com.cavisson.ddr.testcases;

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
	public NetstormSessionPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialized();
		loginobj = new NetstormLogin();
		homepageobj = loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sessionpageobj=homepageobj.clickOnSessionLink();
		
	}
	
	@Test(priority=1)
	public void validateSessionPageTest() {
		String sessionpagelabel=sessionpageobj.validateSessionPage();
		Assert.assertEquals(sessionpagelabel, "Session Number", "User not in SessionPage");
	}
	
	@Test(priority=2)
	public void clickonEDLinkTest() {
		edpageobj=sessionpageobj.clickonEDLink();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
