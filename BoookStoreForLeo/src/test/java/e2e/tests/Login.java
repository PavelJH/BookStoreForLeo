package e2e.tests;

import com.github.javafaker.Faker;
import e2e.helpers.CommonHelpers;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class Login extends TestBase{
    LoginPage loginPage;
    ProfilePage profilePage;

    Faker faker = new Faker();

    @Test
    public void LoginWithValidUserNameAndPassword() {
        loginPage = new LoginPage(app.driver);
        profilePage = new ProfilePage(app.driver);

        loginPage.waitForLoading();
        loginPage.loginFillField(userName);
        loginPage.passwordFillField(password);
        loginPage.clickLoginButton();
        profilePage.waitForLoading();
        loginPage.getLogOutButton().isDisplayed();
    }

    @Test
    public void LoginWithValidUserNameAndInValidPassword(){
        loginPage = new LoginPage(app.driver);
        profilePage = new ProfilePage(app.driver);
        loginPage.waitForLoading();
        loginPage.loginFillField(userName);
        loginPage.passwordFillField(faker.internet().password());
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
        loginPage.getInvalidUserNameOrPassword().isDisplayed();
    }
    @Test
    public void LoginWithInValidUserNameAndValidPassword(){
        loginPage = new LoginPage(app.driver);
        profilePage = new ProfilePage(app.driver);
        loginPage.waitForLoading();
        loginPage.loginFillField(faker.name().username());
        loginPage.passwordFillField(password);
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
        loginPage.getInvalidUserNameOrPassword().isDisplayed();
    }
    @Test
    public void LoginWithInValidUserNameAndInValidPassword(){
        loginPage = new LoginPage(app.driver);
        profilePage = new ProfilePage(app.driver);
        loginPage.waitForLoading();
        loginPage.loginFillField(faker.name().username());
        loginPage.passwordFillField(faker.internet().password());
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
        loginPage.getInvalidUserNameOrPassword().isDisplayed();
    }

    @Test
    public void logOut(){
        loginPage = new LoginPage(app.driver);
        profilePage = new ProfilePage(app.driver);

        loginPage.waitForLoading();
        loginPage.loginFillField(userName);
        loginPage.passwordFillField(password);
        loginPage.clickLoginButton();
        profilePage.waitForLoading();
        loginPage.getLogOutButton().isDisplayed();
        loginPage.clickLogOutButton();
        loginPage.getLoginWelcomeInBookStore().isDisplayed();
    }
    @Test
    public void tryLogInWithoutData(){
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.loginFillField("");
        loginPage.passwordFillField("");
        loginPage.clickLoginButton();
        loginPage.getLoginWelcomeInBookStore().isDisplayed();
        }
    }






