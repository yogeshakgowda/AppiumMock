package PomPage;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class flipkartjava 
{
	AndroidDriver driver;
	
@FindBy(xpath="//div[text()='Search for Products, Brands and More']")
private WebElement search;

@FindBy(xpath="//input[@type=\"search\"]")
private WebElement searchenter;


@FindBy(xpath="/div[contains(text(),'Apple iPhone 15')]")
private WebElement phone;

@FindBy(xpath="//div[@class=\"css-175oi2r\"]/child::div[@class=\"css-1rynq56\" and contains(text(),'₹')]")
private WebElement price;

@FindBy(xpath="//div[text()='Apple iPhone 15 (Blue, 128 GB)']")
private WebElement clickonproduct;

@FindBy(xpath="//div[text()='Add to cart']")
private WebElement addtocart;

@FindBy(xpath="//div[text()='Go to cart']")
private WebElement gotocart;

@FindBy(xpath="//div[contains(text(),'Apple iPhone 15')]")
private WebElement iphone;

public flipkartjava(AndroidDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver, this);
}

public WebElement getSearch() {
	return search;
}

public WebElement getSearchenter() {
	return searchenter;
}

public WebElement getPhone() {
	return phone;
}

public WebElement getPrice() {
	return price;
}

public WebElement getClickonproduct() {
	return clickonproduct;
}

public WebElement getAddtocart() {
	return addtocart;
}

public WebElement getGotocart() {
	return gotocart;
}

public WebElement getIphone() {
	return iphone;
}

public void searchiphone(String ans) throws InterruptedException
{
	search.click();
	Thread.sleep(3000);
	searchenter.sendKeys(ans);
	Thread.sleep(3000);
    driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action","search"));
    Thread.sleep(3000);
}
}
