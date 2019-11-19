package org.fundacionjala.core.browser;

import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class RemoteConnection implements Browser {
    protected static final Environment ENVIRONMENT = Environment.getInstance();
    private final String url;
    private static final Logger LOGGER = LogManager.getLogger(RemoteConnection.class);

    abstract DesiredCapabilities setCapabilities();

    public RemoteConnection(final String url) {
        this.url = url;
    }

    @Override
    public WebDriver getBrowser() {
        WebDriver remoteBrowser = null;
        try {
            remoteBrowser = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return remoteBrowser;
    }
}
