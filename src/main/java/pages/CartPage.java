package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    //Variables
    WebDriver driver;

    //Locators
    private By deleteBtn = By.xpath("//input[@data-action='delete']");
    private By emptyCartMsg = By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']");

    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void clickDeleteBtn() {
        driver.findElement(deleteBtn).click();
    }

    public String getEmptyCartMsg() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg));
        return driver.findElement(emptyCartMsg).getText();
    }
}
