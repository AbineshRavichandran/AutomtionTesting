package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecificMethod {

	public static ChromeDriver driver;
	public String excelFileName;
	public Properties prop;
	public static ExtentReports extent;
	public String testName,testCategory,testAuthor;
	public static ExtentTest test, node ;

	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./report/result.html");

		reporter.setAppendExisting(true);

		extent = new ExtentReports();

		extent.attachReporter(reporter);

	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	}
	
	public int takeSnap() throws IOException {
		
		int ranNum= (int)(Math.random()*99999);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File target= new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(screenshotAs, target);
		
		return ranNum;
		

	}
	
	public void reportSteps(String stepName,String status) throws IOException {
		
		if (status.equalsIgnoreCase("pass")) {
			//node.pass(stepName);
			node.pass(stepName, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
		else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepName,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
					

	}

	@DataProvider
	public String[][] sendData() throws IOException {

		ReadExcel readEx = new ReadExcel();

		String[][] excelData = readEx.ExcelData(excelFileName);

		return excelData;

	}

	@BeforeMethod
	public void preCondition() throws IOException {
		
		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void postCondition() {
		driver.close();

	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();

	}

}
