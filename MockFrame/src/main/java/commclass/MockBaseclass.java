package commclass;

import java.io.IOException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;


public class MockBaseclass 
{
	public AndroidDriver driver;
    static AndroidDriver sdriver;
    public GestureUtlis gutlis;
    public AndroidDriverUtils Adutlis;
    public FileUtility futlis=new FileUtility();
    public PomPage.flipkartjava flip;
 
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
   
}
