import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_SEARCH extends Initialize{

    @Test
    public static void connectURL(){
        driver.get(pp.readProperty("test.url"));
    }

    @Test(dependsOnMethods = "connectURL")
    public static void loginMenu() throws InterruptedException {
        CM.normalClickXpath("signIn.xpath");
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = "loginMenu")
    public static void testLogin() throws InterruptedException {

        CM.sendKeyId("username.id", pp.readProperty("test.email"));

        CM.sendKeyId("password.id", pp.readProperty("test.password"));

        Thread.sleep(2000);

        CM.normalClickXpath("loginButton.xpath");
    }

    @Test(dependsOnMethods = "testLogin")
    public static void searchProduct() throws InterruptedException {
        Thread.sleep(3000);
        CM.sendKeyId("searchBox.id", product);
        CM.normalClickXpath("searchButton.xpath");
    }

    @Test (dependsOnMethods = "searchProduct")
    public static void clickSecondPage() throws InterruptedException {
        CM.normalClickLinkText("secondPage.linkText");
    }

    @Test (dependsOnMethods = "clickSecondPage")
    public static void clickAddFavButton() throws InterruptedException {
        Thread.sleep(5000);
        CM.normalClickXpath("addFavButton.xpath");
    }

    @Test(dependsOnMethods = "clickAddFavButton")
    public static void mouseHoverOver() throws InterruptedException {
        CM.hoverOverElement("notification.xpath");
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "mouseHoverOver") // clickAddFavButton
    public static void goToFavorites() throws InterruptedException {
        CM.normalClickXpath("favButton.xpath");
    }

    @Test(dependsOnMethods = "goToFavorites")
    public static void goToMyFavorites() throws InterruptedException {
        CM.normalClickXpath("myFavButton.xpath");
    }

    @Test(dependsOnMethods = "goToMyFavorites")
    public static void removeFromMyFavorites() throws InterruptedException {
        CM.normalClickXpath("removeFromMyFavButton.xpath");
    }
}
