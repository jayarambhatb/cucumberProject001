package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.LoginPage;


public class Steps {

	public WebDriver driver;  // declare Webdriver 
	//Create LoginPage object so that we can access LoginPage methods
	public LoginPage lp;



	@Given("^User Launch Chrome browser$")
	public void user_launch_chrome_browser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");

		//Initiate driver
		driver=new ChromeDriver();
		//Instantiate LoginPage object and pass the driver as parameter
		lp= new LoginPage(driver);

	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("^User enters Email as \" (.*)\" and Password as \"(.*)\" $")
	public void user_enters_email_as_and_password_as(String Email, String Password) {
		lp.setusername(Email);
		lp.setPassword(Password);
	}

	@When("^Click on Login $")
	public void click_on_login() {
		lp.clickbtnLogin();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")){
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("^User Click on Logout link $")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^close the browser $")
	public void close_the_browser() {
		driver.quit();
	}
}
