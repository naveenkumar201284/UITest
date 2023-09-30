package com.runner;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import filloreader.FilloReader;
import screenshot.ScreenShot;
import test.Test1;

public class BrowserInit2 {
	
public static final Logger log = Logger.getLogger(Test1.class.getName());
	
	ScreenShot ss;
	static List<Map<String, String>> pram = new ArrayList<Map<String, String>>();    
    String RunMode="";
	String filepath=System.getProperty("user.dir") + "\\src\\main\\java\\datamanager\\";
	FilloReader fillo;
	static WebDriver driver;
	
	public static void Initialize() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://www.testyou.in/Login.aspx");

			
			pram=new FilloReader().getTestDataInListMap(new File("C:\\Users\\naveen.kumar\\Downloads\\Labloid_POMFramework-master\\src\\main\\java\\datamanager\\loginData.xlsx"),"login", "select * from %s where Runmode='Yes'"); 
			
			for (Map<String, String> data : pram) {
				
			String email_id=data.get("Email");
			driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).clear();
			driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).sendKeys(email_id);
			log.info(email_id);
			
			
			String password=data.get("Password");
			driver.findElement(By.name("ctl00$CPHContainer$txtPassword")).clear();
			driver.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys(password);
			log.info(password);
			driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();
			//util.setUp();
			}
	}
	
	
	@Test
	public void UpdatingData() throws Exception {
		log.info("This is a Test");
		ss = new ScreenShot();
		pram=new FilloReader().getTestDataInListMap(new File("C:\\Users\\naveen.kumar\\Downloads\\Labloid_POMFramework-master\\src\\main\\java\\datamanager\\loginData.xlsx"),"data", "select * from %s where Runmode='Yes'"); 
		for (Map<String, String> data : pram) {
			try {
			//test=extent.createTest("Testing Testyou application");

			driver.findElement(By.xpath("//div[@class='edit_link']")).click();
			
			String first_name=data.get("Fname");
			if(first_name != null && !first_name.isEmpty()) {
			driver.findElement(By.name("ctl00$CPHContainer$txtFirstName")).clear();
			driver.findElement(By.name("ctl00$CPHContainer$txtFirstName")).sendKeys(first_name);
			log.info(first_name);
			}
			
			String last_name=data.get("Lname");
			if(last_name != null && !last_name.isEmpty()) {
			driver.findElement(By.name("ctl00$CPHContainer$txtLastName")).clear();
			driver.findElement(By.name("ctl00$CPHContainer$txtLastName")).sendKeys(last_name);
			log.info(last_name);
			}
			
			String city=data.get("City");
			if(city != null && !city.isEmpty()) {
			driver.findElement(By.id("ctl00_CPHContainer_txtCity")).clear();
			driver.findElement(By.id("ctl00_CPHContainer_txtCity")).sendKeys(city);
			log.info(city);
			}
			
			String state=data.get("State");
			if(state != null && !state.isEmpty()) {
			driver.findElement(By.name("ctl00$CPHContainer$txtState")).clear();
			driver.findElement(By.name("ctl00$CPHContainer$txtState")).sendKeys(state);
			log.info(state);
			}
			
			
			String college=data.get("College");
			if(college != null && !college.isEmpty()) {
			driver.findElement(By.id("ctl00_CPHContainer_txtCollege")).clear();
			driver.findElement(By.id("ctl00_CPHContainer_txtCollege")).sendKeys(college);
			log.info(college);
			}
			
						
			driver.findElement(By.name("ctl00$CPHContainer$btnUpdateProfile")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();

			}
			catch(Exception e) {
				WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
				ele.click();

			continue;

			}
		}
	}
	
	
	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}


	public static void TearDown() throws Exception{
		WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		ele.click();

		driver.close();
	}

}
