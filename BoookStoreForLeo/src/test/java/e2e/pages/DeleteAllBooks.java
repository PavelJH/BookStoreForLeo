package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAllBooks extends PageBase{
    public DeleteAllBooks(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    @FindBy(xpath = "//div[@class='modal-body']")
    WebElement doYouWantToDeleteAllBooksText;
    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    WebElement okDeleteAllBooks;
    @FindBy(xpath = "//button[@id='closeSmallModal-cancel']")
    WebElement cancelDeleteAllBooks;
    @FindBy(xpath = "//span[@aria-hidden='true']")
    WebElement closeWindowsDeleteAllBooks;

    public void clickOkDeleteAllBooks(){
        click(okDeleteAllBooks);
    }
    public void clickCancelDeleteAllBooks(){
        click(cancelDeleteAllBooks);
    }
    public void clickCloseWindowsDeleteAllBooks(){
        click(closeWindowsDeleteAllBooks);
    }
    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(doYouWantToDeleteAllBooksText);
    }
}
