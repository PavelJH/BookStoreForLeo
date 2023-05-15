package e2e.pages;

import e2e.wait.Wait;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Getter
public class BookStore extends PageBase{
    public BookStore(WebDriver driver) {
        super(driver);
    }
    Wait wait;



    @FindBy(xpath = "//div[@class='-next']//button[@type='button']")
    WebElement nextBookStorePageButton;
    @FindBy(xpath = "//div[@class='-previous']//button[@type='button']")
    WebElement previousBookStorePageButton;
    @FindBy(xpath = "//div[contains(text(),'Image')]")
    WebElement pageTextCheck;
    @FindBy(xpath = "//span[contains(text(),'Page')]")
    WebElement titleBoxUp;

    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    WebElement firstBook;

    @FindBy(css = "body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    WebElement secondBook;

    @FindBy(xpath = "//a[normalize-space()='Designing Evolvable Web APIs with ASP.NET']")
    WebElement thirdBook;

    @FindBy(xpath = "(//a[normalize-space()='Speaking JavaScript'])[1]")
    WebElement fourthBook;

    @FindBy(xpath = "(//a[normalize-space()='You Don't Know JS'])[1]")
    WebElement fifthBook;

    @FindBy(xpath = "//a[normalize-space()='Programming JavaScript Applications']")
    WebElement sixthBook;

    @FindBy(xpath = "//a[normalize-space()='Eloquent JavaScript, Second Edition']")
    WebElement seventhBook;

    @FindBy(css = "a[href='/books?book=9781593277574']")
    WebElement eightBook;

    @FindBy(xpath = "//select[@aria-label='rows per page']")
    WebElement rowSelect;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    WebElement checkCountRows;

    @FindBy(xpath = "//input[@value]")
    WebElement numberPageCheck;
    @FindBy(xpath = "//a[@id='close-fixedban']")
    WebElement commercial;
    @FindBy(xpath = "//div[contains(text(),'Title')]")
    WebElement titleHeader;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(pageTextCheck);
    }
    public void waitForLoadingChoseRows() {
        wait = new Wait(driver);
        wait.forVisibility(rowSelect);
    }

    public void clickNextBookStorePageButton(){
//        tryCatch
        click(nextBookStorePageButton);
    }
    public void clickPreviousBookStorePageButton(){
        click(previousBookStorePageButton);
    }
    public void clickBook(WebElement elementNumberBook){
        try{
            click(elementNumberBook);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
//          click(elementNumberBook);
        }
    }
    public void clickTitleBoxUp(){
        click(titleBoxUp);
    }
    public void choseRows(String rows) {
        try{
            selectOption(rows, rowSelect);
        }catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)", "");
            selectOption(rows, rowSelect);
    }
    }
    public void checkCountRows(Number expectedCountRow) {
        Number actualCountRow = driver.findElements(By.xpath("//div[contains(@class, 'rt-tbody')]//div[contains(@class, 'rt-tr-group')]")).size();
        Assert.assertEquals(actualCountRow, expectedCountRow);
    }
    public void checkNumberPage(String numberPage){
        Assert.assertEquals(numberPageCheck.getAttribute("value"), numberPage);
    }
    public List<WebElement> getElements() {
        return app.driver.findElements(By.xpath("//span[@class='mr-2']//a"));
    }

    public List<String> getElementsText() {
        return getElements().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickToElement(String text) {
        getElements().stream().filter(webelement -> Objects.equals(webelement.getText(), text))
                .findFirst()
                .orElseThrow().click();
    }
    public void doubleClickTittleHeader(){
        click(titleHeader);
        click(titleHeader);
    }
}

