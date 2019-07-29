package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class CalculationTest extends TestBase {

    @Test
    public void itShouldCalculateTotalIncome() {
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("3624");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("8250");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(getInterestIncome().isEmpty());
        Assert.assertTrue(getInterestIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        selectFund("Tom & Jerry corp");
        enterOneTimeInvestment("1500");
        enterYears("10");
        enterEmail("info@furbo.sk");
        Assert.assertFalse(getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund() {
        String[] arrayOfFunds = {"Tom & Jerry corp", "Batman's Cave Development", "McDuck's safe"};
        for (String arrayOfFund : arrayOfFunds) {
            selectFund(arrayOfFund);
            enterOneTimeInvestment("1500");
            enterYears("10");
            enterEmail("info@furbo.sk");
            Assert.assertFalse(getTotalIncome().isEmpty());
            Assert.assertTrue(getTotalIncome().contains("kr"));
        }
    }

    private String getTotalIncome() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }

    private String getInterestIncome() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }

    private String getRisk() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
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
}
