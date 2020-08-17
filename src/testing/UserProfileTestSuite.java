package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

class UserProfileTestSuite extends BaseTest {

	 private static String baseUrl;
	 private static String newUrl5 = "https://www.klix.ba/profil/velikabh";

		//Changing username and saving the changes
		@Disabled
		@Test
		void usernameChangeTest() throws Exception {
			this.baselogin();
			driver.navigate().to("https://www.klix.ba/mojprofil");
			WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));    
			usernameField.clear();
			usernameField.sendKeys("testusername1");
			saveChangesButton.click();
		    try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String actualUrl="https://www.klix.ba/mojprofil";
		    String expectedUrl= driver.getCurrentUrl();
		    assertEquals(expectedUrl,actualUrl);
		 
		}
		
			
		
		//Changing password and saving the changes
		@Disabled
		@Test
		void passwordChangeTest() throws Exception {
			this.baselogin();
			driver.navigate().to("https://www.klix.ba/mojprofil");
			    
			WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"lozinka\"]"));
			WebElement passwordRepeatField = driver.findElement(By.xpath("//*[@id=\"plozinka\"]"));
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));
			    
		    passwordField.sendKeys("demopassword12345");
			passwordRepeatField.sendKeys("demopassword12345");
			saveChangesButton.click();
		    try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    String actualUrl="https://www.klix.ba/mojprofil";
		    String expectedUrl= driver.getCurrentUrl();
		    assertEquals(expectedUrl,actualUrl);
			
	    }
		
		
			
		//Choosing second radio button and saving the changes
		@Disabled
		@Test
		void genderRadiobuttonTest() throws Exception {
			this.baselogin();
			Thread.sleep(2000);
			driver.navigate().to("https://www.klix.ba/mojprofil");
				
			WebElement genderRadio1 = driver.findElement(By.xpath("//*[@id=\"s1\"]"));
			WebElement genderRadio2 = driver.findElement(By.xpath("//*[@id=\"s2\"]"));
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));
			
			genderRadio1.click();	
			assertTrue(genderRadio1.isSelected());
			Thread.sleep(1000);
			
			genderRadio2.click();	
			assertTrue(genderRadio2.isSelected());
			Thread.sleep(1000);
				
			saveChangesButton.click();
			assertTrue(saveChangesButton.isSelected());
			Thread.sleep(2000);
		}
			
			
	    //Choosing an item from dropdown and saving the changes
		@Test
		void dropdownProfileTest() throws Exception {
			this.baselogin();
			Thread.sleep(2000);
			driver.navigate().to("https://www.klix.ba/mojprofil");
				
			Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[8]/select")));
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));
			dropdown.selectByVisibleText("Sarajevo"); 
			List<WebElement> e1 = dropdown.getOptions();
			int itemCount = e1.size();
			saveChangesButton.click();
			String option = dropdown.getFirstSelectedOption().getText();
			System.out.println(option);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//	assertEquals("Sarajevo",option);
		//  System.out.println(dropdown.getAllSelectedOptions());			
		//	assertFalse(dropdown.selectByVisibleText("Sarajevo"));
		 }
			
			
		 //Checking if the "Save changes" button is displayed correctly
		 @Disabled
		 @Test
		 void saveChangesButtonTest() throws Exception {
			this.baselogin();
			Thread.sleep(2000);
			driver.navigate().to("https://www.klix.ba/mojprofil");
			    
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));
				
			saveChangesButton.click();
			assertTrue(saveChangesButton.isSelected());
			Thread.sleep(2000);
		 }
			
			
		 
		 //Choosing another avatar color and saving the changes
		 @Disabled
		 @Test
		 void avatarColorTest() throws Exception {
			this.baselogin();
			Thread.sleep(2000);
			driver.navigate().to("https://www.klix.ba/mojprofil");
			    
			WebElement colorButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[2]/div[2]/div/div/div[9]/div/div[4]/label"));
			colorButton.click();
			WebElement saveChangesButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[1]/div[1]/div[1]/button"));
			saveChangesButton.click();
			assertTrue(saveChangesButton.isSelected());
				
		 }

			
		 //Checking if the user comments are displayed correctly on user's profile
		 @Disabled
		 @Test
		 void userCommentSectionTest() throws Exception {
			this.baselogin();
			Thread.sleep(2000);
			driver.navigate().to("https://www.klix.ba/profil/testusername1");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		    WebElement userCommentSection = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/section/h2"));
			assertTrue(userCommentSection.isDisplayed());
			
		 }
			
			
		 
		 @Disabled
		 @Test
		 void otherUserCommentSectionTest() {
			driver.get(baseUrl);
			driver.manage().window().maximize();
			driver.navigate().to(newUrl5);
				
			WebElement subpageCommentTitle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/div/section/div/div[1]/div[1]/a"));
			subpageCommentTitle.click();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		    String expectedUrl = "https://www.klix.ba/sport/nogomet/neslavan-kraj-gradskog-derbija-gubili-8-0-pa-na-poluvremenu-otisli-kuci/191228095";
			assertEquals(expectedUrl,driver.getCurrentUrl());
			
		 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
