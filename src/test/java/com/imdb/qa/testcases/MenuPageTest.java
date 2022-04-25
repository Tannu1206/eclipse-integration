package com.imdb.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.pages.HomePage;
import com.imdb.qa.pages.LoginPage;
import com.imdb.qa.pages.MenuPage;

public class MenuPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	MenuPage menupage;

	
	
	public MenuPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage = new LoginPage();
		 loginpage.SignIn();
		 loginpage.CreateNewAccount();
		 loginpage.Signinbutton();
		  homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("pass"));
		  menupage=homePage.clickOnMenu();
		  
}
@Test(priority=2)
public void selectElementFromListTest() {
	menupage.MenuSelect("Top Box Office");
	
}
@Test(priority=1)
public void countElementTest() {
	boolean flag= menupage.MenuCount();
	Assert.assertTrue(flag);

	
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
