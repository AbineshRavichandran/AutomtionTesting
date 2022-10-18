package pages;



import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {
	
	
	public HomePage(ChromeDriver driver) {
		//this.driver=driver;
		
	}


	public LoginPage clickLogoutButton() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportSteps("Logout Button click sucessfully", "pass");
		} catch (Exception e) {
			reportSteps("Logout Button click Unsucessfully", "fail");
		}
		return new LoginPage(driver);
	}
	
	
	public MyHomePage clickCRMSFALink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);

	}

}
