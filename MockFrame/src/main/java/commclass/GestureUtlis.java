package commclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtlis 
{
	AndroidDriver driver;

	public GestureUtlis(AndroidDriver driver)
	{
		this.driver=driver;
	}

	public void LongClickcordi(int x_cd,int y_cd,int time)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("x",x_cd,"y",y_cd,"duration",time));
	}


	public void ClickActCordi(int x_cd,int y_cd)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of("x",x_cd,"y",y_cd));
	}

	public void pinchOpen(WebElement element,double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent", percentage));

	}

	public void pinchClose(WebElement element,double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent", percentage));
	}

	public void doubleClick(int x_cd,int y_cd)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("x",x_cd,"y",y_cd));
	}

	public void click(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of
				("elementId",((RemoteWebElement)element).getId()));
	}

	/**
	 * This method is used to long click on element
	 * @param element
	 */
	public void longClick(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId()));		
	}

	/**
	 * This method is used to double click on element
	 * @param element
	 */
	public void doubleClick(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId()));
	}

	/**
	 * This method is used to drag and drop the element
	 * @param element
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebElement element, int x, int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId(), "endX", x, "endY", y));
	}

	/**
	 * This method is used to Zoom In the given element/area
	 * @param element
	 * @param percentage
	 */
	public void zoomIn(WebElement element, double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId(), "percent", percentage));
	}

	/**
	 * This method is used to Zoom Out the given element/area
	 * @param element
	 * @param percentage
	 */
	public void zoomOut(WebElement element, double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId(), "percent", percentage));
	}

	/**
	 * This method is used to Swipe the given element
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 * @param direction
	 * @param percentage
	 */
	public void swipe(int left, int top, int width, int height, String direction, double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of
				("left", left, "top", top, "width", width, "height", height, 
						"direction", direction, "percent", percentage));
	}

	public void swipe(WebElement element, String direction, double percentage)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of
				("elementId", ((RemoteWebElement)element).getId(),
						"direction", direction, "percent", percentage));
	}

	/**
	 * This method is used to scroll until visible text
	 * @param value
	 */
	public void scrollToText(String value)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));")).click();
	}
	
	public void scrollToTextid(String id)
	{
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView"+"(new UiSelector().resourceIdMatches(\"" + id + "\"));"));
	}

	public void enter()
	{
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action","search"));
	}
}
