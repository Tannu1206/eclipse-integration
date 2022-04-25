package com.imdb.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class SearchPage extends TestBase {
	
	@FindBy(xpath= "//input[@placeholder ='Search IMDb']")
	WebElement Searchbar;
	
	@FindBy(xpath="(//div[@class ='findSection'][2])/table/tbody/tr")
	public List<WebElement> Titles;
	
	@FindBy(xpath="(//div[@class ='findSection'][3])/table/tbody/tr")
	public List<WebElement> Keywords;
	
	public SearchPage() {
    	PageFactory.initElements(driver, this);
    }
	
	public void clickingSearch() {
		TestUtil.waitForElementToBeVisible(Searchbar);
		Searchbar.click();
}
	public void textSearching() {
		Searchbar.sendKeys("Queen", Keys.ENTER);
	}
	public boolean comparingTitleData(String text) {
		List<WebElement> elements = Titles;
		 return elements.stream().anyMatch(e->e.getText().trim().equals(text));
	}
	public boolean comparingKeywordsData(String text) {
		List<WebElement> elements = Keywords;
		 return elements.stream().anyMatch(e->e.getText().trim().equals(text));
	}
}
