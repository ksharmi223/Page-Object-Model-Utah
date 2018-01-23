package com.utah.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utah.qa.base.TestBase;

public class BasicInfoPage extends TestBase {
	
	@FindBy(id="rrb:BSNS_ENTITY_TYPE_LKPCD1")
	WebElement SSN;
	
	
	@FindBy(xpath="//input[@id='nfld_h:dbZzSA_PROVIDER-FIRST_NAME']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='nfld_h:dbZzSA_PROVIDER-LAST_NAME']")
	WebElement LastName;
	
	@FindBy(xpath="//select[@id='ncmb_a:dbZzSA_PROVIDER-GENDER_LKPCD']")
	WebElement Gender;
	
	
	//@FindBy(xpath="//input[@id='nfld_n:dbZzSA_PROVIDER-TAX_IDNTFCTN_NMBRSSN']")
	//WebElement SSNumber;
	
	@FindBy(xpath="//*[@id='datePicker_n_d_dbZzSA_PROVIDER_BIRTH_DATE']/span/i")
	WebElement DateOfBirth;
	
	
	@FindBy(xpath="//input[@id='nfld_n:dbZzSA_PROVIDER-NATIONAL_PRVDR_IDNTFR']")
	WebElement NPI;
	
	@FindBy(xpath="//select[@id='rcmb_a:dbZzSA_PROVIDER-ORG_BSNS_TYPE_LKPCD']")
	WebElement ProfitStatus;
	
	@FindBy (xpath="//select[@id='rcmb_a:dbZzSA_PROVIDER-ORG_BSNS_TYPE_LKPCD']")
	WebElement Email;
	
	@FindBy (xpath="//select[@id='ncmb_a:dbZzSA_PROVIDER-SRVCNG_TYPE_LKPCD']")
	WebElement ServicingType;
	
	@FindBy (xpath="//*[@id=\"datePicker_r_d_dbZzSA_APPLICATION_EFFECTIVE_DATE\"]/span/i")
	WebElement EffDate;
	
	@FindBy(id="ContentsAreaX")
	WebElement MCNP;
	
	@FindBy(xpath="//input[@id='ValidateButton']")
	WebElement ValidateNPI;
	
	
	@FindBy(xpath="//input[@id='FinishButton']")
	WebElement finish;
	
	
	
		public void ClickSSN() {
			SSN.click();
			
		}
		
		public void NameInfo(String ftname,String ltname) {

			FirstName.sendKeys(ftname);
			LastName.sendKeys(ltname);
			
		}
		
		public void selectGender (String gender) {
			Select select=new Select(Gender);
			select.selectByVisibleText(gender);	
			}
		
		public void SSnumber(String number) {
			
			driver.findElement(By.xpath("//input[@id='nfld_n:dbZzSA_PROVIDER-TAX_IDNTFCTN_NMBRSSN']")).sendKeys(number);
			
		}
		public void DateofB() {
			
			DateOfBirth.click();
			DateOfBirth.findElement(By.cssSelector("body > div:nth-child(35) > div.datepicker-days > table > tbody > tr:nth-child(2) > td:nth-child(2)")).click();
		}
		
		public void NPINumber(String npi) {
			NPI.sendKeys(npi);
			
		}
		
		public void SelectStatusType(String status, String Type) {
			Select select=new Select(ProfitStatus);
			select.deselectByVisibleText(status);
		
			
			Select select1=new Select(ServicingType);
			select1.deselectByVisibleText(Type);
		
			}
		
		
		public void EmailAddress(String mail) {
			Email.sendKeys("email");
		}
		
		public void EffectiveDate() {
			
			EffDate.click();
			EffDate.findElement(By.cssSelector("body > div:nth-child(36) > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(1)")).click();
			
			
		}

		public void ManagedCareNewwork() {
			MCNP.click();
		}
		public void ValidationNPI() {
			ValidateNPI.click();
		}

		public LandingPage Finish() {
			finish.click();
			
			
			return new LandingPage();
		}
}






