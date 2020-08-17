package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class HomepageTestSuite extends BaseTest {

	
	@Test
	void homeButtonLogoTest() throws InterruptedException {
		WebElement homeButtonLogo = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/div[2]/a/img"));
		homeButtonLogo.click();
		Thread.sleep(1000);
		String expectedUrl = "https://www.klix.ba/";
		assertEquals(expectedUrl,driver.getCurrentUrl());
		
	}
	
	@Test
	void navbarMouseHoverTest() {
		// Vijesti category
		Actions action = new Actions(driver);
		WebElement mouseHoverVijesti = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/nav/ul[1]/li[2]/div/a"));
		action.moveToElement(mouseHoverVijesti).build().perform();
		   try {
		    Thread.sleep(1000);

		} catch (Exception e) {
		e.printStackTrace();
		}
		WebElement mouseClickVijesti = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/nav/ul[1]/li[2]/ul/li[1]/div/a"));
		mouseClickVijesti.click();
		String expectedUrl = "https://www.klix.ba/najnovije";
		assertEquals(expectedUrl,driver.getCurrentUrl());
		driver.navigate().to(baseUrl);

		// Biznis category
		Actions action1 = new Actions(driver);
		WebElement mouseHoverBiznis = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/nav/ul[1]/li[3]/div/a"));
		action1.moveToElement(mouseHoverBiznis).build().perform();
		try {
		    Thread.sleep(1000);

		} catch (Exception e) {
		e.printStackTrace();
		}
		WebElement mouseClickBiznis = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/nav/ul[1]/li[3]/ul/li[1]/div/a"));
		mouseClickBiznis.click();
		String expectedUrl1 = "https://www.klix.ba/biznis/privreda";
		assertEquals(expectedUrl1,driver.getCurrentUrl());
	}
	
    @Disabled
	@Test
	void SearchBarDisplayedTest() {
	WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/div[5]/ul/li[1]/div/a/i"));
	searchBar.click();
	assertTrue(searchBar.isDisplayed());
	}
    
	
	@Disabled
	@Test
	void SearchKeyResultTest() {
	WebElement searchBarIcon = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/div[5]/ul/li[1]/div/a/i"));
	searchBarIcon.click();
	WebElement searchField = driver.findElement(By.id("pojam"));
	try {
		Thread.sleep(1000);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	searchField.sendKeys("politika");
	WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[2]/div/form/a/i"));
	searchButton.click();
	try {
		Thread.sleep(1000);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	String expectedUrl = "https://www.klix.ba/pretraga?pojam=politika";
    assertEquals(expectedUrl,driver.getCurrentUrl());
	}
	
	@Disabled
	@Test
	void SearchKeyNoResultTest() {
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	WebElement searchBarIcon = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[1]/div[5]/ul/li[1]/div/a/i"));
	searchBarIcon.click();
	WebElement searchField = driver.findElement(By.id("pojam"));
	try {
		Thread.sleep(1000);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	searchField.sendKeys("polizika");
	WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/header/div[2]/div/form/a/i"));
	searchButton.click();
	try {
		Thread.sleep(1000);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
    assertEquals("Nema rezultata.",driver.findElement(By.tagName("body")).getText());
	}
	
    @Disabled
	@Test
	void DojaviVijestInputTest() {
	driver.get("https://www.klix.ba/dojavi-vijest");
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys("test@test.com");
	assertEquals("input",email.getTagName());
	driver.findElement(By.id("text")).sendKeys("test");
	assertEquals("textarea",driver.findElement(By.id("text")).getTagName());	
	}
    
	@Disabled
	@Test
	void DojaviVijestAddAttachment() {
	WebElement addFiles = driver.findElement(By.xpath("//*[@id=\"slike\"]/div[1]/input"));
	String filePath ="C:\\\\Users\\\\Merjema\\\\Desktop\\\\demo.jpg";
    addFiles.sendKeys(filePath);			
    try {
		Thread.sleep(4000);
			
    } catch (Exception e) {
		e.printStackTrace();
		}
	WebElement removeImage = driver.findElement(By.cssSelector(".remove-img icon_x"));
	removeImage.click();
	}
	
	@Disabled
	@Test
	void HomepagedotRefreshButton() {
	driver.findElement(By.className("kruznitok")).click();
	assertEquals(this.baseUrl,driver.getCurrentUrl());
	}
	
	@Disabled
	@Test
	void HomepageViseButton() {
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[6]/div[2]/div[1]/a")).click();
	assertEquals("https://www.klix.ba/sport",driver.getCurrentUrl());
	}
	
	
	@Disabled
	@Test
    void NumberOfSharedArticlesOnHomepageTest() {
	// share icon refers to the first article displayed on a homepage
     WebElement article = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]"));
     System.out.println("Article's shares number that is being tested:" + article.getText());
     WebElement shareicon = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]/div/article/a/div[1]/span[2]"));
     int result = Integer.parseInt(shareicon.getText());
     System.out.println("Number of shares on a homepage's first article is:" + result);
     assertTrue(result>=0);
	  }
		 
    @Disabled
    @Test
	void NumberOfCommentsOnPostHomepageTest() {
    WebElement article = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]"));
    System.out.println("Article's comment number that is being tested:" + article.getText());
    WebElement commenticon = driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]/div/article/a/div[4]/span[3]"));
    System.out.println(commenticon.getText());
    int result = Integer.parseInt(commenticon.getText());
    System.out.println("Number of comments on a homepage's first article is:" + result);
    assertTrue(result>= 0); 
     }
		 
	@Disabled
	@Test
     void AdHomepageTest() {
     int numberOfWindows = driver.getWindowHandles().size(); // we count windows opened before clicking on the Facebook button (1)
	 driver.findElement(By.xpath("//*[@id=\"aw0\"]/amp-img")).click();
     String MainWindow=driver.getWindowHandle();		
     Set<String> s1=driver.getWindowHandles();	
	 // +1 is the facebook popup window
	 assertEquals(numberOfWindows + 1, driver.getWindowHandles().size());
     Iterator<String> i1=s1.iterator();		
     while(i1.hasNext())			{		
	  String ChildWindow=i1.next();		
	   if(!MainWindow.equalsIgnoreCase(ChildWindow))			
     {    		
        // Switching to Child window
		 driver.switchTo().window(ChildWindow);	                                                                                                           
		 driver.getPageSource();
	    //login will not succeed, but we tested funcionality of entering information
    }		
	}	
	  this.vars.put("window_handles", driver.getWindowHandles());
	  try {
	  Thread.sleep(5000);
	  } catch (Exception e) {
	  e.printStackTrace(); }
	  driver.findElement(By.xpath("xpath=//jdiv[@id='jcont']/jdiv/jdiv[2]/jdiv/jdiv[4]/jdiv/jdiv/jdiv/textarea")).click();
			
	 }
	     
	     @Disabled
	     @Test
	     void BreadcrumbTrailNavigationTest()  {
	    	 driver.get("https://www.klix.ba/najnovije");
	    	 driver.manage().window().maximize();
	    	 driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div/div[1]/div/a[1]")).click();
	    	 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	 assertEquals(baseUrl,driver.getCurrentUrl());
	    		 
	     }
	     
	     
	     

}
