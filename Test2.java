package testNG_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass()
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    //  Login / Signup 
    @Test(priority=1)
    public void Login() {

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//input[@placeholder='Name']")))
                .sendKeys("Diptia");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys("diptiamu22@gmail.com");

        driver.findElement(By.xpath("//button[contains(text(),'Signup')]"))
                .click();
    }

    
    
    //Fill Account Info (depends on Login)
    @Test(priority=2)                                                                                   
    public void FillAccountInfo() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[text()='Enter Account Information']")));

        driver.findElement(By.xpath("//input[@data-qa='name']"))
                .clear();

        driver.findElement(By.xpath("//input[@data-qa='name']"))
                .sendKeys("Dipti");

        driver.findElement(By.id("password"))
                .sendKeys("12345");
        
        
        WebElement ele=driver.findElement(By.xpath("//div[@class='form-group']"));
        Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByVisibleText("6");
		
        Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByVisibleText("March");
       
        Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByVisibleText("2015");
       
        driver.findElement(By.xpath("//div[@class='login-form']//form"));
      

        driver.findElement(By.id("first_name")).sendKeys("Lipi");
        driver.findElement(By.id("last_name")).sendKeys("Biswal");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Amus");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Sbp");
        
        WebElement ele2=driver.findElement(By.xpath("//select[@id='country']"));
        Select company=new Select(driver.findElement(By.xpath("//select[@id='country']")));
        company.selectByContainsVisibleText("Canada");
        
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Odisha");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("BBsr");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("768109");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("8018135453");
        
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        
       }

     
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}