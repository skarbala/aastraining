package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8888/savingscalculator.php");
    }

    @Test
    public void itShouldDisplayTitle() {
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldEnableApplyButton() {
        //1.vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("10");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("info@furbo.sk");
        //5.overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelectAnyFundOnPageOpen() {
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        Assert.assertEquals(
            "Select your fund",
            new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText()
        );
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
