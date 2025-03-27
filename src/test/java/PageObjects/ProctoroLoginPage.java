package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ProctoroLoginPage extends BasePage {

	//creating constructor to initiate driver
	public  ProctoroLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locating Element
	@FindBy (xpath="//input[@placeholder='enter your user ID']")
	WebElement PUserID;
	
	@FindBy (xpath="//input[@placeholder='enter your password']")
	WebElement Ppassword;
	
	@FindBy (xpath="//ldiv[@id='rc-anchor-center-container']")
	WebElement Pcheckbox;
	
	@FindBy (xpath="//span[normalize-space()='Sign me In']")
	WebElement PSignIn;
	
	
	//Creating Action methods
	
	public void PEnterUserID(String UserID)
	{
		PUserID.sendKeys(UserID);
	}
	
	
	public void PEnterPwd(String Pwd)
	{
		PUserID.sendKeys(Pwd);
	}
	
	public void Pchkbox()
	{
		Pcheckbox.click();
	}	
	
	public void ProctorSignIn()
	{
		PSignIn.click();
	}	
	
}
