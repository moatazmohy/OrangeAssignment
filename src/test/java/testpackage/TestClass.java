package testpackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class TestClass {
    private WebDriver driver;
    private HomePage homePage;
    private Header header;
    private SearchResultPage searchResultPage;
    private MobilePhonePage mobilePhonePage;
    private CartPage cartPage;
    private String actualResult;
    private String expectedResult = "عربة تسوق أمازون الخاصة بك فارغة.";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        header = new Header(driver);
        searchResultPage = new SearchResultPage(driver);
        mobilePhonePage = new MobilePhonePage(driver);
        cartPage = new CartPage(driver);
        driver.manage().window().maximize();
        homePage.openURL();
    }

    @Test(description = "Search for a mobile then add to cart then delete it from the cart")
    public void addProductToCart() {
        header.searchProducts("Mobile");
        searchResultPage.clickXiaomiCheckBox();
        searchResultPage.setMinAndMaxPrice("3500", "5500");
        searchResultPage.clickLastMobile();
        mobilePhonePage.clickAddToCartBtn();
        header.clickCartBtn();
        cartPage.clickDeleteBtn();
        actualResult = cartPage.getEmptyCartMsg();
        Assert.assertTrue(actualResult.contains(expectedResult), "The Product has been deleted successfully");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
