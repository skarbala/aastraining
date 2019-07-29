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
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("3624");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        Assert.assertTrue(driver
            .findElement(By.cssSelector("div.result > div:nth-child(1) > p"))
            .getText()
            .contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("8250");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
        Assert.assertTrue(driver
            .findElement(By.cssSelector("div.result > div:nth-child(2) > p"))
            .getText()
            .contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("1500");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund() {
        String[] arrayOfFunds = {"Tom & Jerry corp", "Batman's Cave Development", "McDuck's safe"};
        for (String arrayOfFund : arrayOfFunds) {
            selectFund(arrayOfFund);
            enterOneTimeInvestment("1500");
            enterYears("10");
            enterEmail("info@furbo.sk");
            Assert.assertFalse(driver
                .findElement(By.cssSelector("div.result > div:nth-child(1) > p"))
                .getText()
                .isEmpty());
            Assert.assertTrue(driver
                .findElement(By.cssSelector("div.result > div:nth-child(1) > p"))
                .getText()
                .contains("kr"));
        }
    }

    private void enterOneTimeInvestment(String amountToEnter) {
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    private void selectFund(String fundToBeSelected) {
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToBeSelected);
    }


    private void enterYears(String yearsToEnter) {
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);

    }

    private void enterEmail(String emailToEnter) {
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys(emailToEnter);
    }


    @After
    public void tearDown() {
        //        driver.close();
        //        driver.quit();
    }
}
