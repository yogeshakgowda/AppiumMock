package commclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtlis implements ITestListener
{

	@Override
	public void onTestFailure(ITestResult result) {
		String failed = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)MockBaseclass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./failed/"+failed+".png");
		try
		{
			FileUtils.copyFile(temp, perm);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String skipped = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)MockBaseclass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./skipped/"+skipped+".png");
		try
		{
			FileUtils.copyFile(temp, perm);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
