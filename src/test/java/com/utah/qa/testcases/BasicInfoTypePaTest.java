package com.utah.qa.testcases;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utah.qa.base.TestBase;
import com.utah.qa.pages.BasicInfoPage;
import com.utah.qa.pages.EnrollmentTypePage;
import com.utah.qa.pages.HomePage;
import com.utah.qa.pages.LoginPage;
import com.utah.qa.util.TestUtil;

public class BasicInfoTypePaTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	EnrollmentTypePage enrollmentTypePage;
	BasicInfoPage basicInfoPage;
	TestUtil testUtil;
	
	String sheetName="Basic Info";
	
	public BasicInfoTypePaTest() {
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
	    enrollmentTypePage.SelectIndividual();
	    enrollmentTypePage.SubmitBtn();
	    basicInfoPage=new BasicInfoPage();
	    testUtil=new TestUtil();
}

	@Test(priority=1)
	
	public void SelectSSN(){
		driver.switchTo().window("childWindow");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		basicInfoPage.ClickSSN();
	}
	

	@DataProvider
	public Object[][] getTestData() {
	
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getTestData")
		public void InfoName(String FirstName, String LastName, String Gender, String SSN, String NPI,String ProfitStatus, String EmailAddress, String ServicingType) {
		basicInfoPage.NameInfo(FirstName, LastName);
		basicInfoPage.selectGender(Gender);
		basicInfoPage.SSnumber(SSN);
		basicInfoPage.DateofB();
		basicInfoPage.NPINumber(NPI);
		basicInfoPage.SelectStatusType(ProfitStatus, ServicingType);
		basicInfoPage.EmailAddress(EmailAddress);
	
	}
	 
	

	//@AfterMethod
	//public void CloseBrowser() {
	//driver.quit();
	//}
	}


