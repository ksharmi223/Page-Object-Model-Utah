package com.utah.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utah.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//*[@id='top-menu']/li[3]/a") 
	WebElement provider;
	
	//@FindBy(css = "#top-menu > li.tabsoffline.dropdown.open > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(7) > a:nth-child(1)") 
	//WebElement newEnrollment;

	@FindBy(xpath = "//*[@id='top-menu']/li[3]/div/table/tbody/tr/td[1]/ul/li[7]/a[1]") 
	WebElement newEnrollment;

    //initializing the POM
	public HomePage() {
		PageFactory.initElements(driver, this);	
			
	}
	//Action
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void ClickOnProvider() {
		provider.click();
		
	}
	
	public EnrollmentTypePage ClickOnEnrollment(){
		
		newEnrollment.click();
		return new EnrollmentTypePage();
	}

	
	}
