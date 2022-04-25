package com.imdb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class WatchListPage extends TestBase {
	
	@FindBy(xpath="//div[@class='lister-item-content']/h3/a")
	WebElement watchlistpagetitle;
	
	@FindBy(xpath="//table[@class ='chart full-width']/tbody/tr[1]/td[6]")
	WebElement watchlist;
	
	
	
	public WatchListPage() {
    	PageFactory.initElements(driver, this);
    }
	
	public String watchListpageMovieTitle() {
		TestUtil.waitForElementToBeVisible(watchlistpagetitle);
		System.out.println(watchlistpagetitle.getText());
	return watchlistpagetitle.getText();
	
	}
	
	public void navigatingTopBoxOfficePage() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().back();
		TestUtil.waitForElementToBeVisible(watchlist);
		watchlist.click();
	}
	
	
		
}
