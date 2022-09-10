package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchResultPage {
    //Variables
    private WebDriver driver;
    private JavascriptExecutor js;

    //Locators
    private By showMoreBtn = By.partialLinkText("المزيد");
    private By xiaomiCheckBox = By.linkText("شاومي");
    private By minPriceField = By.id("low-price");
    private By maxPriceField = By.id("high-price");
    private By goBtn = By.id("a-autoid-1-announce");
    private By lastMobile = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[last()]");

    //Constructor
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }

    //Actions
    public void clickXiaomiCheckBox() {
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(showMoreBtn));
        driver.findElement(showMoreBtn).click();
        driver.findElement(xiaomiCheckBox).click();
    }

    public void setMinAndMaxPrice(String minPrice, String maxPrice) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(minPriceField));
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(minPriceField));
        driver.findElement(minPriceField).sendKeys(minPrice);
        driver.findElement(maxPriceField).sendKeys(maxPrice);
        driver.findElement(goBtn).submit();
    }

    public void clickLastMobile() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(lastMobile));
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(lastMobile));
        driver.findElement(lastMobile).click();
    }
}
