package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setDetails() {
		excelFileName ="LoginData";
		testName="LoginAndLogOut";
		testCategory="Smoke";
		testAuthor="Abinesh";
	}
	
	@Test(dataProvider = "sendData")
	public void runLoginAndLogout(String uName,String pWord) throws IOException, InterruptedException {
		
		
		new LoginPage(driver)
		.enterUsername(uName)
		.enterPassword(pWord)
		.clickLoginButton();
		//.clickLogoutButton();
		
		
		

	}
}
