package com.imdb.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class topBoxOfficePage extends TestBase{
	
	@FindBy(xpath = "//h1[@class='header']")
	WebElement headertext;
	
	@FindBy(xpath="//h4[contains(text(),'Weekend of March 5 - 7, 2021')]")
	WebElement subheader;
	
	@FindBy(xpath="//table[@class='chart full-width']/thead/tr/th")
	public List<WebElement> tableheadings;
	
	@FindBy(xpath="//table[@class ='chart full-width']/tbody/tr[1]/td[6]")
	WebElement watchlist;
	
	@FindBy(xpath="//table[@class= 'chart full-width']/tbody/tr[1]/td[2]/a")
	WebElement title;
	
	@FindBy(xpath="//div[@class='NavWatchlistButton-sc-1b65w5j-0 kaVyhF imdb-header__watchlist-button']/a/div")
	WebElement watchlistbutton;
	
	
	
	
	public topBoxOfficePage() {
    	PageFactory.initElements(driver, this);
    }
	
	public boolean textheader() {
		TestUtil.waitForElementToBeVisible(headertext);
		return headertext.isDisplayed();
	}
	public boolean subTextHeader() {
		TestUtil.waitForElementToBeVisible(subheader);
		return subheader.isDisplayed();
	}
	public void tableHeadingsMatch() {
		TestUtil.elementCountOfTable1(tableheadings);
		
		
		 }
	public void gettingTableData() {
		List<WebElement> rowelements =driver.findElements(By.xpath("//*[@id=\"boxoffice\"]/table/tbody/tr"));
		System.out.println(rowelements.size());
		int rowsize= rowelements.size();
		
		List<WebElement> colelements =driver.findElements(By.xpath("//*[@id=\"boxoffice\"]/table/tbody/tr[1]/td"));
		System.out.println(colelements.size());
		int colsize= colelements.size();
		
		for(int i=1; i<=rowsize;i++) {
			for(int j=1;j<=colsize;j++) {
				System.out.println(driver.findElement(By.xpath("//*[@id=\"boxoffice\"]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText()+ " ");
				//*[@id="boxoffice"]/table/tbody/tr[1]/td[6]/div/di
			}
			System.out.println();
		}
		}
	
		public String gettingMovieTitle() {
			TestUtil.waitForElementToBeVisible(title);
			System.out.println( title.getText());
			return title.getText();
		}
		
		public void clickOnMovieWatchlist() {
			TestUtil.waitForElementToBeVisible(watchlist);
			watchlist.click();
		}
		
		public WatchListPage watchlistButton() {
			TestUtil.waitForElementToBeVisible(watchlistbutton);
			
			watchlistbutton.click();
			return new WatchListPage();
		}
			
}
			
			
		
		
	

	



