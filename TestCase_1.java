package practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise11 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		
        System.out.println(driver.getTitle());
        String exptitle="Automation Exercise";
        String actualtitle=driver.getTitle();
        
        if(exptitle.equals(actualtitle)) {
        	System.out.println("it is home page");
        }
        else {
        	System.out.println("it is not home page");
        }
        
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        
        WebElement footer=driver.findElement(By.xpath("//footer[@id='footer']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",footer);
        
        
        WebElement sbpage=driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        if(sbpage.isDisplayed()) {
        	System.out.println("subscription page is visible");
        }
        else {
        	System.out.println("subscription page is not visible");
        }
        
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("biswal@123");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        
        WebElement alertmssg=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        if(alertmssg.isDisplayed()) {
        	System.out.println("alert message is visible");
        }
        else {
        	System.out.println("alert message is not visible");
        }
        
        driver.quit();
        
	}

}
