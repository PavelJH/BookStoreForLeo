package e2e.helpers;


import e2e.pages.LoginPage;
import e2e.tests.TestBase;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
@Getter

public class CommonHelpers extends TestBase{
    WebDriver driver;
    String userName = "JH";
    String password = "Jeffry080%";

    public CommonHelpers(WebDriver driver) {
        this.driver = driver;
    }
}
