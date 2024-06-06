package flipkart;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.Test;

import commclass.MockBaseclass;

public class MainMockTest extends MockBaseclass
{
	@Test
	public void script() throws MalformedURLException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		flip.searchiphone("iphone 15");
		flip.getClickonproduct().click();
		Thread.sleep(3000);
		flip.getAddtocart().click();
		Thread.sleep(3000);
		flip.getGotocart().click();
		Thread.sleep(3000);
	}
}
