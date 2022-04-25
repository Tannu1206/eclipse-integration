package com.imdb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.imdb.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\tannu.ahuja\\eclipse-workspace\\IMDB\\imdbArtifactid\\src\\main\\java\\com\\imdb\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

}
}
