import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC01_N11_CUCUMBER extends Initialize{

    @Given("user is on n11")
    public void user_is_on_n11() throws InterruptedException {

        driver = InitializeDriver();
        CM = new CommonMethods();
        driver.get(pp.readProperty("test.url"));

        CM.normalClickXpath("signIn.xpath");

        CM.sendKeyId("username.id", pp.readProperty("test.email"));
        CM.sendKeyId("password.id", pp.readProperty("test.password"));

        CM.normalClickXpath("loginButton.xpath");

        throw new io.cucumber.java.PendingException();
    }
    @When("search the product and validate search result")
    public void search_the_product_and_validate_search_result() throws InterruptedException {

        CM.sendKeyId("searchBox.id", product);
        CM.normalClickXpath("searchButton.xpath");

        throw new io.cucumber.java.PendingException();
    }
    @When("go to second page and validate page")
    public void go_to_second_page_and_validate_page() {

        VD.setPageNumber(CM.getTextLinkText("secondPage.linkText"));
        CM.normalClickLinkText("secondPage.linkText");

        Assert.assertEquals(VD.getPageNumber(), CM.getTextXpath("activePage.xpath"));

        throw new io.cucumber.java.PendingException();
    }
    @When("add into watch list")
    public void add_into_watch_list() throws InterruptedException {

        VD.setProductName(CM.getTextLinkText("productText.xpath"));
        CM.normalClickXpath("addFavButton.xpath");

        throw new io.cucumber.java.PendingException();
    }
    @When("go to watch list")
    public void go_to_watch_list() throws InterruptedException {

        CM.hoverOverElement("myAccount.xpath");
        CM.normalClickXpath("favButton.xpath");
        CM.normalClickXpath("myFavButton.xpath");

        throw new io.cucumber.java.PendingException();
    }
    @When("validate the product in watch list")
    public void validate_the_product_in_watch_list() {

        Assert.assertEquals(VD.getProductName(), CM.getTextXpath("productTextFromFav.xpath"));

        throw new io.cucumber.java.PendingException();
    }
    @When("remove the product from watch list")
    public void remove_the_product_from_watch_list() throws InterruptedException {

        CM.normalClickXpath("removeFromMyFavButton.xpath");

        throw new io.cucumber.java.PendingException();
    }
    @Then("validate the watch list")
    public void validate_the_watch_list() throws InterruptedException {

        Assert.assertEquals(CM.getTextXpath("productTextFromFav.xpath"), removeWarning);
        CM.normalClickXpath("removeOkText.xpath");

        Assert.assertEquals(CM.getTextXpath("watchListEmptyWarning.xpath"), wishListEmptyWarning);

        throw new io.cucumber.java.PendingException();
    }
}
