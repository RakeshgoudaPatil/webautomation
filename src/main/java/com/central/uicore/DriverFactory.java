package com.central.uicore;


import com.central.utilis.logger.ILogger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory implements ILogger {

    public static WebDriver createInstance() {

        WebDriver driver = null;
        driver = getChromeDriver(false);

        if (driver == null) {
            LOG.error(String.format("error occurred while webdriver object for app '%s' and browser '%s'"));
        }
        return driver;
    }

    private static WebDriver getChromeDriver(final boolean isMobile) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-fre", "--no-first-run", "--no-default-browser-check", "--enable-sandbox",
                "--session-override", "--start-maximized", "--disable-save-password-bubble", "--disable-extensions",
                "chrome.switches", "--test-type", "--disable-infobars", "--incognito", "--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "/Users/300068019/Documents/projects/personal/SeleniumWebAutomation/src/test/resources/driver/chromedriver");
        LOG.info("creating chrome driver with options => " + chromeOptions.asMap());
        WebDriver wDriver = new ChromeDriver(chromeOptions);
        wDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        wDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return wDriver;
    }
}


