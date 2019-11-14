package org.fundacionjala.core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebDriverAction webDriverAction;

    public AbstractPage(final WebDriver webDriver, final WebDriverWait webDriverWait,
                        final WebDriverAction webDriverAction) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.webDriverAction = webDriverAction;
    }

}
