import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlerts {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // 1. JavaScript Alert
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

            Alert alert = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent()
            );

            System.out.println("Alert message: " + alert.getText());

            alert.accept();

            System.out.println("Alert handled successfully.");


            // 2. JavaScript Confirmation
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

            alert = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent()
            );

            System.out.println("Confirmation message: " + alert.getText());

            // Click OK
            alert.accept();

            System.out.println("Confirmation handled with OK.");


            // 3. JavaScript Prompt
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

            alert = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent()
            );

            System.out.println("Prompt message: " + alert.getText());

            // Enter text
            alert.sendKeys("Selenium Java");

            // Click OK
            alert.accept();

            System.out.println("Prompt handled successfully.");

        } finally {

            driver.quit();
        }
    }
}