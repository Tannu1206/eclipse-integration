package com.imdb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.pages.HomePage;
import com.imdb.qa.pages.LoginPage;
import com.imdb.qa.pages.MenuPage;
import com.imdb.qa.pages.SearchPage;
import com.imdb.qa.pages.WatchListPage;
import com.imdb.qa.pages.topBoxOfficePage;

public class searchPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	MenuPage menupage;
	topBoxOfficePage topboxoffice;
	WatchListPage watchlistpage;
	SearchPage searchpage;

	public searchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		searchpage = new SearchPage();
		
		
	}
	@Test(priority=1)
	public void clickingSearchTest() {
		searchpage.clickingSearch();
	}
	
	@Test(priority=2)
	public void textSearchingTest() {
		searchpage.clickingSearch();
		searchpage.textSearching();
	}
	@Test(priority=3)
	public void comparingTitleDataTest() {
		searchpage.clickingSearch();
		searchpage.textSearching();
		searchpage.comparingTitleData("Queen");
	}
	@Test(priority=4)
	public void comparingKeywordsDataTest() {
		searchpage.clickingSearch();
		searchpage.textSearching();
		searchpage.comparingTitleData("Queen");
		searchpage.comparingKeywordsData("Queen");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		  
}
