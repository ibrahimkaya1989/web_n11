import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Initialize {

    public static String product = "Samsung";
    public static String removeWarning = "Ürününüz listeden silindi.";
    public static String wishListEmptyWarning = "İzlediğiniz bir ürün bulunmamaktadır.";

    protected static WebDriver driver;
    protected static ProjectProperties pp = new ProjectProperties();
    protected static CommonMethods CM = new CommonMethods();
    protected static ValidateData VD = new ValidateData();

    @BeforeSuite
    public static void SetupURL(){
        driver = InitializeDriver();
        CM = new CommonMethods();
    }


    public static WebDriver InitializeDriver(){
        System.out.println("*********************************************");
        System.out.println("Lounching Chrome Driver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        //System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", "src/main/driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        return driver;
    }


    @AfterSuite
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
