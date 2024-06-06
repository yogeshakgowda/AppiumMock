package commclass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class MockBaseclass 
{
	public AndroidDriver driver;
    static AndroidDriver sdriver;
    public GestureUtlis gutlis;
    public AndroidDriverUtils Adutlis;
    public FileUtility futlis=new FileUtility();
    public PomPage.flipkartjava flip;
    public AppiumDriverLocalService service;
    
    @BeforeSuite
    public void startServer()
    {
    	File f= new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
    }
    @BeforeClass
    public void startApp() throws IOException
    {
    	String platformname = futlis.readDataFromPropertyFile("Platform_Name");
    	String automationName = futlis.readDataFromPropertyFile("Automation_Name");
    	String UDID = futlis.readDataFromPropertyFile("UDID");
    	String noReset = futlis.readDataFromPropertyFile("No_Reset");
    	String ignoreHiddenApiPolicyError = futlis.readDataFromPropertyFile("Ignore_Hidden_ApiPolicyError");
    	String autoGrantPermission = futlis.readDataFromPropertyFile("AutoGrant_Permission");
    	
    	
    	DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName",platformname);
		dc.setCapability("automationName",automationName);
		dc.setCapability("UDID", UDID);
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("autoGrantPermission", autoGrantPermission);
		dc.setCapability("noReset", noReset);
		dc.setCapability("ignoreHiddenApiPolicyError", ignoreHiddenApiPolicyError);
		
         URL u=new URL("http://localhost:4723");
		
		driver=new AndroidDriver(u,dc);
		
		sdriver=driver;
		
		 gutlis=new GestureUtlis(driver);
		 Adutlis=new AndroidDriverUtils(driver);
		 flip=new PomPage.flipkartjava(driver);
		   
    }
    
    @AfterClass
    public void closeApp()
    {
    	
    	driver.quit();
    	
    }
    
	
    @AfterSuite
    public void closeServer()
    {
    	service.stop();
    }
   
}
