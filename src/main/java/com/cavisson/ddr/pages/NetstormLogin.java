package com.cavisson.ddr.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cavisson.ddr.base.TestBase;

public class NetstormLogin extends TestBase{

	//Add PageFactory for NetstormLogin
	
	@FindBy(xpath="//input[@placeholder='User Name']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='login-button']")
	WebElement netstormlogin;
	
	//How to initialize page factory /object repository objects ?
	//Ans:- By calling PageFoctory.initElement() method this can be done.
	
	//Initialization of PageFactory
	public NetstormLogin() {
	
		PageFactory.initElements(driver, this);
	}
	
	//Actions Class
	
	//Method used to get title of page
	public String loginNetstormTitle() {
		return driver.getTitle();
	}
	
	//method used to login into Netstorm Homepage
	public NetstormHomePage loginNetstorm(String uname, String pswd) {
		
		username.sendKeys(uname);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		password.sendKeys(pswd);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		netstormlogin.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// In 4.1.11 onwards because of ACL feature this pop up came
		// If an user already logged and another want to login 
		// then popup generated like
		// "There is already one session running with the same user. 
		//  Click Ok to forcefully logout other session and login"

		try {
			
				driver.switchTo().alert();
				Alert alert = driver.switchTo().alert();				
				alert.accept();		
		}catch(Exception e) {
			
		}
		
		
		return new NetstormHomePage();
	}	
	
}
