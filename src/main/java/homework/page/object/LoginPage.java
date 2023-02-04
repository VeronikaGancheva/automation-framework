package homework.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(LoginPage.PAGE_URL));
    }
    public void logoClick() {
        WebElement logoIcon = driver.findElement(By.id("homeIcon"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoIcon));
        logoIcon.click();
    }
    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();
    }
    public void populateUserName(String username) {
        WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameField.sendKeys(username);
    }
    public void populatePassword(String password) {
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);
    }
}
