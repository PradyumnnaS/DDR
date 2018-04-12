package com.cavisson.ddr.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cavisson.ddr.util.EventListener;
import com.cavisson.ddr.util.TestUtil;
import com.cavisson.ddr.base.TestBase;



public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	//For WebDriver Fire Events
	public static EventFiringWebDriver e_driver;
	public static EventListener weblistener; 
	
	// Logger Class for enabling logging
	public static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase(){
		
		
		prop = new Properties();
		
		try {
			
			log.info("Getting configuration values from config.properties "
					+ "and loading the data into Properties class instance");
			
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/cavisson/ddr/config/config.properties");
			prop.load(fin);
			
			log.info("Config.properties file loaded successfully");		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Config Properties not found");
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("May be file not exsist");
			e.printStackTrace();
		}
	}
	
	public static void initialized() {
	
		// Getting browser name from config.properties file
		log.info("Default Initialization started");
		
		String browserName = prop.getProperty("browser");
				
		if (browserName.equals("chrome")) {
					
			System.setProperty("webdriver.chrome.driver",
					"/home/PradyumnnaS/EclipseHome/workspace/DDR/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",
					"/home/PradyumnnaS/EclipseHome/workspace/DDR/geckodriver");
			driver = new FirefoxDriver();
		}
		
		//Creating WebDriver Fire event object
				//that is creating objects for WebDriverEventListener
				e_driver = new EventFiringWebDriver(driver);
				weblistener = new EventListener();
				e_driver.register(weblistener);
				driver = e_driver;
		
		// Default value for webdriver driver 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITELY_WAIT, TimeUnit.SECONDS);
					
					
		// Calling url
			driver.get(prop.getProperty("url"));
			
			log.info("Default initialization finished");
	}

	
}
