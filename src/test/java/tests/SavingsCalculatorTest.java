package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import pages.CalculatorPage;

public class SavingsCalculatorTest extends TestBase {

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
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        //2.zadat sumu
        calculatorPage.enterOneTimeInvestment("1500");
        //3.zadat pocet rokov
        calculatorPage.enterYears("10");
        //4.zadat email
        calculatorPage.enterEmail("info@furbo.sk");
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
}
