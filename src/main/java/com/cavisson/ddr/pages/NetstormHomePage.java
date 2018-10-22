package com.cavisson.ddr.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.cavisson.ddr.base.TestBase;
import com.cavisson.ddr.util.TestUtil;


public class NetstormHomePage extends TestBase{

	
	//Page Repository for HomePage
	@FindBy(xpath="//span[contains(text(),'Error in getting dashboard default favorite data from server.Please check your network connection/server configuration.')]")
	
	WebElement errorpopup;
	
	@FindBy(xpath="//span[contains(text(), 'Data is not available in selected Time Period.')]")
	WebElement errorpopup1;
	
	@FindBy(xpath="//span[@class='ngn-dismiss']")
	
	WebElement closeerrpopup;
		
	@FindBy(xpath="//md-icon[@title='Dashboard']/preceding-sibling::md-icon[@title='Close This Tab']")
	
	WebElement closedashboardtb;
	
	@FindBy(xpath="//a[@href=\"#/home\"]")
	WebElement netstormhomepglabel;
	
	@FindBy(xpath="//span[contains(text(), \"Release -\")]")
	WebElement netstormrelease;
	
	@FindBy(xpath="//button[@class= 'mat-icon-button']//i[@class='icon produi-icon-tr']")
	WebElement sessionlnk;
	
	//Initialization of PageFactory
	public NetstormHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions to be taken in HomePage
	
	
	public boolean validateNetstormHome() {
		
		//System.out.println("errorpopup" + errorpopup.isDisplayed());
		//System.out.println("errorpopup1" + errorpopup1.isDisplayed());
		/*try {
			
			if (errorpopup.isDisplayed()) {
				//System.out.println("errorpopup" + errorpopup.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}catch(NoSuchElementException ne) {
			ne.printStackTrace();
			
			if (errorpopup1.isDisplayed()) {
				//System.out.println("errorpopup1" + errorpopup1.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}
		
		*/
		
		return netstormhomepglabel.isDisplayed();
	}
	
	public String validateNetstormRelease() {
		
		/*
		try {
			
			
			 if (errorpopup.isDisplayed()) {
				//System.out.println("errorpopup" + errorpopup.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}catch(NoSuchElementException ne) {
			ne.printStackTrace();
			
			if (errorpopup1.isDisplayed()) {
				//System.out.println("errorpopup1" + errorpopup1.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}
		*/
		
		return netstormrelease.getText();
	}
	
	public NetstormSessionPage clickOnSessionLink() {
		
		/*
		try {
			
			if (errorpopup.isDisplayed()) {
				//System.out.println("errorpopup" + errorpopup.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}catch(NoSuchElementException ne) {
			ne.printStackTrace();
			
			if (errorpopup1.isDisplayed()) {
				//System.out.println("errorpopup1" + errorpopup1.isDisplayed());
				TestUtil.disablErrorPopupanddashboardtab(closeerrpopup, closedashboardtb);
			}
		}
		
		*/
		
		sessionlnk.click();
		return new NetstormSessionPage();
	}
	
	
}
