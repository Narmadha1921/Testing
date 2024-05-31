package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Flipkart_Automate {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
	// print realme phone Names
	List<WebElement> realme=driver.findElements(By.xpath("//*[contains(text(),'realme')]"));
	
	for(WebElement text:realme) {
		System.out.println(text.getText());

	}// realme phones count
	System.out.println("count of Realme Phones "+ realme.size());
	
	//
	driver.findElement(By.xpath("//a[@title='realme 12x 5G (Twilight Purple, 128 GB)'][1]")).click();
	Set<String>Windowhandles=driver.getWindowHandles();
	System.out.println(Windowhandles);
	List<String>windowhandle=new ArrayList<>(Windowhandles);
	driver.switchTo().window(windowhandle.get(1));
	//view details
	driver.findElement(By.xpath("//span[@class='sBWZ-k']")).click();
	//takesscreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File des=new File("./Screenshot/img3.png");
	FileHandler.copy(source, des);
	//closing the details
	driver.findElement(By.xpath("//button[@class='QqFHMw gtm1So']")).click();
	//buy now
	driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")).click();
	//screenshot
	TakesScreenshot ts2=(TakesScreenshot)driver;
	File source1=ts2.getScreenshotAs(OutputType.FILE);
	File des2=new File("./Screenshot/img4.png");
			FileHandler.copy(source1, des2);
			driver.navigate().back();
	//add to cart

	for(int i=0;i<120;i++) {
	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
//save for later
	for(int i=0;i<70;i++) {
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	}
	driver.findElement(By.xpath("//div[text()='Save for later']")).click();


}
}