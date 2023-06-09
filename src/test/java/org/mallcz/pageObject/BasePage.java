package org.mallcz.pageObject;

import org.apache.log4j.Logger;
import org.mallcz.utilities.PropertiesRead;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {
    static final Logger log = Logger.getLogger(BasePage.class);
    private static final long TIMEOUT = Long.parseLong(PropertiesRead.readFromFrameworkConfig("TIMEOUT"));
    private static WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void setImplicitlyWait() {
        log.info("Timeout is " + TIMEOUT);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    public static void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public static void click(WebElement e, String msg) {
        log.info(msg);
        waitForVisibility(e);
        e.click();
    }

    public String findObject(List<WebElement> e, String msg) {
        log.info(msg);
        for (WebElement element : e) {
            System.out.println("Paragraph text:" + element.getText());
        }
        return "";
    }

    public void clearTxt(WebElement e, String msg) {
        log.info(msg);
        e.clear();
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        log.info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        return e.getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) {
        return e.getText();
    }

    public boolean isDisplayed(WebElement e, String msg) {
        return e.isDisplayed();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public void  scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object last_height = js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        while(true){
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Object new_height = js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            if(last_height == new_height)
                break;

            last_height = new_height;
        }
    }
}
