package pages;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod {
	
	
	public MyHomePage(ChromeDriver driver) {
		//this.driver=driver;
	
	}

	public LeadsPage clickLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Leads")).click();
			reportSteps("Logout Button click sucessfully", "pass");
		} catch (Exception e) {
			reportSteps("Logout Button click Unsucessfully", "fail");
		}
		return new LeadsPage(driver);

	}

}
