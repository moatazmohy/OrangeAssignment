package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    //Variables
    WebDriver driver;

    //Locators
    private By searchBox = By.id("twotabsearchtextbox");
    private By cartBtn = By.partialLinkText("عربة التسوق");

    //Constructor
    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void searchProducts(String searchWord) {
        driver.findElement(searchBox).sendKeys(searchWord,Keys.ENTER);
    }

    public void clickCartBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(driver.findElement(cartBtn)));
        driver.findElement(cartBtn).click();
    }
}
