package com.hepsiburada.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
        if (browser == null) {
            return new ChromeDriver();
        }
        switch (browser)
        {
            case "EDGE":
                return new EdgeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}
