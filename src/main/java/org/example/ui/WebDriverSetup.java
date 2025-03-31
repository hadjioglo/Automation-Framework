package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--ignore-ssl-errors");
                System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void waitForElement(String elementId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
        element.click();
    }
}
