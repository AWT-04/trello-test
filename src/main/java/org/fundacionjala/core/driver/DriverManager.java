package org.fundacionjala.core.driver;

import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final class DriverManager {

    private WebDriver browser;
    private WebDriverWait webDriverWait;
    private static final int TIME_OUT_IN_SECONDS = 30;
    private static final int TIME = 15;
    private static DriverManager ourInstance;

    static {
        try {
            ourInstance = new DriverManager();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static DriverManager getInstance() {
        return ourInstance;
    }

    private DriverManager() throws MalformedURLException {
        String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
        this.browser = DriverFactory.getDriverManager(DriverType.valueOf(browser));
        this.browser.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(this.browser, TIME_OUT_IN_SECONDS);
        this.browser.get("https://trello.com/login");
    }

    public WebDriver getDriver() {
        return browser;
    }

    public WebDriverWait getWait() {
        return webDriverWait;
    }

}
