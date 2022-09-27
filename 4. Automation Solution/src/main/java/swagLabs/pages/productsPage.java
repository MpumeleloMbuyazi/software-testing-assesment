package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productsPage {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    //Page Objects
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement bagPack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLight;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")
    private WebElement basket;

    public productsPage(WebDriver driver){

        //New instance of the Webdriver
        this.driver = driver;
        //Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public void addProducts(){

        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.bagPack));
        //Add products to chart
        this.bagPack.click();
        this.bikeLight.click();
        this.basket.click();
    }


}
