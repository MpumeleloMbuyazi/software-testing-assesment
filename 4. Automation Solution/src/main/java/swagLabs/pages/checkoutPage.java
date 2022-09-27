package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    //Initialize Page Objects
    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    public checkoutPage(WebDriver driver){

        //New instance of the Webdriver
        this.driver = driver;
        //Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public void addYourInfo(String firstName, String lastName, String postalCode){

        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
        //Enter username and password
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        this.continueBtn.click();

    }
}
