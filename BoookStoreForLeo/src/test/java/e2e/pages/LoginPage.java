package e2e.pages;

import e2e.tests.TestBase;
import e2e.wait.Wait;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//form[@id='userForm']//div//h5")
    WebElement loginWelcomeInBookStore;
    @FindBy(xpath = "//input[@id='userName']")
    WebElement loginFill;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordFill;
    @FindBy(xpath = "//button[@id='login']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@id='newUser']")
    WebElement newUserButton;
    @FindBy(xpath = "//p[@id='name']")
    WebElement InvalidUserNameOrPassword;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement logOutButton;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(loginWelcomeInBookStore);
    }

    public void loginFillField(String loginUserName){
        loginFill.sendKeys(loginUserName);
    }
    public void passwordFillField(String passwordUser){
        passwordFill.sendKeys(passwordUser);
    }
    public void clickLoginButton(){
        click(loginButton);
    }
    public void clickNewUserButton(){
        click(newUserButton);
    }
    public void clickLogOutButton(){
        logOutButton.click();
    }

}
