package tests;

import org.junit.Assert;
import org.junit.Test;

import base.TestBase;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {

    @Test
    public void itShouldCalculateTotalIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterOneTimeInvestment("3624");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("info@furbo.sk");
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterOneTimeInvestment("8250");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("info@furbo.sk");
        Assert.assertFalse(calculatorPage.getInterestIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getInterestIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterOneTimeInvestment("1500");
        calculatorPage.enterYears("10");
        calculatorPage.enterEmail("info@furbo.sk");
        Assert.assertFalse(calculatorPage.getRisk().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        String[] arrayOfFunds = {"Tom & Jerry corp", "Batman's Cave Development", "McDuck's safe"};
        for (String arrayOfFund : arrayOfFunds) {
            calculatorPage.selectFund(arrayOfFund);
            calculatorPage.enterOneTimeInvestment("1500");
            calculatorPage.enterYears("10");
            calculatorPage.enterEmail("info@furbo.sk");
            Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
            Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
        }
    }
}
