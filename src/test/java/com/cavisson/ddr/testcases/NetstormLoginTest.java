package com.cavisson.ddr.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.pages.NetstormHomePage;
import com.cavisson.ddr.pages.NetstormLogin;

public class NetstormLoginTest extends TestBase{

	NetstormLogin loginobj;
	NetstormHomePage homepageobj;
	public NetstormLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialized();
		loginobj = new NetstormLogin();
		
	}
	
	@Test(priority=1)
	public void loginNetstormTitletest() {
		String netstormlogintitile = loginobj.loginNetstormTitle();
		Assert.assertEquals(netstormlogintitile, "Cavisson NetDiagnostics Enterprise","User Not in Netstorm Login page");
	}
	
	@Test(priority=2)
	public void loginNetstormTest() {
		
		homepageobj=loginobj.loginNetstorm(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
