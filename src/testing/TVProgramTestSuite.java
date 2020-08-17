package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class TVProgramTestSuite extends BaseTest {
	
	@Disabled
    @Test
    void TVProgramLeftSidebarTest()  {
    driver.get(this.tvProgramUrl);	 
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[1]")).click();
    assertEquals("https://www.klix.ba/tv-program/bht1",driver.getCurrentUrl());
   
    }
    @Disabled
    @Test
    void TVProgramHyperLinkTest()  {
    driver.get(this.tvProgramUrl);	 
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[1]")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/span/a[1]/div/div[1]/span[1]")).click();
    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.findElement(By.xpath("//*[@id=\"navbar\"]/nav/div[2]/a/img")).click();
    assertEquals("https://tvprofil.com/ba/",driver.getCurrentUrl());
    }
   
  @Disabled 
   @Test
   void imageTvProfilRedirectTest() {
   driver.get(this.tvProgramUrl);	 
   driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/a")).click();
   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
   driver.switchTo().window(tabs2.get(1));
   driver.findElement(By.xpath("//*[@id=\"navbar\"]/nav/div[2]/a/img")).click();
   assertEquals("https://tvprofil.com/ba/",driver.getCurrentUrl());
	
   }
  @Disabled
  @Test
   void TvProfilTitleRedirectTest() {
   driver.get(this.tvProgramUrl);	 
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div/div[1]/a")).click();
	assertEquals("https://www.klix.ba/tv-program",driver.getCurrentUrl());
	
   }  
  
  
  @Disabled
  @Test
   void TvProfilDayInformationTest() {
    driver.get(this.tvProgramUrl);	 
	WebElement dateInformation = driver.findElement(By.className("vrijeme"));
	System.out.println(dateInformation.getText());
	assertTrue(dateInformation.isDisplayed());
   }  

}
