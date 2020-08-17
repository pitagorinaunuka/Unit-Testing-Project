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

class ContactTestSuite extends BaseTest {

	 private static String newUrl1 = "https://www.klix.ba/kontakt";
	
	
		//Main title check for given subpage
		
		@Test
		void contactTitleTest() {
			driver.navigate().to(newUrl1);
			String actualTitle="";
			String expectedTitle="Kontakt | Klix.ba";
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
		void contactFirstTitleTest() {
			driver.navigate().to(newUrl1);
			WebElement contactFirstTitle = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/h1"));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertTrue(contactFirstTitle.isDisplayed());
		}
		
			
	    //Paragraph check for given subpage
		@Disabled
		@Test
		void contactParagraphTest() {
			driver.navigate().to(newUrl1);
			WebElement paragraphText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div[1]/p"));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertTrue(paragraphText.isDisplayed());	
		}
}
