package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;
    private By AddToCartButton = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[10]/div/div/div[2]/form/div[4]/button");
    private By MyCartButton= By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]/span[1]");

    public Cart(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click the first Add to cart button
    public void clickOnAddToCart() throws InterruptedException
    {
        driver.findElements(AddToCartButton).getClass("f5e10_VzEXF _59c59_3-MyH lazyloaded ").click();
        Thread.sleep(5000);
    }

    //Click My Cart Button
    public AddToCartPage clickMyCartButton() throws InterruptedException
    {
        driver.findElement(MyCartButton).click();
        Thread.sleep(3000);
        return new AddToCartPage(driver);
    }



}
