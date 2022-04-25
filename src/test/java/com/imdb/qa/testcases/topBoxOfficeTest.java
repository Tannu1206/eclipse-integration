package com.imdb.qa.testcases;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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



public class topBoxOfficeTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	MenuPage menupage;
	topBoxOfficePage topboxoffice;
	WatchListPage watchlistpage;

	public topBoxOfficeTest() {
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
		  menupage.MenuSelect("Top Box Office"); 
		  topboxoffice = new topBoxOfficePage();
	}
	
	@Test
	public void textHeaderTest() {
		boolean flag = topboxoffice.textheader();
		Assert.assertTrue(flag);
	}
		
	@Test
	public void subTextHeaderTest() {
			boolean flag1 = topboxoffice.subTextHeader();
			Assert.assertTrue(flag1);
	}
	
	@Test(priority=2)
	public void tableHeadingMatchTest() {
		topboxoffice.tableHeadingsMatch();
	}
	
	@Test(priority=1)
	public void gettingTableDataTest() {
		topboxoffice.gettingTableData();
	}
	
   @Test(priority=3)
   public void gettingMovieTitleTest() {
	   String actualTitle= topboxoffice.gettingMovieTitle();
	   System.out.println(actualTitle);
   }
   
   @Test(priority=3)
   public void clickOnMovitopboxofficeeWatchlistTest() {
	   topboxoffice.clickOnMovieWatchlist();
	   
   }
   @Test (priority=4)
   public void watchlistButtonTest() {
	   watchlistpage =topboxoffice.watchlistButton();
   }
   
   

		@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
		
		
		
		
	  
	}
	

