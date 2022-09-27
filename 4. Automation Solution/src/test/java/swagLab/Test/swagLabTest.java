package swagLab.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import swagLabs.pages.*;

import java.io.File;

public class swagLabTest {

    private WebDriver driver;
    private String expectedPrice;
    private String expectedConfirmationMsg;

    @BeforeTest
    @Parameters({"expectedPrice", "expectedConfirmationMsg"})
    public void setupDriver(String expectedPrice, String expectedConfirmationMsg){

        this.expectedPrice = expectedPrice;
        this.expectedConfirmationMsg = expectedConfirmationMsg;

        System.setProperty("webdriver.chrome.driver", "Resources" + File.separator + "chromedriver.exe");
        this.driver =new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void loginPageTest(){
        
        loginPage loginPage = new loginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(dependsOnMethods = "loginPageTest")
    public void productsPageTest(){

        productsPage productsPage = new productsPage(driver);
        productsPage.addProducts();
    }

    @Test(dependsOnMethods = "productsPageTest")
    public void chartPageTest(){

        chartsPage chartsPage = new chartsPage(driver);
        chartsPage.checkOut();
    }

    @Test(dependsOnMethods = "chartPageTest")
    public void checkoutPageTest(){

        checkoutPage checkoutPage = new checkoutPage(driver);
        checkoutPage.addYourInfo("Mpumelelo", "Dube", "1818");
    }

    @Test(dependsOnMethods = "checkoutPageTest")
    public void overviewPageTest(){

        overviewPage overviewPage = new overviewPage(driver);
        String ActualPrice = overviewPage.priceVerification();
        Assert.assertEquals(ActualPrice, expectedPrice);
        String ActualConfirmationMsg = overviewPage.checkoutConfirmation();
        Assert.assertEquals(ActualConfirmationMsg, expectedConfirmationMsg);
    }

    @AfterTest
    public void closeBrowser(){

        this.driver.close();
    }

}
