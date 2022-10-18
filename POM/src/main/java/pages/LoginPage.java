package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {

	public LoginPage(ChromeDriver driver) {

		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement eleUsername;

	public LoginPage enterUsername(String uName) throws IOException {
		try {
			eleUsername.sendKeys(uName);
			reportSteps("Username Entered Sucessfully", "pass");

		} catch (Exception e) {
			reportSteps("Enter Username failed", "fail");
		}
		return this;
	}

	@FindBy(how = How.ID, using = "password")
	WebElement elePassword;

	public LoginPage enterPassword(String pWord) throws IOException {
		try {
			elePassword.sendKeys(pWord);
			Thread.sleep(2000);
			reportSteps("Password Entered Sucessfully", "pass");
		} catch (Exception e) {
			reportSteps("Enter Password failed", "fail");
		}
		return this;
	}

	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportSteps("Login Button click sucessfully", "pass");
		} catch (NoSuchFieldError e) {
			reportSteps("Login Button click Unsucessfully", "fail");
		}
		return new HomePage(driver);
	}

}
