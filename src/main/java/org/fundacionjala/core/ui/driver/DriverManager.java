package org.fundacionjala.core.ui.driver;

import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class DriverManager {

    private WebDriver browser;
    private WebDriverWait webDriverWait;
    private static final int TIME_OUT_IN_SECONDS = 30;
    private static final int TIME = 15;
    private static DriverManager ourInstance = new DriverManager();

    public static DriverManager getInstance() {
        return ourInstance;
    }

    private DriverManager() {
        String browserString = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
        browser = DriverFactory.getDriverManager(DriverType.valueOf(browserString));
        browser.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(browser, TIME_OUT_IN_SECONDS);
    }

    public WebDriver getDriver() {
        return browser;
    }

    public WebDriverWait getWait() {
        return webDriverWait;
    }

}
