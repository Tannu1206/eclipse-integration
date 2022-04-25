package com.imdb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.pages.HomePage;
import com.imdb.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
	}
	
	@Test(priority=2)
	public void loginTest() {
		loginpage.SignIn();
		loginpage.CreateNewAccount();
		loginpage.Signinbutton();
		homepage=  loginpage.login(prop.getProperty("username"), prop.getProperty("pass"));
	   
	   
	 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
