package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.MathUtils;

public class CalculatorPage {
    private WebDriver pageDriver;

    public CalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void selectFund(String fundToBeSelected) {
        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToBeSelected);
    }

    public String getTotalIncome() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }


    public String getInterestIncome() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }

    public String getRisk() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }

    public void enterOneTimeInvestment(String amountToEnter) {
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).clear();
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    public void enterYears(String yearsToEnter) {
        pageDriver.findElement(By.id("yearsInput")).clear();
        pageDriver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);
    }

    public void enterEmail(String emailToEnter) {
        pageDriver.findElement(By.id("emailInput")).clear();
        pageDriver.findElement(By.id("emailInput")).sendKeys(emailToEnter);
        pageDriver.findElement(By.id("emailInput")).sendKeys(Keys.TAB);
    }

    public void submitRequest() {
        pageDriver.findElement(By.cssSelector("button.btn-block")).click();
    }

    public WebElement getFirstSavingDetail() {
        return pageDriver.findElement(By.cssSelector("ul.saving-list > li > div.saving-detail"));
    }

    public void selectRandomFund() {
        int numberOfOptions = new Select(pageDriver.findElement(By.id("fundSelect"))).getOptions().size();
        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByIndex(MathUtils.getRandomNumberInRange(
            1,
            numberOfOptions - 1
        ));
    }
}
