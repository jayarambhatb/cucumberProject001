package pageObjects;


/*Create a class LoginPageObjects and initiate the instance of a variable to the driver.
Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. 
In Page Factory, testers use @FindBy annotation.
The initElements method is used to initialize web elements.
Annotations like FindBy and CacheLookup are used to find the element on a webpage.
@FindBy helps to specify the object location strategy for a web element.
@CacheLookup helps us know when to cache a web element and when not to, and declares the web element to be searched.*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declare driver object
	WebDriver driver;

	//Create Constructor and pass driver as parameter
	public LoginPage (WebDriver driver) 
	{
		this.driver=driver; //Initiate the driver

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='Email']")   // user email field
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='Password']") //user password field
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath="//button[normalize-space()='Log in']")  //Login button
	@CacheLookup
	WebElement btnLogin;


	@FindBy(linkText="Logout")//Locate Log Out link
	@CacheLookup
	WebElement lnkLogout;




	public void setusername(String useremail)
	{
		txtEmail.clear();
		txtEmail.sendKeys(useremail);
	}

	public void setPassword(String password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickbtnLogin()
	{
		btnLogin.click();
	}




	public void clickLogout()
	{
		lnkLogout.click();
	}



}
