package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin extends BasePage{

	//Creation of constructor to call initiate driver
	public AdminLogin (WebDriver driver)
	{
		super(driver);
	}
	
	
	
//Locate elements
	@FindBy (xpath= "//input[@placeholder='enter your user ID']")
	WebElement txtUsername;
	
	@FindBy (xpath="//input[@placeholder='enter your password']")
	WebElement txtPassword;
	
	@FindBy (xpath="//re-captcha[@id='ngrecaptcha-0'][1]")
	WebElement chkRobot;
	
	@FindBy (xpath="//button[@class='ant-btn login-form-button login-form-margin w-100 my-2 ant-btn-primary']")
	WebElement ButtonSignIn;
	
	
//Action methods
	
	public void EnterUsername(String Username)
	{
		txtUsername.sendKeys(Username);
	}
	
	
	public void EnterPass(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	
	public void CheckboxRobot()
	{
		chkRobot.click();
	}
	
	public void clickSignIn()
	{
		ButtonSignIn.click();
		 String OriginalWindow;
		 OriginalWindow=driver.getWindowHandle();
		 System.out.println("The window id is: "+OriginalWindow);
		 
	}
	
	
	
	
	
	
	
	
	
	
}
