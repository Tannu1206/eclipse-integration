package com.imdb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.pages.HomePage;
import com.imdb.qa.pages.LoginPage;
import com.imdb.qa.pages.MenuPage;
import com.imdb.qa.pages.WatchListPage;
import com.imdb.qa.pages.topBoxOfficePage;

public class watchlistPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	MenuPage menupage;
	topBoxOfficePage topboxoffice;
	WatchListPage watchlistpage;
	
	public watchlistPageTest() {
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
		  topboxoffice = new topBoxOfficePage();
		  menupage.MenuSelect("Top Box Office"); 
		  topboxoffice.clickOnMovieWatchlist();
		  watchlistpage = new WatchListPage();
		  watchlistpage =topboxoffice.watchlistButton();
	}
	
	@Test(priority=1)
	public void watchListpageMovieTitleTest() throws InterruptedException {
		Thread.sleep(10000);
		String actualTitle =topboxoffice.gettingMovieTitle();
		String expectedTitle = watchlistpage.watchListpageMovieTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2)
	public void navigatingTopBoxOfficePageTest() throws InterruptedException {
		watchlistpage.navigatingTopBoxOfficePage();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
		  
		  
		  

}
