package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {
    private WebDriver driver;
    private Object SubCategoryPage;

    public SubCategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Cart clickhyperlink() throws InterruptedException
    {
        //Click on the search button on the search bar
        driver.findElement((By) SubCategoryPage).click();
        Thread.sleep(5000);

        public Cart (WebDriver driver) { this.driver = driver; };

        //Click on the Apple MacBooks button
        By product;
        driver.findElement(product).click();
        Thread.sleep(5000);
        return new Cart (driver);
    }
}



