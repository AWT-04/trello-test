package org.fundacionjala.core.utils;

import org.fundacionjala.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebDriverAction webDriverAction;

    protected AbstractPage() {
        this.webDriver = DriverManager.getInstance().getDriver();
        this.webDriverWait = DriverManager.getInstance().getWait();
        this.webDriverAction = new WebDriverAction(webDriver, webDriverWait);
        PageFactory.initElements(this.webDriver, this);
    }

}
