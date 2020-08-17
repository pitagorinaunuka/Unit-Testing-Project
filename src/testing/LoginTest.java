package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class LoginTest extends BaseTest {

	 @Test
	    public void testLoginCorrectData() {
	    this.baselogin();
	    String actualResult= "https://www.klix.ba/";
	    String expectedResult= driver.getCurrentUrl();
	    assertEquals(expectedResult,actualResult);
	    System.out.println("Login successful");
	    }
	 
	 @Disabled
	 @Test
	    public void testLoginWithIncorrectData() {
          WebElement errormsg = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[1]"));
          assertTrue(errormsg.isDisplayed());
	 }

	   
}




