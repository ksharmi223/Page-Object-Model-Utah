package com.utah.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utah.qa.base.TestBase;
import com.utah.qa.pages.HomePage;
import com.utah.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();//it will call supper class contractor
	}
	
	@BeforeMethod
		public void setup() {
		initialization();
	
		loginPage=new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Utah ID");
	}
	
	@Test(priority=2)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=3)
	public void prismSelect() {
		loginPage.PrismSelect(prop.getProperty("utah"));
		
	}
	@Test(priority=4)
	
	public void PrismProfile(){
		
		loginPage.select_options("Provider Enrollment Supervisor");
		
	}		
		
	
	@AfterMethod
	public void CloseBrowser() {
	driver.quit();
	}
	}

