package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	@After
	public void afterHook() throws IOException
	{
		testContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void attachFailedScreen(Scenario scenario) throws IOException //scenario holds every information about our scenario
	{
		WebDriver driver = testContextSetup.testBase.webDriverManager();
		if(scenario.isFailed())
		{
			File filePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// scenario.attach method will take only byte format file so we are converting into byte format
			byte[] file = FileUtils.readFileToByteArray(filePath); 
			scenario.attach(file, "image/png", "imageName");
		}
	}
}
