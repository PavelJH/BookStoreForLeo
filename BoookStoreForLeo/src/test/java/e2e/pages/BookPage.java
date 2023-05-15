package e2e.pages;

import e2e.wait.Wait;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.testng.Assert.assertTrue;

public class BookPage extends PageBase{
    public BookPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    BookPage bookPage;
    String bookAddedToYourCollection = "Book added to your collection.";
    @FindBy(xpath = "//div[@class='text-left fullButton']//button[@id='addNewRecordButton']")
    WebElement goBackToBookStoreButton;
    @FindBy(xpath = "//div[@class='text-right fullButton']//button[@id='addNewRecordButton']")
    WebElement addToYourCollectionButton;
    @FindBy(xpath = "//div[@id='website-wrapper']//label[@id='userName-value']")
    WebElement webLinkBookButton;
    public void waitForLoading() {
        wait = new Wait(driver);
        try{
            wait.forVisibility(addToYourCollectionButton);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            wait.forVisibility(addToYourCollectionButton);
        }
    }
    public void clickGoBackToBookStoreButton(){
        click(goBackToBookStoreButton);
    }
    public void clickAddToYourCollectionButton(){
        try{
            click(addToYourCollectionButton);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            click(addToYourCollectionButton);
        }
    }

    public void assertBook(){
        bookPage = new BookPage(app.driver);
        assertTrue(bookPage.getAlertText().contains(bookAddedToYourCollection));
        bookPage.acceptAlert();
    }
}
