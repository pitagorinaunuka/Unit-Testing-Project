package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

	 protected static WebDriver driver;
	 protected static String baseUrl = "https://www.klix.ba/";
	 protected static String tvProgramUrl = "https://www.klix.ba/";
	 private static String loginUrl = "https://www.klix.ba/prijava";
     protected static Map<String, Object> vars;
	 protected static String articleUrl = "https://www.klix.ba/biznis/za-novu-godinu-vec-popunjeno-94-posto-smjestajnih-kapaciteta-u-sarajevu/191225039";
     private static User user;
	 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Merjema\\Desktop\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		vars = new HashMap<String, Object>();
		user = new User("merjema.milic@stu.ibu.edu.ba","demopassword12345");
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@AfterAll
    static void close() {
		driver.quit();
	    driver = null;
	    user = null;
	}
	
	void baselogin()  {
	driver.get(loginUrl);
	driver.findElement(By.id("rusername")).sendKeys(user.getEmail());;
	driver.findElement(By.id("rpassword")).sendKeys(user.getPassword());
	driver.findElement(By.cssSelector(".prbtn:nth-child(2)")).click();
    try {
	Thread.sleep(2000);
	  } catch (Exception e) {
    e.printStackTrace(); }   
	}
	
  }
	
	

