
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\RESHMILearnings\\Automation\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());


        WebElement switchWindow = driver.findElement(By.linkText("Switch Window"));
        Actions action = new Actions(driver);
        action.moveToElement(switchWindow);
        switchWindow.click();
        driver.findElement(By.id("new-tab-button")).click();
        Thread.sleep(500);
        String parentWindow = driver.getWindowHandle();

        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
        }
        System.out.println(driver.getTitle());
        Thread.sleep(500);
        driver.close();
        driver.switchTo().window(parentWindow);


        Thread.sleep(1000);


        driver.quit();
    }
}
