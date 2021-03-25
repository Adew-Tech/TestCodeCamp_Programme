package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {

    //Create a webDriver object for this class
    private WebDriver driver;
    private Object WebElement;

    //Create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements
    private By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[2]/div/form/div[3]/button");
    private By categoryBarElement = By.linkText("Computers and Accessories");
    private final By subcategory = By.className("Laptops");
    private By product = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span");
    private By logOut = By.linkText("Logout");

    //Click the login/sign up button on the landing page
    public LoginPage clickLoginSignUpButton() throws InterruptedException
    {
        //Wait for 3 seconds before executing the action
        Thread.sleep(3000);
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);

        //choose the category to mouse hover
        By categoryWebElement = null;
        By category = null;
        WebElement selectedCategory = driver.findElement(category WebElement).click();

        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //Click on the MacBook
        driver.findElement(subcategory).click();
        Thread.sleep(5000);

        return new SubCategoryPage(driver);
    }
}
