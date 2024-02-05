package amzon.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

    private WebDriver driver;
    private static Actions actions;

    public ActionsClass(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public static void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    public void releaseAfterClickAndHold(WebElement element) {
        actions.clickAndHold(element).release().perform();
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    //contextClick=right click
    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void sendKeys(WebElement element, String keys) {
        actions.sendKeys(element, keys).perform();
    }

    // Send keys with modifier keys (e.g., Ctrl+A)
    public void sendKeysWithModifiers(WebElement element, Keys modifierKey, String keys) {
        actions.keyDown(modifierKey).sendKeys(element, keys).keyUp(modifierKey).perform();
    }
    
    
    
    public void keysUp(WebElement element, CharSequence key) {
        actions.sendKeys(element, key).keyUp(Keys.CONTROL).perform();
    }

    public void keysDown(WebElement element, CharSequence key) {
        actions.sendKeys(element, key).keyDown(Keys.CONTROL).perform();
    }
}
