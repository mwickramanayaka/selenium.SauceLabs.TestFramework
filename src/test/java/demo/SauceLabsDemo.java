package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDemo { 

	public static final String USERNAME = "mwickramanayaka";
	public static final String ACCESS_KEY = "5e1b913d-54cc-40b1-a36e-d6768052bbb6";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	static String expectedTitleebay ="Electronics, Cars, Fashion, Collectibles & More | eBay";

	public static void main(String[] args) throws MalformedURLException {

		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "ebaySearchTest1");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("capturePerformance", "true");
		caps.setCapability("buildNumber", "3.0");
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.manage().window().maximize();
		driver.get("https://www.ebay.com");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitleebay);
		System.out.println("Title is correct");

		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mobile");

		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).sendKeys(Keys.RETURN);


		driver.quit();
		System.out.println("Test is completed");

	}







}