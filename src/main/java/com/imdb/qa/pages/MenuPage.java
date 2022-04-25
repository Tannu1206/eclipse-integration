
package com.imdb.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class MenuPage extends TestBase {
	
	@FindBy(xpath= "//label[@aria-label='Expand Movies Nav Links']/following-sibling::div/div[1]/ul[1]/a[not(contains(@class,'hideL'))]")
	public List<WebElement> Movies;
	
	public MenuPage() {
    	PageFactory.initElements(driver, this);
    }
	
	public void MenuSelect(String abc ) {
		TestUtil.selectElementFromList(Movies, abc);		
			}
		
	public boolean MenuCount() {
	 return TestUtil.elementsCountShouldBe(Movies, 11);
	 
	 
	}
	}


