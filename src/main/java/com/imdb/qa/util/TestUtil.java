package com.imdb.qa.util;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imdb.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Implicit_Wait = 20;

	public static void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static boolean selectElementFromList(List<WebElement> element, String abc) {
		for (WebElement element1 : element) {
			if (element1.getText().equalsIgnoreCase(abc)) {
				element1.click();
				return true;
			}
		}
		return false;
	}

	public static boolean elementsCountShouldBe(List<WebElement> links, int expectedCount) {
		if (expectedCount == links.size()) {
			return true;
		}
		return false;
	}
	
	public static void elementCountOfTable(List<WebElement> links) {
		//int rowCount = links.size();
		System.out.println("Total rows in web table :" + "rowCount");
	}
	
	public static void elementCountOfTable1(List<WebElement> links) {
		for(WebElement list:links) {
			String ab = list.getText();
			System.out.println(ab);
		}
	}
}
