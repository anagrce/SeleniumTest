package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {

    public String username = "tomsmith";
    
    //public String username=excelReader.getStringData("Login",1,0);
    public String password = "SuperSecretPassword!";
    public String expectedMessage = " You logged into a secure area!";
    public String invalidUsername = "anagrce";
    public String invalidPassword = "12345";



    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }


    @Test(priority = 10)
    public void successfulLogIn() {
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();

        //proverama da li smo se ulogovali tako sto trazimo da li ima logout dumeta
        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());
        //visabilityWait(logoutPage.getMessage());
        //proveramo da li se pojavila poruka sa tekstom da smo ulogovani
        Assert.assertTrue(logoutPage.getMessage().isDisplayed());


    }

    @Test(priority = 20)
    public void invalidUsernameLoggin() {
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();

        //proveramo da li se pojavlia poruka da je pogresan username, nismo se ulogovali
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());


        //proveravamo da li ima logout dugmeta, nema ga, nismo se ulogovali
        boolean check = false;
        try {
            check = logoutPage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);


    }

    @Test(priority = 30)
    public void invalidPasswordLogin() {

        loginPage.insertUsername(username);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        //proveramo da li se pojavlia poruka da je pogresan password, nismo se ulogovali
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());


        //proveravamo da li ima logout dugmeta, nema ga, nismo se ulogovali
        boolean check = false;
        try {
            check = logoutPage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);


    }

    @Test(priority = 40)
    public void invaliUsernameInavlidPassword() {
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        loginPage.clickOnLoginButton();


        //proveramo da li se pojavlia poruka da je pogresan username, jer njega prvo ulovi da je pogresan, nismo se ulogovali
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());


        //proveravamo da li ima logout dugmeta, nema ga, nismo se ulogovali
        boolean check = false;
        try {
            check = logoutPage.getLogoutButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);




    }

   // @AfterMethod


}
