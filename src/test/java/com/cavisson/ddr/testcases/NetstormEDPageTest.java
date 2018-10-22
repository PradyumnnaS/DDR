package com.cavisson.ddr.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.pages.NDFlowPathReportPage;
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
	NDFlowPathReportPage fprptobj;
	
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
		
		fprptobj= new NDFlowPathReportPage();
		
		
	}
	
	@Test(priority=1)
	public void titleOfExecutiveDashboardTest() {
		
		log.info("Started:validateEDPageTest TestCase-8");
		
		//Switching to ED
		//driver.switchTo().window(childwindow);
		String parentwindow=testutilobj.switchToChildWindow();

		String edhomepagecheck= edpageobj.titleOfExecutiveDashboard();
		Assert.assertEquals(edhomepagecheck, "Executive Dashboard", "Failed:User not present in Executive Dashboard Page");
		
		//Switching Back to SessionPage
		
		testutilobj.switchBackToParentWindow(parentwindow);
		
		log.info("Completed:validateEDPageTest TestCase-8");
	}
	
	@Test(priority=2)
	public void showDashboardInEDTest() {
		
		log.info("Started:validateShowDashboardTest TestCase-9");
		
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		boolean showdashboardlabelcheck=edpageobj.showDashboardInED();
		
		Assert.assertTrue(showdashboardlabelcheck, "Failed: Show Dashboard is not showing");

		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		
		log.info("Completed:validateShowDashboardTest TestCase-9");
		
		
	}
	
	@Test(priority=3)
	public void tierInfoInEDTest() {
		log.info("Started:validateTierInfoTest TestCase-10");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		String tierinfolabel = edpageobj.tierInfoInED();
		Assert.assertEquals(tierinfolabel, "Tier Info", "Failed: Tier Info PopUp Label changed or it is not opening");
		
		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		
		log.info("Completed:validateTierInfoTest TestCase-11");
		
	}
	
	@Test(priority=4)
	public void overviewInTierInfoTest() {
		log.info("Started:overviewInTierInfoTest TestCase-11");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		String tierlabelinoverview = edpageobj.overviewInTierInfo();
		Assert.assertEquals(tierlabelinoverview, "AtgTier", "Failed: Tier Details is not showing in OverView tab in TierInfo" );
		
		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		
		
		log.info("Completed:overviewInTierInfoTest TestCase-11");
		
	}
	
	@Test(priority=5)
	public void healthInTierInfoTest() {
		
		log.info("Started:healthInTierInfoTest TestCase-12");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		String tierlabelinhealth=edpageobj.healthInTierInfo();
		Assert.assertEquals(tierlabelinhealth, "AtgTier", "Failed: Tier Details is not showing in Health tab in TierInfo");
		
		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:healthInTierInfoTest TestCase-12");
	}
	
	/*@Test(priority=6)
	public void noDataInTpsOrResponseTest() {
		log.info("Started:validateEDPageTest TestCase-13");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		String nodatalable= edpageobj.noDataInTpsOrResponse();
		Assert.assertEquals(nodatalable, "No data available!", "Failed: No data available! element is not showing in ED");
		
		//Switching Back to SessionPage
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:validateEDPageTest TestCase-13");
	}*/
	
	@Test(priority=6)
	public void top10TPSPopUpLabelTest() {
		log.info("Started:tpsPopUpLabelTest TestCase-14");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
	
		String tpslabel = edpageobj.top10TPSPopUpLabel();
		Assert.assertEquals(tpslabel, "Top 10 TPS", "Failed: TPS PopUp Label changed or popup is not displaying");
	
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:tpsPopUpLabelTest TestCase-14");
		
	}
	
	@Test(priority=7)
	public void btShowingInTop10TpsTest() {
		log.info("Started:validateBtShowingInTpsTest TestCase-15");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		Boolean btintps = edpageobj.btShowingInTop10Tps();
		Assert.assertTrue(btintps, "Failed: TPS Tab is not showing any Business Transction / Business Transaction exceeds more then 10 count");
		
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:validateBtShowingInTpsTest TestCase-15");
		
	}
	
	@Test(priority=8)
	public void top10ResponsePopUpLabelTest() {
		
		log.info("Started:responsePopUpLabelTest TestCase-16");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		String responselabel = edpageobj.top10ResponsePopUpLabel();
		Assert.assertEquals(responselabel, "Top 10 Response", "Failed: Response PopUp Label changed or popup is not displaying");
		
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:responsePopUpLabelTest TestCase-16");
		
	}
	
	@Test(priority=9)
	public void validateBtShowingInResponseTest() {
		
		log.info("Started:validateBtShowingInResponseTest TestCase-16");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
	
		Boolean btintps = edpageobj.btShowingInTop10Tps();
		Assert.assertTrue(btintps, "Failed: Response Tab is not showing any Business Transction / Business Transaction exceeds more then 10 count");
		
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:validateBtShowingInResponseTest TestCase-16");
	
	}
	
	@Test(priority=10)
	public void showFlowPathForSelectedTierTest() {
		
		log.info("Started:showFlowPathForSelectedTierTest TestCase-17");
		//Switching to ED
		String parentwindow=testutilobj.switchToChildWindow();
		
		Assert.assertTrue(edpageobj.showFlowPathForSelectedTier(), "Failed: Show FlowPath For Selected Tier is not showing");
		
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:showFlowPathForSelectedTierTest TestCase-17");
		
	}
	
	@Test(priority=11)
	public void flowpathByResponseTimefromTierDrillDownTest() {
		log.info("Started:validateFPReportByTierRightClickTest TestCase-18");
		//Switching to ED
		
		String parentwindow=testutilobj.switchToChildWindow();
		
		fprptobj=edpageobj.flowpathByResponseTimefromTierDrillDown();
		
		//Switching Back to SessionPage	
		testutilobj.switchBackToParentWindow(parentwindow);
		log.info("Completed:validateFPReportByTierRightClickTest TestCase-18");
		
	}
	
	@Test(priority=12)
	public void flowpathByCallOutErrorfromTierDrillDownTest() {
		
	}
	
	@Test(priority=13)
	public void slowDBCallByResponseTimeTest() {
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		log.info("Called tearDown: Quiting driver");
		driver.quit();
	}
}
