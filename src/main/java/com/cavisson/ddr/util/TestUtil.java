package com.cavisson.ddr.util;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import com.cavisson.ddr.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICITELY_WAIT = 10;
	
	
	//Switch to Window method
	//It has two sets of methods
	// Method 1: switchToChildWindow :- Switching to child window
	// Method 2: switchBackToParentWindow :- Switching back to Parent window
	public String  switchToChildWindow() {
		String parentwindow = null;
		Set<String> handles = driver.getWindowHandles();
		if (handles.size()==2) {
			System.out.println(handles.size());
			Iterator<String> it = handles.iterator();
			parentwindow= it.next();
			//System.out.println("Parent window is:"+ parentwindow);
			String childwindow=it.next();
			//System.out.println("Child window is:"+ childwindow);
		
			//Switching to ED
			driver.switchTo().window(childwindow);
		}
		
		return parentwindow;
	}
	
	public void switchBackToParentWindow(String parentwindow) {
		driver.close();
		driver.switchTo().window(parentwindow);
	}
	
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
