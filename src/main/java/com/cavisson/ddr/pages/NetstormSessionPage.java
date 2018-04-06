package com.cavisson.ddr.pages;

import java.util.List;

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
	
	@FindBy(xpath="//td//span/parent::a/parent::span/parent::td/preceding-sibling::td//span[contains(@class,'ui-chkbox-icon ui-clickable')]")
	List<WebElement> trcheckbox;
	
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
		
		//sending testrun number from that present in config directory
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
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Total checkbox count:-"+trcheckbox.size());
		
		if(trcheckbox.size()==2) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", trcheckbox.get(1));
		}else {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", trcheckbox.get(0));
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click on EDbtn
		edbtnlink.click();
				
		return new NetstormEDPage();
	}		
}
