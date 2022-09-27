package swagLabs.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class loginPage  {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    //Page Objects
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public loginPage(WebDriver driver){
        //New instance of the Webdriver.
        this.driver = driver;
        // Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public void login(String userName ,String password){

        //Launch Swag Labs website
        this.driver.get("https://www.saucedemo.com/");
        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.userName));
        //Enter username and password
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
    }

}
