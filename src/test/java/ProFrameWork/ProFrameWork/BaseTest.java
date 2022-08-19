package ProFrameWork.ProFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static Properties prop;
	public static FileInputStream fis;
	public static WebDriver driver;

	@BeforeTest
	public void Initialize() throws IOException {

		if (driver == null) {
			File path = new File(System.getProperty("user.dir") + "\\data.properties");
			fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);

			String BrowserNAme = prop.getProperty("browser");

			if (BrowserNAme.equals("Chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BrowserNAme.equals("Firefox")) {

				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			}

			driver.get(prop.getProperty("url"));	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

		}

	}

	@AfterTest
	public void TearDown() {
		if (driver != null) {

			driver = null;

		}

	}
}
