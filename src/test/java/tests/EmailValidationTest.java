package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import base.TestBase;
import pages.CalculatorPage;

public class EmailValidationTest extends TestBase {

    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //zadam zly email
        calculatorPage.enterEmail("wefwefw");
        //overim ze atribut class obsahuje error
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]"))
            .getAttribute("class")
            .contains("error")
        );
    }
}
