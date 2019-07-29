package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8888/savingscalculator.php");
    }

    @Test
    public void itShouldCalculateTotalIncome() {
        //1.vybrat fond, zadat sumu, roky, email
        //1.vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("10");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2.overit ze total income nie je prazdny
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        Assert.assertTrue(driver
            .findElement(By.cssSelector("div.result > div:nth-child(1) > p"))
            .getText()
            .contains("kr"));

    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1.vybrat fond, zadat sumu, roky, email
        //1.vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("10");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2.overit ze interest income nie je prazdny
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
        Assert.assertTrue(driver
            .findElement(By.cssSelector("div.result > div:nth-child(2) > p"))
            .getText()
            .contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        //1.vybrat fond, zadat sumu, roky, email
        //1.vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("10");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //2.overit ze risk nie je prazdny
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
        Assert.assertTrue(driver
            .findElement(By.cssSelector("div.result > div:nth-child(3) > p"))
            .getText()
            .contains("kr"));
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
