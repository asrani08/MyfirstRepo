package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCls {
	 protected WebDriver driver;

	    @Before
	    public void setUp() {
	        // Initialize the WebDriver
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(); // You can use any other WebDriver (e.g., FirefoxDriver)
	    }

	    // Optionally add @After to quit the driver after tests are done
	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
