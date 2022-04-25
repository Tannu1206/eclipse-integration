package com.imdb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(id = "home_img_holder")
	WebElement Logo;
	@FindBy(xpath = "//label[@id ='imdbHeader-navDrawerOpen--desktop']")
	WebElement Menubtn;
	@FindBy(xpath= "//div[@id='suggestion-search-container']")
	WebElement Searchbar;
	@FindBy(xpath="//a[@class='ipc-button ipc-button--single-padding ipc-button--default-height ipc-button--core-baseAlt ipc-button--theme-baseAlt ipc-button--on-textPrimary ipc-text-button']")
	WebElement Watchlist;
	@FindBy(xpath="//div[@class='ipc-button__text']//span[contains(text(),'Tannu')]")
	WebElement UserSignedIn;
	
	public HomePage() {
    	PageFactory.initElements(driver, this);
    }
	
	public boolean logoimage() {
		TestUtil.waitForElementToBeVisible(Logo);
		return Logo.isDisplayed();
	}
	
	public boolean menubutton() {
		TestUtil.waitForElementToBeVisible(Menubtn);
		return Menubtn.isDisplayed();
	}
	public boolean searchBar() {
		TestUtil.waitForElementToBeVisible(Searchbar);
		return Searchbar.isDisplayed();
	}
	public boolean WatchlistIcon() {
		TestUtil.waitForElementToBeVisible(Watchlist);
		return Watchlist.isDisplayed();
	}
	public boolean userName() {
		TestUtil.waitForElementToBeVisible(UserSignedIn);
		return UserSignedIn.isDisplayed();
	}
	
	public MenuPage clickOnMenu() {
		TestUtil.waitForElementToBeVisible(Menubtn);
		Menubtn.click();
		return new MenuPage();
	}
	
	public WatchListPage clickOnWatchList() {
		Searchbar.click();
		return new WatchListPage();
	}
	
	
	
	
	
}
