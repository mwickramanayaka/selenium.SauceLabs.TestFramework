package demo;

import com.applitools.eyes.selenium.Eyes;

import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplitoolsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Eyes eyes = new Eyes();
        eyes.setApiKey("08nSczt5xjdatorJo99100wefkbEP1X4hlkELvvBES0jZE110");
      

        try{

            // Start the test and set the browser's viewport size to 800x600.
            eyes.open(driver, "Hello World!", "My first Selenium Java test!",
                    new RectangleSize(800, 600));

            // Navigate the browser to the "hello world!" web-site.
            driver.get("https://applitools.com/helloworld/?diff1");

            // Visual checkpoint #1.
            eyes.checkWindow("Hello!");

            // Click the "Click me!" button.
            driver.findElement(By.tagName("button")).click();

            // Visual checkpoint #2.
            eyes.checkWindow("Click!");

            // End the test.
            eyes.close();

        } finally {

            // Close the browser.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();
        }

        
	}

}
