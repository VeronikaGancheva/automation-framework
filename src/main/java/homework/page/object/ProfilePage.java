package homework.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }
    public void clickProfileLink() {
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        profileLink.click();
    }
    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }
    public void clickLogOut() {
        WebElement logOutButton = driver.findElement(By.cssSelector("#navbarColor01 > ul.navbar-nav.my-ml.d-none.d-md-block > li > a > i"));
        logOutButton.click();
    }
}
