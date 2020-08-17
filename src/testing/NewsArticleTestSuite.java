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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class NewsArticleTestSuite extends BaseTest {

	// Redirect to the tag subpage
			@Disabled
			@Test
			void ArticleTagRedirectTest() {
			driver.get("https://www.klix.ba/tagovi");
			driver.findElement(By.linkText("Sarajevo")).click();
			driver.findElement(By.xpath("//*[@id=\"kat_naslovnica\"]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/article[1]/a")).click();
			WebElement tagSarajevo = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[1]/div[4]/a[1]"));
			assertEquals("Sarajevo",tagSarajevo.getText());
			}
			
			@Test 
			void ArticleFacebookButtonTest() {
			driver.get(this.articleUrl);
	        int numberOfWindows = driver.getWindowHandles().size(); // we count windows opened before clicking on the Facebook button (1)
			driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[1]/div[3]/a[2]/i")).click();
	        String MainWindow=driver.getWindowHandle();		
	        Set<String> s1=driver.getWindowHandles();	
	        // +1 is the facebook popup window
	        assertEquals(numberOfWindows + 1, driver.getWindowHandles().size());
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	         String ChildWindow=i1.next();		
	        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	        {    		
	        // Switching to Child window
	        driver.switchTo().window(ChildWindow);	                                                                                                           
	        driver.findElement(By.name("email")).sendKeys("demo");                			
	        driver.findElement(By.name("pass")).sendKeys("demo");;
	        driver.findElement(By.name("login")).click();
	        //login will not succeed, but we tested funcionality of entering information
	                                 
	            }		
			}	
       	}


			// Downvote comment test
		    @Disabled
			@Test
			void UpvoteCommentTest() {
		    driver.get(this.articleUrl);
			WebElement upvote = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/section/div[2]/div[2]/div[4]/div/div[2]/div[1]/div[1]"));
			String beforeUpvote = upvote.getText();
			System.out.println(beforeUpvote);
			upvote.click();
			 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String afterUpvote = upvote.getText();
			System.out.println(afterUpvote);
			assertNotSame(beforeUpvote,afterUpvote);	 
			 }
		    
		    
		     
		    // Downvote comment test
			 @Disabled
			 @Test
			 void DownvoteCommentTest() {
			 driver.get(this.articleUrl);
			 WebElement downVote = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/section/div[2]/div[2]/div[4]/div/div[2]/div[1]/div[2]"));
			 String beforeDownvote = downVote.getText();
			 System.out.println(beforeDownvote);
			 downVote.click();
			 try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 String afterDownvote = downVote.getText();
			 System.out.println(afterDownvote);
			 assertNotSame(beforeDownvote,afterDownvote);
			 }
			 
			 // Verifying that you can downvote only once
			 @Disabled
			 @Test
			 void DisabledOptionTDownvoteMultipleTimesTest() {
				driver.get(this.articleUrl);
				WebElement downVote = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/section/div[2]/div[2]/div[4]/div/div[2]/div[1]/div[2]"));
				String beforeDownvote = downVote.getText();
				System.out.println(beforeDownvote);
				downVote.click();
				System.out.println(downVote.getText());
				downVote.click();
				String afterDownVote= downVote.getText();
				// verifying that the count of downvotes don't increase
				assertTrue(downVote.getText().equals(afterDownVote));	
			 }
			 
			 // Verifying that you can upvote only once
			 @Disabled
			 @Test
			 void DisabledOptionToUpvoteMultipleTimesTest() {
				 driver.get(this.articleUrl);
				 WebElement upvote = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/section/div[2]/div[2]/div[4]/div/div[2]/div[1]/div[1]"));
				 String beforeUpvote = upvote.getText();
				 System.out.println(beforeUpvote);
				 upvote.click();
				 upvote.click();
				 String afterUpvote = upvote.getText();
				 System.out.println(afterUpvote);
		         assertTrue(upvote.getText().equals(afterUpvote));
			 }
			 
			 
			// Report comment test
			 @Disabled
			 @Test
			 void PrijaviKomentarTest() {
			   driver.get(this.articleUrl);
			   WebElement report = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/section/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/a"));
	           report.click();
	           driver.findElement(By.id("r6")).click();
	           driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div[2]/form/button")).click();
	           try {
				Thread.sleep(2000);
			   } catch (Exception e2) {
			   e2.printStackTrace();
			   }
	           Alert alert = driver.switchTo().alert();
	           assertEquals(alert.getText(),"Uspješno ste prijavili komentar. Hvala vam!");
	           alert.accept();
			 }
			 
			 
		
			 @Disabled
			 @Test
			 void ArrowRedirectingArticleTest() {
			  driver.get(this.articleUrl);
			  driver.findElement(By.cssSelector("#kat_clanak > div.main-view > div:nth-child(2) > div > div > div.block-dyn.rel > div.iznad_slike > div.clanakTop > div > div:nth-child(1) > div.clanakHead > div.kats.text-right > div.chevrons > a:nth-child(3) > i")).click();
			  assertFalse(driver.getCurrentUrl().equals(this.articleUrl));	 
			 }
			 
					 
			@Disabled
			 @Test
			 void PrijaviGreskuSuccessTest() {
				 driver.get(this.articleUrl);
				 WebElement prijaviGreskuButton = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/a/i"));
				 prijaviGreskuButton.click();
				 try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 driver.findElement(By.id("prijava-email")).sendKeys("demo@gmail.com");
				 driver.findElement(By.id("prijava-tekst")).sendKeys("demo");
				 try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				 driver.findElement(By.linkText("Pošalji prijavu")).click();
				 try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					} 	 
				 WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]"));
				 assertEquals("Vaša prijava je uspješno poslana. Hvala vam!",message.getText());
				 
			 }
			
			
		     @Disabled
			 @Test
			 void PrijaviGreskuEmptyFormTest() {
				 driver.get(this.articleUrl);
				 WebElement prijaviGreskuButton = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/a/i"));
				 prijaviGreskuButton.click();
				 try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
				 try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				 driver.findElement(By.linkText("Pošalji prijavu")).click();
				 try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					} 	 
				 WebElement message = driver.findElement(By.xpath("//*[@id=\"kat_clanak\"]/div[1]/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div[4]/div[1]"));
				 assertEquals("Greška: Molimo, unesite tekst.",message.getText());
				 
			 }
			
			

}
