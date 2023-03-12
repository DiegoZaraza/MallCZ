package org.mallcz.steps;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.mallcz.pageObject.BasePage;
import org.mallcz.pageObject.IndexPage;
import org.mallcz.utilities.PropertiesRead;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("URL");
    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private IndexPage indexPage;
    private int quantity;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = WebDriverManager.chromedriver().create();
        indexPage = new IndexPage(webDriver);
        softAssertions = new SoftAssertions();
        webDriver.manage().window().maximize();
        BasePage.setImplicitlyWait();
    }
    @Given("Navigate to mall.cz")
    public void navigateToMallCz() {
        BasePage.setImplicitlyWait();
        webDriver.get(PAGE);
        IndexPage.clickCookies();
    }
    @When("Enter on the page find carousel {string}")
    public void enterOnThePageFindCarousel(String arg0) throws InterruptedException {
        quantity = indexPage.countArticles(arg0);
    }
    @Then("Validate the quantity of elements is {string}")
    public void validateTheQuantityOfElementsIs(String arg0) {
        int value = Integer.parseInt(arg0);
        softAssertions.assertThat(quantity).isEqualTo(value);
    }
    @After
    public void end() {
        softAssertions.assertAll();
        if (webDriver != null) {
   //         webDriver.quit();
        }
    }
}
