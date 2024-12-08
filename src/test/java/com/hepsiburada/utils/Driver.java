package com.hepsiburada.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static WebDriver driver;

      public static WebDriver getDriver() {

        if(driver==null) {
            String browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "CHROME";
            }
            switch (browser) {
                case "EDGE":
                    driver = new EdgeDriver();
                    break;
                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    driver = new ChromeDriver(options);
                    break;
            }
            return driver;
        }else {
            return driver;
        }
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}

