package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    //Variables
    WebDriver driver;
    String url = "https://www.amazon.eg/";

    //Locators

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void openURL() {
        driver.navigate().to(url);
    }

}
