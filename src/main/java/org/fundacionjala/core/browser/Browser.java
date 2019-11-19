package org.fundacionjala.core.browser;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface Browser {
    WebDriver getBrowser() throws MalformedURLException;
}
