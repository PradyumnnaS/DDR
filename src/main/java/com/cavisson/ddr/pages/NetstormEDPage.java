package com.cavisson.ddr.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.util.TestUtil;

public class NetstormEDPage extends TestBase{

	// Creating OR for ED page
	@FindBy(xpath="//span[contains(@title,'AtgTier')]")
	WebElement tierbox;
	
	//@FindBy(xpath="//span[contains(@title,'AppTier')]")
	//WebElement tierboxnodata;
	
	//Show Dashboard Page Objects
	@FindBy(xpath="//span[@id=\"dashboardAtgTier\"]")
	WebElement showdashboardlnk;
	
	@FindBy(xpath="//*[name()='svg']/*[name()='text']/*[name()='tspan']") // svg tag uses like this 
	List<WebElement> lebelsinshowdashboard;
	
	@FindBy(xpath="//a[contains(@onclick, 'hideDashboard();')]")
	WebElement closeshowdashboard;
	
	// TierInfo Page Object
	
	@FindBy(xpath="//a[@onclick=\"openTierInfo('AtgTier','JavaInstance.png','');\"]")
	WebElement showtierinfolink;
	
	@FindBy(xpath="//span[@id='ui-id-1']")
	WebElement tierinfotablable;
	
	@FindBy(xpath="//a[contains(text(), \"OverView\")]")
	WebElement tierinfooverview;
	
	@FindBy(xpath="//a[@href='#TierAtgTier']")
	WebElement tierlableinoverviw;
	
	@FindBy(xpath="//a[contains(text(), \"Health\")]")
	WebElement tierinfohealth;
	
	@FindBy(xpath="//div[@style='display: table-row;']//b[contains(text(), \"AtgTier\")]")
	WebElement tierlableinhealth;
	
	@FindBy(xpath="//button[@type='button']//span[@class='glyphicon glyphicon-remove']")
	WebElement quittierinfo;
	
	//Top 10 Transactions TPS Page Object
	
	@FindBy(xpath="//div[@id='context-menu1']//a[contains(text(), 'Top 10 Transactions By')]")
	WebElement top10trxbyatgtier;
	
	@FindBy(xpath="//div[@id='context-menu1']//a[contains(text(), 'Top 10 Transactions By')]/parent::li//ul//li/a[contains(text(), 'TPS')]")
	WebElement tpslink;
	
	@FindBy(xpath="//div//span[contains(text(), \"Top 10 TPS\")]")
	WebElement tpspopuplabel;
	
	@FindBy(xpath="//div[@id='divimgAtgTier']//div[@class='slick-cell l0 r0 cell-left']")
	List<WebElement> btcount;
	
	@FindBy(xpath="//a[@onclick=\"hideBTTable('AtgTier');\"]")
	WebElement quittpstab;
	
	//Top 10 Transactions Response Response Page
	
	@FindBy(xpath="//div[@id='context-menu1']//a[contains(text(), 'Top 10 Transactions By')]/parent::li//ul//li/a[contains(text(), 'Response')]")
	WebElement responselink;
	
	@FindBy(xpath="//div//span[contains(text(), \"Top 10 Response\")]")
	WebElement responsepopuplabel;
	
	@FindBy(xpath="//div[contains(text(),\"No data available!\")]")
	WebElement nodatalable;
	
	@FindBy(xpath="//span[@title='CPU Utilization (%) = 0']//img[@src='../images/cpu_legend.png']")
	List<WebElement> tierboxcount;
	
	@FindBy(xpath="//a[@onclick=\"showOnlyTierFlowMap('AtgTier');\"]")
	WebElement showflowpathforselectedtier;
	
	@FindBy(xpath="//a[@onclick=\"showFullFlowMap();\"]")
	WebElement showfullfpmap;

	// Drill Down options
	
	@FindBy(xpath="//div[contains(@id,'context-menu1')]//li//a[contains(text(), \"DrillDown\")]")
	WebElement drilldown;
	
	@FindBy(xpath="//div[contains(@id,'context-menu1')]//a[contains(text(), \" Flowpaths By Response time\")]")
	WebElement fpbyresp;
	
	//Initializing Page Factory
	public NetstormEDPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String titleOfExecutiveDashboard() {
		return driver.getTitle();
	}
	
	public boolean showDashboardInED() {
		//Using Actions class for double click on it.
		//Actions action = new Actions(driver);
		//action.doubleClick(tierbox).build().perform();
		
		//RightClicking of Tier
		//action.contextClick(tierbox).build().perform();
		
		//The below static method openTierDropDownMenu Does the same what the above code does
		TestUtil.openTierDropDownMenu(tierbox);
		
		//Click on Show Dashboad Tab
		showdashboardlnk.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lebelsinshowdashboard.size() > 0) {
			closeshowdashboard.click();
			return true;
		}
		else {
			closeshowdashboard.click();
			return false;
		}
		
	}
	
	public String tierInfoInED() {
		
		//Opening DropDown
		TestUtil.openTierDropDownMenu(tierbox);
				
		//Click on Show Tier Info
		showtierinfolink.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String tierinfolable = tierinfotablable.getText();
		
		//Closing Tier info
		quittierinfo.click();
		
		return tierinfolable;
				
	}
	
	public String overviewInTierInfo() {
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
		
		//Click on Show Tier Info
		showtierinfolink.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (tierinfooverview.getText().equals("OverView")) {
			String overviewtierlabel = tierlableinoverviw.getText();
			
			//Closing Tier info
			quittierinfo.click();
			return overviewtierlabel;
		}else {
			
			//Closing Tier info
			quittierinfo.click();
			return null;
		}
			
	}
	
	public String healthInTierInfo() {
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
		
		//Click on Show Tier Info
		showtierinfolink.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click on health tab link
		tierinfohealth.click();
		
		String tierhealthlable = tierlableinhealth.getText();
		
		//Closing Tier info
		quittierinfo.click();
		
		return tierhealthlable; 
			
	}
	
	/*public String noDataInTpsOrResponse() {
		//Opening Drop down
		TestUtil.openTierDropDownMenu(tierboxnodata);
		
		//mouseHover to Top 10 Transaction By
		Actions action = new Actions(driver);
		action.moveToElement(top10trxbyatgtier).build().perform();
		
		//Clicking on TPS 
		tpslink.click();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nodata=nodatalable.getText();
		return nodata;
		
	}*/
	
	public String top10TPSPopUpLabel() {
		
		//Opening Drop down
		TestUtil.openTierDropDownMenu(tierbox);
		
		//mouseHover to Top 10 Transaction By
		Actions action = new Actions(driver);
		action.moveToElement(top10trxbyatgtier).build().perform();
		
		//Clicking on TPS 
		tpslink.click();
		
		String tpslable = tpspopuplabel.getText();
		
		return tpslable;
		
	}
	
	public boolean btShowingInTop10Tps() {
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
				
		//mouseHover to Top 10 Transaction By
		Actions action = new Actions(driver);
		action.moveToElement(top10trxbyatgtier).build().perform();
				
		//Clicking on TPS 
		tpslink.click();
		
		if (btcount.size() > 0 && btcount.size()<=10) {
			return true ;
		}else {
			return false ;
		}
		
	}
	
	public String top10ResponsePopUpLabel() {
		
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
						
		//mouseHover to Top 10 Transaction By
		Actions action = new Actions(driver);
		action.moveToElement(top10trxbyatgtier).build().perform();
		
		//Clicking on Response
		responselink.click();
		
		String responselable=responsepopuplabel.getText();
		
		return responselable;
	}
	
	public boolean showFlowPathForSelectedTier() {
		
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
		
		//Clicking on Show Flowpath For selected Tier
		showflowpathforselectedtier.click();
		
		TestUtil.openTierDropDownMenu(tierbox);

		if (tierboxcount.size()==1 && showfullfpmap.getText().equals("Show Full FlowMap")) {
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public NDFlowPathReportPage flowpathByResponseTimefromTierDrillDown() {
		
		//Opening Drop Down
		TestUtil.openTierDropDownMenu(tierbox);
		
		//mouseHover to Drill down
		
		Actions action = new Actions(driver);
		action.moveToElement(drilldown).build().perform();
		
		//Clicking on Flowpath By Response Time
		fpbyresp.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new NDFlowPathReportPage();
		
	}
}
