package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class FooterTestSuite extends BaseTest {


	
		//Hyperlinks in the footer
		@Test
		void footerLinksTest() {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			WebElement footerLink = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/a[1]"));
			footerLink.click();
			assertTrue(footerLink.isDisplayed());
		}
		
		
		 //Social media button links in the footer
		 @Test
		 void footerSocialMediaTest() {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			WebElement footerSocialMedia = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div/a[1]/img"));
			footerSocialMedia.click();
			assertTrue(footerSocialMedia.isDisplayed());
		 }
			
		
		 //Homepage logo link in the footer
		 @Test
		 void footerLogoTest() {
			WebElement footerLogo = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/a/span"));
			footerLogo.click();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String expectedUrl = "https://www.klix.ba/";
			assertEquals(expectedUrl,driver.getCurrentUrl());
		 }

}
