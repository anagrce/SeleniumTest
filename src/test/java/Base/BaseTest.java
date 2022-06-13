package Base;

import Pages.LoginPage;
import Pages.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public ExcelReader excelReader;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait= new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage= new LoginPage(driver, wdwait);
        logoutPage= new LogoutPage(driver,wdwait);

        //dodali putanju do nase excel tabele koja je u racunaru i morali smo dodti i IOException
        excelReader= new ExcelReader("C:\\Users\\TaraG\\Desktop\\Test.xlsx");

    }
//metoda za cekanje vidljivosti WebElementa
    public void visabilityWait(WebElement element){

        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    //metoda za cekanje da Web Elemnt moze da se klikne
    public void clickabilityWait(WebElement element){

        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //metoda za skrolovanje
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true) ;",element );

    }

    @AfterClass
    public void tearDown(){
        //driver.close();
       // driver.quit();
    }

}
