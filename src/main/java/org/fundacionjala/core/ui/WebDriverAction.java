package org.fundacionjala.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriverAction(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void setValue(final WebElement element, final String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public String getValue(final By element) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
        return webDriver.findElement(element).getText();
    }

    public void click(final WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(final By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitVisibility(final WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibility(final By element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isExistingSelector(final By element) {
        try {
            webDriver.findElement(element);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
