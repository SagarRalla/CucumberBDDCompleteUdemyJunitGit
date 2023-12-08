package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String url = properties.getProperty("url");
		
		if(driver == null)
		{
			if(properties.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(properties.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				//firefox code
			}
			driver.manage().window().maximize();
			driver.get(url);
		}
		return driver;
	}
}
