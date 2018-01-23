package com.utah.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utah.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory-OR:
	@FindBy(xpath="//*[@id='idToken1']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='idToken2']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginButton_0']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='rfld_a:DomainNme']")
	WebElement prism_select;
	
	@FindBy(xpath="//input[@id='GoButton']")
	WebElement click_go_btn;
	
	@FindBy(xpath = "//select[@name='rcmb_a:dbZzPROFILE_PRFL_SID']") 
	WebElement select_profile;
	
	@FindBy(xpath="//input[@id='GoButton']")
	WebElement go_btn;
	
	//initializing the POM
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	public void PrismSelect(String utah) {
		prism_select.click();
		prism_select.sendKeys(utah);
		click_go_btn.click();
		
		
}
	
	public HomePage select_options(String option) {
		
		Select select=new Select(select_profile);
		select.selectByVisibleText(option);
		go_btn.click();
		
		return new HomePage();
		
		
	}
}