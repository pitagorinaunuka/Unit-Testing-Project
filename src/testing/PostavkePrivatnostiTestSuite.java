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

class PostavkePrivatnostiTestSuite extends BaseTest {

	 
	 private static String newUrl2 = "https://www.klix.ba/privatnost-postavke";
	 private static String newUrl3 = "https://www.klix.ba/privatnost";
	
	
		//Main title check for given subpage
		@Disabled
		@Test
		void privacyTitleTest() {
		driver.navigate().to(newUrl2);
		String actualTitle="";
		String expectedTitle="Postavke privatnosti | Klix.ba";
		try {
		Thread.sleep(1000);
		} catch (Exception e) {
		e.printStackTrace();
		}	
		actualTitle = driver.getTitle();
		assertEquals(expectedTitle,actualTitle);	
		 }
			
		
		 //Heading (h2) title check for given subpage
		 @Disabled
		 @Test
		 void privacyFirstTitleTest() {
			driver.navigate().to(newUrl2);
			WebElement privacyFirstTitle = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[2]/h2[1]"));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertTrue(privacyFirstTitle.isDisplayed());
		 }
			
		 
		 //Heading (h2) title check for given subpage
		 @Disabled
		 @Test
		 void privacySecondTitleTest() {
			driver.navigate().to(newUrl2);
			WebElement privacySecondTitle = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[2]/h2[2]"));
			assertTrue(privacySecondTitle.isDisplayed());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertTrue(privacySecondTitle.isDisplayed());
		 }
			
			
		 
		 //Choosing second radio button instead of the first and saving the result
		 @Disabled
		 @Test
		 void privacyRadiobutton1Test() {
			driver.navigate().to(newUrl2);
			WebElement privacyRadio1 = driver.findElement(By.id("personalizedOn"));
			WebElement privacyRadio2 = driver.findElement(By.id("personalizedOff"));
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			privacyRadio1.click();	
			assertTrue(privacyRadio1.isSelected());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			privacyRadio2.click();	
			assertTrue(privacyRadio2.isSelected());
				
			WebElement radioButton = driver.findElement(By.className("pbutton"));
			radioButton.click();
			assertTrue(radioButton.isSelected());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		 }
			
		 
		 //Subpage redirection from this subpage to another one
	     @Disabled
		 @Test
		 void privacySubpage1Test() {
			driver.navigate().to(newUrl2);
			WebElement privacySubpage1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[2]/p[3]/a"));
			privacySubpage1.click();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String expectedUrl = "https://www.klix.ba/privatnost";
			assertEquals(expectedUrl,driver.getCurrentUrl());		
		 }
			
	        
	     
	      //Subpage redirection from this subpage to another one
	      @Disabled
		  @Test
		  void privacySubpage2Test() {
			driver.navigate().to(newUrl3);
			WebElement privacySubpage2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/span[2]/a"));
			privacySubpage2.click();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String expectedUrl = "https://www.klix.ba/privatnost-postavke";
			assertEquals(expectedUrl,driver.getCurrentUrl());		
		 }

}
