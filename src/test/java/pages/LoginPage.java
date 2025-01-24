package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public String Email = "rijofo6757@javnoi.com";
    public String userName = "Era";
    public String mobileNumber = "+91 98765 43210";
    public String password = "eyxTSnAQu8CiBX@";
    public By emailInputBox = By.xpath("//input[@data-qa='login-email']");
    public By passwordInputBox = By.xpath("//input[@placeholder='Password']");
    public By submitButton = By.xpath("//button[normalize-space()='Login']");
    public By errorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

}
