package homework.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id = "homeIcon")
    private WebElement logoIcon;
    @FindBy(id = "sign-in-button")
    private WebElement signInButton;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickLogin() {
        loginLink.click();
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(LoginPage.PAGE_URL));
    }
    public void logoClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoIcon));
        logoIcon.click();
    }
    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
    public void populateUserName(String username) {
        usernameField.sendKeys(username);
    }
    public void populatePassword(String password) {
        passwordField.sendKeys(password);
    }
}
