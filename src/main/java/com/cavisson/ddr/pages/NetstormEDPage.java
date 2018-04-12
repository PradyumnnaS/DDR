package com.cavisson.ddr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cavisson.ddr.base.TestBase;

public class NetstormEDPage extends TestBase{

	// Creating OR for ED page
	@FindBy(xpath="//span[contains(@title,'AtgTier')]")
	WebElement tierbox;
	
	@FindBy(xpath="//span[@id=\"dashboardAtgTier\"]")
	WebElement showdashboardlnk;
	
	
	
	//Initializing Page Factory
	public NetstormEDPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateEDPage() {
		return driver.getTitle();
	}
	
	public void validateShowDashboard() {
		//Using Actions class for double click on it.
		Actions action = new Actions(driver);
		action.doubleClick(tierbox).build().perform();
		
		//RightClicking of Tier
		action.contextClick(tierbox).build().perform();
		
		//Click on Show Dashboad Tab
		showdashboardlnk.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
