package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //fetch URL to automate
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);

        // maximize the page of your browser while page loads
        driver.manage().window().maximize();

        // get page title
        System.out.println(driver.getTitle());

        // make page wait while url fully loads
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        //click on login/signup button
        driver.findElement(By.linkText("Login / Signup")).click();

        //Enter username
        driver.findElement(By.id("username")).sendKeys("tobbyno21@gmail.com");

        //Enter password
        driver.findElement(By.id("password")).sendKeys("Herdewole7139");

        //Click on Login
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        //Wait, so the next operation won't happen so fast
        Thread.sleep(5000);

        //Mouseover Computer and Accessories Category
        WebElement Laptop = driver.findElement(By.linkText("Computers and Accessories"));
        actions.moveToElement(Laptop).perform();

        //Click on the Laptops subcategory

        //driver.findElement(By.xpath("//a[@href='/category/laptops-5230']")).click();

        //Click on the Apple MacBooks button
        driver.findElement(By.linkText("Macbooks")).click();
        //actions.moveToElement(Macbook).perform();

        //Click on the Add to cart button
        driver.findElement(By.xpath("//main[@id='mainContent']/section[2]/section[1]/section[1]/section[1]/section[1]/ul[1]/li[8]/div[1]/div[1]/div[2]/form[1]/div[4]/button[1]")).click();

        //Click on the My Cart menu button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]/span[1]")).click();

        //Click on Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //Click on Address
        driver.findElement(By.linkText("Change Address")).click();
        Thread.sleep(5000);

        //Select Address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);

        //Click use this address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //Select the PAY NOW Option
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG _4a291_2cOtr' and @name = 'selectPaymentMethod']")).click();

        //Click on the Continue to Payment button
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG' and @name='placeOrder']")).click();

        //Select iframe that comes up for payment
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);

        //Click on the card option
        driver.findElement(By.xpath("//button[@class = 'dashboard-card__button Card']")).click();

        //Enter the card number
        driver.findElement(By.xpath("//input[@class = 'card-number input_class' and @id = 'card-number']")).sendKeys("5399832610076824");

        //Enter Expiry Date
        driver.findElement(By.xpath("//input[@class = 'date input_class' and @id = 'expiry']")).sendKeys("0621");

        //Enter CVV
        driver.findElement(By.xpath("//input[@class = 'cvv input_class' and @id = 'cvv']")).sendKeys("587");

        //Click on the Pin input box
        driver.findElement(By.xpath("//input[@class = 'card-pin' and @id = 'card-pin-new']")).click();

        //Enter Pin
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '7']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '5']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '8']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '9']")).click();

        //Print error message of card number field
        WebElement error = driver.findElement(By.xpath("//label[@id='card-number_unhappy' and text() = 'Invalid card number']"));
        String errorPrint = error.getText();
        System.out.println(errorPrint);

    }

    public static void main(String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();
    }

}