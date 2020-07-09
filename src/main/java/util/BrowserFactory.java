package util;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//WebDriver
       driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://techfios.com/test/103/");
		return driver;
	}

	public static void tearDown() {
		driver.quit();
		driver.close();
	}

}