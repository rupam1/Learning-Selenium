package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;




public class testbase {
	
	public static WebDriver driver;
	@BeforeTest
	public void setup() {
	 
	 System.setProperty("webdriver.chrome.driver","D:\\Software\\chromedriver_win32\\chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver-v0.25.0-win64\\geckodriver.exe");
	 driver = new ChromeDriver();
	 //driver = new FirefoxDriver();
	 //Implicit Wait
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 //Maximize the window
	 driver.manage().window().maximize();
	 //Request the URL
	 driver.get("http://192.168.255.227:8080/ign-frontend");
	
	 
	
	}
	

	
}
