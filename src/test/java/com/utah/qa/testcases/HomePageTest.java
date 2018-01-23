package com.utah.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utah.qa.base.TestBase;
import com.utah.qa.pages.BasicInfoPage;
import com.utah.qa.pages.EnrollmentTypePage;
import com.utah.qa.pages.HomePage;
import com.utah.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	EnrollmentTypePage enrollmentTypePage;


	public HomePageTest() {
	super();
	}
	
	@BeforeMethod
	public void MainPage() {
		
		initialization();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		loginPage.PrismSelect(prop.getProperty("utah"));
		loginPage.select_options("Provider Enrollment Supervisor");
	    homePage=new HomePage();
	    enrollmentTypePage=new EnrollmentTypePage();

}

	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String homePageTitle=homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Welcome to PRISM", "Home Page Title not Matched");
	}	
		
	@Test(priority=2)
	public void ClickOnProviderTest() {
		homePage.ClickOnProvider();
	}

	@Test(priority=3)
	
	public EnrollmentTypePage ClickOnEnrollment() {
		homePage.ClickOnEnrollment();
	
	
		
		return new EnrollmentTypePage();
	}
	
	
	@AfterMethod
	public void CloseBrowser() {
	driver.quit();
	}
}
