package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class LeadsPage extends ProjectSpecificMethod {
	
	public LeadsPage(ChromeDriver driver) {
		
		//this.driver=driver;
		
		
	}
	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.linkText(prop.getProperty("LeadsPage.CreateLead.linkText"))).click();
		return new CreateLeadPage(driver,prop);

	}

}
