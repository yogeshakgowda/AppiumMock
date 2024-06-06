package flipkart;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commclass.MockBaseclass;



public class MockFlipkartTest extends MockBaseclass
{
	@Test
	public void script() throws MalformedURLException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		flip.searchiphone("iphone 15");
		List<WebElement> phone = driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone 15')]"));
		TreeSet<String> sorted=new TreeSet<String>(Collections.reverseOrder());
		for(WebElement ele:phone)
		{
			String txt = ele.getText();
			sorted.add(txt);
		}
		for(String iphon:sorted)
		{
		System.out.print(iphon+" ");
		WebElement price = driver.findElement(By.xpath("//div[contains(text(),'"+iphon+"')]/../following-sibling::div//div[contains(text(),'₹')]"));
		System.out.print(price.getText());
		System.out.println();
		}
	}
}
