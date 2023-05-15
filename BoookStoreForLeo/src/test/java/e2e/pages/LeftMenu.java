package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends PageBase{
    public LeftMenu(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(css = "body > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > span:nth-child(1)")
    WebElement bookStoreApplicationLeftMenu;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement loginLeftMenu;
    @FindBy(xpath = "//span[normalize-space()='Book Store']")
    WebElement bookStoreLeftMenu;
    @FindBy(xpath = "//span[normalize-space()='Profile']")
    WebElement profileLeftMenu;
    @FindBy(xpath = "//span[normalize-space()='Book Store API']")
    WebElement apiBookStoreLeftMenu;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(bookStoreApplicationLeftMenu);
    }

    public void clickLoginLeftMenu(){
        click(loginLeftMenu);
    }
    public void clickBookStoreLeftMenu(){
        try{
            click(bookStoreLeftMenu);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
//            Actions actions = new Actions(driver);
//            actions.keyDown(Keys.COMMAND)
//                    .sendKeys(Keys.SUBTRACT)
//                    .keyUp(Keys.COMMAND)
//                    .build()
//                    .perform();
            click(bookStoreLeftMenu);
        }
    }
    public void clickProfileLeftMenu(){
        try{
            click(profileLeftMenu);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
            click(profileLeftMenu);
        }

    }
    public void clickApiBookStoreLeftMenu(){
        click(apiBookStoreLeftMenu);
    }

}
