package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public WebElement logoutButton;
    public WebElement message;

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".button.secondary.radius"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("flash-messages"));
    }

    //-------------------------------------

    public void clickOnLogoutButton(){
        this.getLogoutButton().click();
    }
}
