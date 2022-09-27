package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class overviewPage {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    //Page Objects
    @FindBy(css = "div.page_wrapper div:nth-child(1) div.checkout_summary_container div:nth-child(1) div.summary_info > div.summary_total_label:nth-child(7)")
    private WebElement totalPrice;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    private WebElement orderConfirmation;

    public overviewPage(WebDriver driver){

        //New instance of the Webdriver
        this.driver = driver;
        //Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public String priceVerification(){

        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.totalPrice));
        //Stores and prints price in a String and clicks finish button
        String price = this.totalPrice.getText();
        System.out.println(price);
        this.finishBtn.click();

        return price;

    }
    public String checkoutConfirmation (){

        this.wait.until(ExpectedConditions.visibilityOf(this.orderConfirmation));
        //Stores and prints Confirmation Massage in a String
        String confirmationMsg = this.orderConfirmation.getText();
        System.out.println(confirmationMsg);

        return confirmationMsg;

    }
}
