package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    @FindBy(xpath = "//div[@class='text-center button']//button[@id='submit']")
    WebElement gotoBookStore;
    @FindBy(xpath = "//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']")
    WebElement logOutButton;
    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement searchBox;
    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElement goToBookStoreButton;
    @FindBy(xpath = "//div[@class='text-center button']//button[@id='submit']")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//div[@class='text-right button di']//button[@id='submit']")
    WebElement deleteAllBooksButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(gotoBookStore);
    }
    public void clickLogOutBoxButton(){
        click(logOutButton);
    }
    public void clickGoToBooksStoreButton(){
        click(goToBookStoreButton);
    }
    public void clickDeleteAccountButton(){
        click(deleteAccountButton);
    }
    public void clickDeleteAllBooksButton(){
        try{
            click(deleteAllBooksButton);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            click(deleteAllBooksButton);
        }

    }
}
