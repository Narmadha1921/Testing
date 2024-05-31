package project;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class flipnew3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement el=driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions action=new Actions(driver);
		action.moveToElement(el).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Electronics GST Store']")).click();
		List<WebElement>an=driver.findElements(By.xpath("//*[starts-with(text(),'M')]"));
		for(WebElement word:an) {
			System.out.println(word.getText());
		}
		//offer zone
		Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Offer Zone']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Gowns']")).click();
        //scroll
        for(int i=0;i<=50;i++) {
        	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
        }
        //dropdown
        Thread.sleep(1000);
        WebElement offer=driver.findElement(By.xpath("//select[@class='Gn+jFg']"));
        Select s1=new Select(offer);
        s1.selectByValue("1500");
        // discount
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Discount']")).click();
       Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='50% or more']")).click();
	}

}
