import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        ops.addArguments("--headed");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void Test() {

        driver.get("https:facebook.com");

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("purno");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ghosh");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Purnoghosh@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("Purnoghosh@gmail.com");

        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("purno2021");

        Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        sel1.selectByValue("26");
        Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        sel2.selectByVisibleText("Dec");

        Select sel3 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        sel3.selectByVisibleText("1997");
        driver.findElement(By.xpath("(//label[@class='_58mt'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

}
