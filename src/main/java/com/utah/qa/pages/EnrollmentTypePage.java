package com.utah.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utah.qa.base.TestBase;

public class EnrollmentTypePage extends TestBase {
	
	@FindBy(xpath = "//*[@id='nrb:ENRLMNT_TYPE_CID0']") 
	private WebElement individual;

	@FindBy(xpath ="//input[@id='SubmitButton']") 
	private WebElement submit;
	
	
	//initializing the POM
		public EnrollmentTypePage() {
			PageFactory.initElements(driver, this);	

}
		
		//Action
		
		public void SelectIndividual() {
			individual.click();
		}
		public void SubmitBtn() {
			submit.click();
		}

		
}

