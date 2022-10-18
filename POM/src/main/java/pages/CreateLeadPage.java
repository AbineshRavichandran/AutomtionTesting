package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import base.ProjectSpecificMethod;

public class CreateLeadPage extends ProjectSpecificMethod{
	
	
	
	public CreateLeadPage(ChromeDriver driver,Properties prop) {
		//this.driver=driver;
		this.prop=prop;
	}
	
	public CreateLeadPage enterCompanyName(String Company) {
		driver.findElement(By.id(prop.getProperty("CreateLeadPage.CompanyName.id"))).sendKeys(Company);
		return this;

	}
	
	public CreateLeadPage enterFirstName(String Fname) {
		driver.findElement(By.id(prop.getProperty("CreateLeadPage.FirstName.id"))).sendKeys(Fname);
		return this;

	}
	
	public CreateLeadPage enterLastName(String Lname) {
		driver.findElement(By.id(prop.getProperty("CreateLeadPage.LastName.id"))).sendKeys(Lname);
		return this;

	}
	public ViewLeadsPage clickCreateLeadButton() {
		driver.findElement(By.name(prop.getProperty("CreateLeadPage.CreateLeadButton.Name"))).click();
		
	return new ViewLeadsPage(driver,prop);

	}

}
