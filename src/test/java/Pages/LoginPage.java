package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public WebElement usernameTextbox;
    public WebElement passwordTextbox;
    public WebElement loginButton;
    public WebElement errorMessage;

    //pravimo konstruktor sa driver i wdwait
    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
//getter za username, putanja preko koje ga trazimo
    public WebElement getUsernameTextbox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordTextbox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    //-----------------------------------------------------

    public void insertUsername(String name){
        this.getUsernameTextbox().clear();
        this.getUsernameTextbox().sendKeys(name);
    }
    public void insertPassword(String pass){
        this.getPasswordTextbox().clear();
        this.getPasswordTextbox().sendKeys(pass);
    }
    public void clickOnLoginButton(){
        this.getLoginButton().click();
    }

}
