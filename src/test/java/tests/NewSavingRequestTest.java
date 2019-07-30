package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Tom & Jerry corp");
        calculatorPage.enterOneTimeInvestment("2820");
        calculatorPage.enterYears("15");
        calculatorPage.enterEmail("info@furbo.sk");
        //precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //vytvorit novy saving request
        calculatorPage.submitRequest();
        //overim ze total income sa zobrazi v requeste

        Assert.assertEquals(
            calculatedIncome,
            driver
                .findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class,'amounts')]/p/span"))
                .getText()
        );

        Assert.assertEquals(
            calculatedIncome,
            driver
                .findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span"))
                .getText()
        );
    }
}
