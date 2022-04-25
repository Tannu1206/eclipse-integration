package com.imdb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.pages.HomePage;
import com.imdb.qa.pages.LoginPage;
import com.imdb.qa.pages.MenuPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	MenuPage menupage;
	
	public HomePageTest() {
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
		  
	}
	
	@Test
	public void logoImageTest() {
		boolean flag= homePage.logoimage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void menubuttonTest() {
		boolean flag1= homePage.menubutton();
		Assert.assertTrue(flag1);
	}
	
	@Test
	public void searchBarTest() {
		boolean flag2= homePage.searchBar();
		Assert.assertTrue(flag2);
	}
	@Test
	public void WatchlistIconTest() {
		boolean flag3= homePage.WatchlistIcon();
		Assert.assertTrue(flag3);
	}
	@Test
	public void userNameTest() {
		boolean flag4= homePage.userName();
		Assert.assertTrue(flag4);
	}
	@Test
	public void menuClick() {
		menupage=	homePage.clickOnMenu();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
