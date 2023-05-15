package e2e.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextReduction extends CommonHelpers{
    public TextReduction(WebDriver driver) {
        super(driver);
    }
    Actions actions;
    public void zoomOut() {
        actions = new Actions(app.driver);
        actions.keyDown(Keys.COMMAND).sendKeys(Keys.SUBTRACT).keyUp(Keys.COMMAND).build().perform();
    }
    public void scrollElementIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
        }
    }

}
