package com.cavisson.ddr.util;


import org.openqa.selenium.WebElement;
import com.cavisson.ddr.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICITELY_WAIT = 10;
	
	
	//used for closing error popup below
	//Error in getting dashboard default favorite data from server.Please check your network connection/server configuration.
	
	public  static void disablErrorPopupanddashboardtab (WebElement dismisserrorpopup, WebElement dashboardtbelement) {
	
		dismisserrorpopup.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dashboardtbelement.click();
		
	}
	
}
