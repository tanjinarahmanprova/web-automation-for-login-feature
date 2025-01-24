package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static utilities.BrowserSetup.getBrowser;

public class BasePage {
    public WebElement getElement(By locator) {
        WebDriverWait wait = new  WebDriverWait(getBrowser(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Click on element
    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public String getText(By locator){
        return getElement(locator).getText();
    }


    // Writes on a element
    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    // checks if element is selected or not
    public Boolean selectedStatus(By locator){
        return getElement(locator).isSelected();
    }

    // checks if element is displayed or not
    public Boolean displayStatus(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (TimeoutException e){
            return false;
        }
    }

    //checks if element is enable or disable
    public Boolean enableStatus(By locator){
        return getElement(locator).isEnabled();
    }

    //clear element
    public void clearElement(By locator){
        getElement(locator).clear();
    }

    public Alert getAlert(){
        WebDriverWait wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //add screenshot
    public void addScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getBrowser()).getScreenshotAs(OutputType.BYTES)));
    }
}
