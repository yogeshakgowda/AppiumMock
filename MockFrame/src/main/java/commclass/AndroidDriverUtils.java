package commclass;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidDriver.*;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class AndroidDriverUtils 
{
	AndroidDriver driver;

	public AndroidDriverUtils(AndroidDriver driver)
	{
		this.driver=driver;
	}

	public void installAPP(String Package_name,String path)
	{
		driver.installApp(path);
		driver.isAppInstalled(Package_name);
	}

	public void unInstalled(String Package_name)
	{
		driver.removeApp(Package_name);
	}
	public void hideKeyboard()
	{
		driver.hideKeyboard();
	}

	public void openNotification()
	{
		driver.openNotifications();
	}

	public void deviceLocked()
	{
		driver.isDeviceLocked();
	}

	public void appState(String Package_name)
	{
		driver.queryAppState(Package_name);
	}

	public void activateApp(String Package_name)
	{
		driver.activateApp(Package_name);
	}

	public void appInBackground(int time)
	{
		driver.runAppInBackground(Duration.ofSeconds(time));
	}

	public void context()
	{
		Set<String> ch = driver.getContextHandles();
		int count=ch.size();
		System.out.println(count);
		for(String allch:ch)
		{
			System.out.println(allch);
		}
	}

	public void switchContext(String WEBVIEW_packagename)
	{
		driver.context(WEBVIEW_packagename);
	}

	public void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void orientationLandScpe()
	{
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.LANDSCAPE);
	}

	public void orientationPotrait()
	{ 
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.PORTRAIT);
	}

	public void turnOfdata()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withDataDisabled().build());
	}

	public void turnOndata()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
	}

	public void turnOfwifi()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
	}

	public void turnOnwifi()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
	}

	public void turnAirPlaneoff()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withAirplaneModeDisabled().build());
	}

	public void turnAirPlaneOn()
	{
		ConnectionState dataoff = driver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
	}

}
