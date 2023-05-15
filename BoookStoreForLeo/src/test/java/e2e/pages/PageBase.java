package e2e.pages;

import e2e.tests.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PageBase extends TestBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void selectOption(String optionName, WebElement selectElement) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionName);
    }

    public void checkNotExistingOption(String expectedNameOption, WebElement selectElement) {
        Select select = new Select(selectElement);
        for (WebElement option : select.getOptions()) {
            Assert.assertNotEquals(option.getText(), expectedNameOption);
        }
    }

    public void fillField(WebElement field) {
        click(field);
        field.clear();
        field.sendKeys();
    }

    public void checkItemText(WebElement element, String expectedText, String err) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, err);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAlertOkButton() {
        driver.switchTo().alert().accept();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }


}
