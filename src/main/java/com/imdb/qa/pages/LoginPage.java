package com.imdb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdb.qa.base.TestBase;
import com.imdb.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'Sign In')]")
	WebElement SignIn;
    @FindBy(xpath = "//a[contains(text(),'Create a New Account')]")
    WebElement Createnewaccounttext;  
    @FindBy(className = "a-link-emphasis")
    WebElement SignIn_btn;
    @FindBy(xpath= "//input[@name='email']")
    WebElement Email;
    @FindBy(name= "password")
    WebElement password;
    @FindBy(id= "signInSubmit")
    WebElement submit;
    
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
	
    public String validateLoginPageTitle(){
		return driver.getTitle();
	}
    
    
    public void SignIn() {
    	TestUtil.waitForElementToBeVisible(SignIn);
    	SignIn.click();
    }
    
    public void CreateNewAccount() {
    	TestUtil.waitForElementToBeVisible(Createnewaccounttext);
    	
    	Createnewaccounttext.click();
    }
     public void Signinbutton() {
    	 TestUtil.waitForElementToBeVisible(SignIn_btn);
    	 SignIn_btn.click();
     }
    
    public HomePage login(String em, String pwd){
    	TestUtil.waitForElementToBeVisible(Email);
    	TestUtil.waitForElementToBeVisible(password);
    	Email.sendKeys(em);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
    }
}
