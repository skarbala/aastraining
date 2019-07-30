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
            calculatorPage.getFirstSavingDetail()
                .findElement(By.cssSelector("div.amounts > p > span"))
                .getText()
        );
    }

    @Test
    public void itShouldDisplayFundInNewRequest() {
        String fundToSelect = "Tom & Jerry corp";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund(fundToSelect);
        calculatorPage.enterOneTimeInvestment("2820");
        calculatorPage.enterYears("15");
        calculatorPage.enterEmail("info@furbo.sk");
        //vytvorim novy saving request
        calculatorPage.submitRequest();
        //overit zobrazeny fond
        //vytiahnem si fond zo stranky a ulozim do premennej
        String displayedFund = calculatorPage.getFirstSavingDetail()
            .findElement(By.cssSelector("p.fund-description"))
            .getText();
        //porovnam zadany fond a ten ktory som si vytiahol zo stranky
        Assert.assertEquals(fundToSelect, displayedFund);
    }
}
