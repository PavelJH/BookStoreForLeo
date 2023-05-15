package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    @FindBy(xpath = "//button[@class='navbar-toggler']")
    protected WebElement hamburgerMenuButton;
    @FindBy(xpath = "//input[@id='searchBox']")
    protected WebElement searchBoxField;
    @FindBy(xpath = "//span[@id='basic-addon2']")
    protected WebElement searchButton;
    @FindBy(xpath = "//button[@id='login']")
    protected WebElement loginButton;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(loginButton);
    }
    public void clickHamburgerMenuButton(){
        click(hamburgerMenuButton);
    }
    public void searchBoxField(String text){
        searchBoxField.sendKeys(text);
    }
    public void clickSearchButton(){
        click(searchButton);
    }
    public void clickLoginButton(){
        click(loginButton);
    }
}
