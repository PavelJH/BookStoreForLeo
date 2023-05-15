package e2e.helpers;

import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInHelper extends CommonHelpers{
    public LogInHelper(WebDriver driver) {
        super(driver);
    }

    LoginPage loginPage;

    public void logInAutomation(){
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.loginFillField(userName);
        loginPage.passwordFillField(password);
        loginPage.clickLoginButton();
    }


}
