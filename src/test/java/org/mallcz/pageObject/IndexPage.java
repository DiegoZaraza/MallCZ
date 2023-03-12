package org.mallcz.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"cms-carousel-a\"]")
    List<WebElement> carouselA;
    @FindBy(xpath = "//div[@class=\"cms-carousel-b\"]")
    List<WebElement> carouselB;

    @FindBy(xpath = "//div[@class=\"top-icons\"]")
    List<WebElement> carouselTopIcons;

    @FindBy(xpath = "//span[@class=\"rounded-button__wrapper__slot\"]")
    static
    List<WebElement> cookies;

    @FindBy(xpath = "//button[@data-testid=\"close-button\"]")
            static
    List<WebElement> closeButton;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static void clickCookies() {
        //click(cookies.get(1), "");
        //click(closeButton.get(1), "");
        //refreshPage();
    }
    public int countArticles(String value) throws InterruptedException {
        int quantity = 0;
        scrollDown();
        System.out.println("Carrusel A : " + carouselA.size());
        System.out.println("Carrusel B : " + carouselB.size());
        System.out.println("Carrusel Icon : " + carouselTopIcons.size());
        for(WebElement article: carouselTopIcons){
            quantity = article.findElements(By.tagName("li")).size();
            System.out.println(quantity);
        }
        return quantity;
    }
}
