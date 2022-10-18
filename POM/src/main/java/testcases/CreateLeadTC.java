package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class CreateLeadTC extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setFileName() {

		excelFileName ="CreateLead";
		testName="CreateLead";
		testCategory="Smoke";
		testAuthor="Abinesh";
	}
	
	@Test(dataProvider = "sendData")
	public void runCreateLead(String uname,String pword,String Company,String FName,String LName) throws IOException {
		new LoginPage(driver)
		.enterUsername(uname)
		.enterPassword(pword)
		.clickLoginButton()
		.clickCRMSFALink()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(Company)
		.enterFirstName(FName)
		.enterLastName(LName)
		.clickCreateLeadButton();

	}
}
