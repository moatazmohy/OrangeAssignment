package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MobilePhonePage {
    //Variables
    WebDriver driver;

    //Locators
    private By addToCartBtn = By.id("add-to-cart-button");
    
    //Constructor
    public MobilePhonePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void clickAddToCartBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        driver.findElement(addToCartBtn).click();
    }
}
