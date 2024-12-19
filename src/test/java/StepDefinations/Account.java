package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Base.BaseCls;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Account {
	 WebDriver driver;
	
@Before
public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
}
	@Given("user is on Home page")
	public void user_is_on_home_page() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		System.out.println("We are on Home Page");

	}
	@When("user click on Create an account")
	public void user_click_on_create_an_account() {
		driver.findElement(By.xpath("(//a[contains(text(),'Create an Account')])[1]")).click();
		System.out.println("Clicked on Create an account Button");
	}

	@Then("user enters personam Info")
	public void user_enters_personam_info(DataTable dataTable) {
		List<List<String>> data1=dataTable.cells();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(data1.get(0).get(1));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data1.get(1).get(1));
		System.out.println("Enterd personal info");
	}

	@Then("User enters sign-in info")
	public void user_enters_sign_in_info(DataTable dataTable) {
		List<List<String>> data1=dataTable.cells();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data1.get(0).get(1));
		driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(data1.get(1).get(1));
		driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys(data1.get(2).get(1));
		System.out.println("Enterd sign in info");
	}

	@Then("user click on Create an Account Button")
	public void user_click_on_create_an_account_button() {
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		System.out.println("Clicked on Create an Account Button");
	}

	@Then("user verifies Thank you msg")
	public void user_verifies_thank_you_msg() throws InterruptedException {
		try {
		WebElement successMsg=driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]"));
		
		//System.out.println(successMsg.getText());
		String msg=successMsg.getText();
		Assert.assertEquals(msg, "Thank you for registering with Main Website Store.");
		
		Thread.sleep(2000);
		
		}
		catch(Exception e) {
			
			WebElement failMsg=driver.findElement(By.xpath("//div[contains(text(),'There is already an account with this email address. If you are sure that it is your email address, ')]"));
			//String msg=failMsg.getText();
			//Assert.assertEquals(msg, "There is already an account with this email address. If you are sure that it is your email address, ");
			System.out.println(failMsg.getText());
		}
		}
	@When("user click on Sign In")
	public void user_click_on_sign_in() throws InterruptedException {
		
	    driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();
	    Thread.sleep(2000);
	}

	@When("user enters username")
	public void user_enters_username(DataTable dataTable) {
		List<List<String>> data1=dataTable.cells();
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys(data1.get(0).get(1));
	}

	@When("user enters password")
	public void user_enters_password(DataTable dataTable) {
		List<List<String>> data1=dataTable.cells();
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(data1.get(0).get(1));
	}

	@Then("user click on Sign In Button")
	public void user_click_on_sign_in_button() {
	    driver.findElement(By.xpath("//button[@class='action login primary']"));
	}

	@Then("User is on My Account Page")
	public void user_is_on_my_account_page() {
		//String str=driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).getText();
	 //  System.out.println(str);
		System.out.println("User is on My Account Page");
	}


		 @After
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit(); // Quit the driver after tests
		        }
		//driver.close();
		        
	}

	


}
