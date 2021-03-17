package setup;

import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupTests {
    //Create a WebDriver Object
    private WebDriver driver;

    //Create LoginPage object
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp()
    {
        //Selenium WebDriver needs this executable in order to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\TestCodeCamp_Programme\\Submissions\\SeleniumWebdriverTests\\PageObjectModel_Tasks\\OrangeHRM_POM\\Resources\\chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();
        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        // ".close" would close the window but the ".quit" would exit the session
        driver.quit();
    }
}