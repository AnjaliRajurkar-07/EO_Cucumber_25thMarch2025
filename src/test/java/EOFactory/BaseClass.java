package EOFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	public static WebDriver initilizeBrowser() throws IOException
	{
		//to disable chrome being controlled by automated test software
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	//	options.setExperimentalOption("useAutomationExtension", false);
		
		p= getProperties();
        String executionEnv =p.getProperty("execution_env");
		String browser=p.getProperty("browser");
		String os=p.getProperty("os");
		
		if( executionEnv.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//OS
			switch (os)
			{
			case "windows": capabilities.setPlatform(Platform.WINDOWS); break;
			case "mac" : capabilities.setPlatform(Platform.MAC); break;
			case "linux": capabilities.setPlatform(Platform.LINUX); break;
			default: System.out.println("No matching OS");
            return null;
			}
			
			//Browser
			switch (browser)
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser");
			return null;
			}
			
			 driver = new RemoteWebDriver(new URL("http://192.168.5.223:4444/wd/hub"),capabilities);
		/*	if (browser.equalsIgnoreCase("chrome")) {
			    ChromeOptions options = new ChromeOptions();
			    driver = new RemoteWebDriver(new URL("http://192.168.5.223:4444/wd/hub"), options);
			} else if (browser.equalsIgnoreCase("firefox")) {
			    FirefoxOptions options = new FirefoxOptions();
			    driver = new RemoteWebDriver(new URL("http://192.168.5.223:4444/wd/hub"), options);
			}		
			*/
		}
     
		
		else if (executionEnv.equalsIgnoreCase("local"))
		{
			switch (browser.toLowerCase())
			{
			case "chrome": driver= new ChromeDriver(options); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("No matching browser");
			driver= null;
			}
			
		}
		//line 29-76 to decide remote run or local run
			
		
		 //driver= new ChromeDriver(options);// new added instead of line 29 to 76
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
		
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
	

    public static Properties getProperties() throws IOException 
     {
	  FileReader file=new FileReader(System.getProperty("user.dir")+"\\src/test/resources/config.properties");
	  p=new Properties(); 
	  p.load(file);
	  return p;  
	}
	
	public static Logger getLogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	
	
	
}


/*Git

1) Create repo - in github 
2) Clone repo - git clone {repo URL}
3) Create branch- git checkout -b main
4) git add -A 
5) git commit -m "21/01/2024"
6) git push


*/













