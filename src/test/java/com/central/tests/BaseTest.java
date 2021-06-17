package com.central.tests;

import com.central.pages.HomePage;
import com.central.uicore.DriverFactory;

import com.central.utilis.logger.ILogger;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;

import org.testng.xml.XmlTest;

import java.lang.reflect.Method;


public class BaseTest implements ILogger {


    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String WebUrl = "https://demo.realworld.io/#/";


    public BaseTest() {

    }

    protected ThreadLocal<WebDriver> getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        WebDriver driver = createDriver();
        LOG.info(String.format("creating webdriver %s for %s # %s", driver, method.getDeclaringClass(),
                method.getName()));

    }

    private WebDriver createDriver() {
        if (driver.get() == null) {
            WebDriver _driver = null;
            _driver = DriverFactory.createInstance();

            driver.set(_driver);
            return _driver;
        }
        return null;
    }

    @BeforeMethod(dependsOnMethods = "setUp", alwaysRun = true)
    public void openBaseUrl() {
        WebDriver _driver = driver.get();
        if (_driver != null) {
            openUrl(_driver, WebUrl);
        }

    }

    @Step("opening baseUrl -> {url}")
    private void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }


    @AfterClass(alwaysRun = true)
    public void closeDriver(ITestContext suite, XmlTest test) {
        WebDriver _driver = driver.get();
        _driver.quit();
        LOG.info(String.format("removing webdriver %s for %s", test, driver));
    }


    private String testName = null;



    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestContext context, Method method, ITestResult result) {
        LOG.info(String.format("%s - afterMethod", getClass().getSimpleName()));
        testName = method.getName();
        LOG.info(String.format("Finished Test (%s) execution :: Is execution successful? : %s", testName, result.isSuccess()));

    }


}
