package com.utah.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utah.qa.base.TestBase;
import com.utah.qa.pages.BasicInfoPage;
import com.utah.qa.pages.EnrollmentTypePage;
import com.utah.qa.pages.HomePage;
import com.utah.qa.pages.LoginPage;

public class EnrollmentTypePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	EnrollmentTypePage enrollmentTypePage;
	BasicInfoPage basicInfoPage;
	
	public EnrollmentTypePageTest() {
		super();
	}

	@BeforeMethod
	public void EnrollmentType() {
		
		initialization();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		loginPage.PrismSelect(prop.getProperty("utah"));
		loginPage.select_options("Provider Enrollment Supervisor");
	    homePage=new HomePage();
	    homePage.ClickOnProvider();
	    homePage.ClickOnEnrollment();
	    enrollmentTypePage=new EnrollmentTypePage();
	    basicInfoPage=new BasicInfoPage();
}

	@Test(priority=1)
	
	public void SeleIndividual() {
		enrollmentTypePage.SelectIndividual();
		
	}
	@Test(priority=2)
	public BasicInfoPage Submit() {
		enrollmentTypePage.SubmitBtn();
		
		return new BasicInfoPage();
	}
	//@AfterMethod
	//public void CloseBrowser() {
	//driver.quit();
	//}
	}
	
		
	
