package com.cavisson.ddr.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cavisson.ddr.base.TestBase;

public class NetstormSessionPage extends TestBase{

	//Page Factory for SessionPage
	@FindBy(xpath="//span[contains(text(),\"Session Number\")]")
	WebElement sessionlabel;
	
	@FindBy(xpath="//label[contains(text(),'Search')]/parent::div/following-sibling::div/input[@type='text']")
	WebElement testrunsearchbox;
	
	@FindBy(xpath="//label[contains(text(),'Duration')]/parent::div/following-sibling::div//div//span[@class='fa fa-fw fa-caret-down ui-clickable']")
	WebElement durationdrowdownicon;
	
	@FindBy(xpath="//label[contains(text(),'Started')]/parent::div/following-sibling::div//div//span[@class='fa fa-fw fa-caret-down ui-clickable']")
	WebElement starteddropdownicon;
	
	@FindBy(xpath="//li/span[contains(text(), \"All\")]")
	WebElement selectAlllabel;
	
	@FindBy(xpath="//span[contains(text(), \"Apply\")]/parent::button[@style='margin-left: 3%; margin-top: 9%']")
	WebElement applybtn;
	
	@FindBy(xpath="//td//span[contains(text(),'1082')]/parent::a/parent::span/parent::td/preceding-sibling::td//span[contains(@class,'ui-chkbox-icon ui-clickable')]")
	WebElement trselectcheckbox;
	
	@FindBy(xpath="//span[contains(text(), 'Executive Dashboard')]")
	WebElement edbtnlink;
	
	//initialized page factory objects
	
	public NetstormSessionPage() {	
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateSessionPage() {
		return sessionlabel.getText();
	}
	
	public NetstormEDPage clickonEDLink() {
		//send test run number given in conf file
		
		testrunsearchbox.sendKeys(prop.getProperty("testrun"));
		
		//selecting all from duration drop down 
		durationdrowdownicon.click();
		selectAlllabel.click();
		
		//select all from started drop down
		starteddropdownicon.click();
		selectAlllabel.click();
		
		//Static 1 sec wait before clicking on apply button
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applybtn.click();
		
		//Now selecting check box for the tr 
		//Here encountered issue like element is not displayed but present in DOM
		//Hence used JavaScriptExecutor for this .
		//Static 1 sec wait before selecting TR check box
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//System.out.println("Element Displayed in DOM Going to perform click operation");
		js.executeScript("arguments[0].click();", trselectcheckbox);
		
		//Click on EDbtn
		edbtnlink.click();
		
		return new NetstormEDPage();
		
	}
}
