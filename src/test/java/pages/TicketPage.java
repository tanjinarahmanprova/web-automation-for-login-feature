package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserSetup;

import java.util.List;

public class TicketPage extends BrowserSetup{
    @Test
    public void dateSelection() throws InterruptedException {
        getBrowser().get("https://eticket.railway.gov.bd/");
        Thread.sleep(2000);
//        getBrowser().findElement(By.className("agree-btn ng-tns-c47-2")).click();
        getBrowser().findElement(By.xpath("//input[@id='doj']")).click();
        List<WebElement> validDate = getBrowser().findElements(By.xpath("//td/a"));
//        validDate.get(1).click();
        for(WebElement element: validDate){
            if(element.getText().equals("6")){
                element.click();
            }
        }
        Thread.sleep(3000);
    }
}
