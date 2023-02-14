package homework.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";
    private final WebDriver driver;
    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;
    @FindBy(tagName = "h2")
    private WebElement username;
    @FindBy(css = "#navbarColor01 > ul.navbar-nav.my-ml.d-none.d-md-block > li > a > i")
    private WebElement logOutButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(ProfilePage.PAGE_URL));
    }
    public void clickProfileLink() {
        profileLink.click();
    }
    public String getUsername() {
        return username.getText();
    }
    public void clickLogOut() {
        logOutButton.click();
    }
}
