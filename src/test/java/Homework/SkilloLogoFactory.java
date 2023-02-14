package Homework;

import homework.page.factory.HomePage;
import homework.page.factory.LoginPage;
import homework.page.factory.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SkilloLogoFactory {
    private WebDriver driver;
    @BeforeSuite
    protected final void setUpTestSuite() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
               {"testAdmin@gmail.com", "Admin1.User1", "AdminUser"},
                {"manager@gmail.com", "Manager1.Use1", "ManagerUser"}
        };
    }
   @Test
    public void testLogo() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isLogoDisplayed(),"Logo is not displayed");
        loginPage.clickLogin();
        loginPage.isUrlLoaded();
        Assert.assertTrue(homePage.isLogoDisplayed(),"Logo is not displayed");
        loginPage.logoClick();
        loginPage.isUrlLoaded();
    }
    @Test(dataProvider = "getUsers")
    public void testLogoLogin(String userName, String password, String name) {
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateTo();
        loginPage.clickLogin();
        loginPage.isUrlLoaded();
        loginPage.populateUserName(userName);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(profilePage.isUrlLoaded(),"Profile Page is not loaded");
        profilePage.clickProfileLink();
        profilePage.getUsername();
        Assert.assertEquals(profilePage.getUsername(), name, "The username is incorrect");
        profilePage.clickLogOut();
        loginPage.isUrlLoaded();
        Assert.assertTrue(homePage.isLogoDisplayed(),"Logo is not displayed");
        loginPage.logoClick();
        homePage.isUrlLoaded();
        Assert.assertTrue(homePage.isLogoDisplayed(),"Logo is not displayed");
    }
}