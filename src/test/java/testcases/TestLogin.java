package testcases;

import com.beust.ah.A;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.BrowserSetup;
import utilities.DataSet;

public class TestLogin extends BrowserSetup {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void loadLoginPage(){
        getBrowser().get(homePage.url);
        homePage.clickOnElement(homePage.loginButton);
    }

    @Test(priority = 0, description = "User login with valid credentials")
    @Description("Test added using allure: User login with valid credentials")
    @Epic("Web interface")
    @Feature("Essential features")
    @Story("Authentication")
    public void testLoginWithValidCredentials() {
        loginPage.addScreenshot("Before adding data");
        loginPage.writeOnElement(loginPage.emailInputBox,loginPage.Email);
        loginPage.writeOnElement(loginPage.passwordInputBox,loginPage.password);
        loginPage.addScreenshot("After adding data");
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After login");
        Assert.assertTrue(homePage.displayStatus(homePage.logoutButton));
        homePage.clickOnElement(homePage.logoutButton);
    }

    @Test
    public void testLoginWithInvalidPassword() {
        loginPage.writeOnElement(loginPage.emailInputBox,loginPage.Email);
        loginPage.writeOnElement(loginPage.passwordInputBox,"hysa@y&24$tf");
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        Assert.assertEquals(loginPage.getText(loginPage.errorMessage), "Your email or password is incorrect!" );
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithInvalidEmail() {
        loginPage.writeOnElement(loginPage.emailInputBox,"eravrwi216@hyd.com");
        loginPage.writeOnElement(loginPage.passwordInputBox,loginPage.password);
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        Assert.assertEquals(loginPage.getText(loginPage.errorMessage), "Your email or password is incorrect!" );
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithInvalidEmailAndPassword() {
        loginPage.writeOnElement(loginPage.emailInputBox, "frhdrb23@frs.com");
        loginPage.writeOnElement(loginPage.passwordInputBox,"yacf#hg%rd$k");
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        Assert.assertEquals(loginPage.getText(loginPage.errorMessage), "Your email or password is incorrect!" );
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithInvalidEmailFormat() {
        loginPage.writeOnElement(loginPage.emailInputBox,"eravrwi216@");
        loginPage.writeOnElement(loginPage.passwordInputBox,loginPage.password);
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        String errorMassageValidation =loginPage.getElement(loginPage.emailInputBox).getAttribute("validationMessage");
//        System.out.println(errorMassageValidation);
        Assert.assertTrue(errorMassageValidation.contains("Please"), errorMassageValidation);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithoutEmail() {
        loginPage.writeOnElement(loginPage.passwordInputBox,loginPage.password);
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        String errorMassageValidation =loginPage.getElement(loginPage.emailInputBox).getAttribute("validationMessage");
//        System.out.println(errorMassageValidation);
        Assert.assertTrue(errorMassageValidation.contains("Please"), errorMassageValidation);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.writeOnElement(loginPage.emailInputBox,loginPage.Email);
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        String errorMassageValidation =loginPage.getElement(loginPage.passwordInputBox).getAttribute("validationMessage");
//        System.out.println(errorMassageValidation);
        Assert.assertTrue(errorMassageValidation.contains("Please"), errorMassageValidation);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }


    @Test
    public void testLoginWithoutEmailAndPassword() {
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        String errorMassageValidation =loginPage.getElement(loginPage.emailInputBox).getAttribute("validationMessage");
//        System.out.println(errorMassageValidation);
        Assert.assertTrue(errorMassageValidation.contains("Please"), errorMassageValidation);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test(dataProvider = "invalidLoginCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String email, String password, String errorMessage) {
        loginPage.writeOnElement(loginPage.emailInputBox, email);
        loginPage.writeOnElement(loginPage.passwordInputBox,password);
        loginPage.clickOnElement(loginPage.submitButton);
        loginPage.addScreenshot("After tapped on login button");
        //Assert.assertEquals(loginPage.getText(loginPage.errorMessage), errorMessage  );
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }
}
