package org.fundacionjala.core.ui.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This abstract class implements methods to use in SauceLabs and Browser Stack connection.
 */
public abstract class RemoteBrowser implements Browser {
    protected static final Environment ENVIRONMENT = Environment.getInstance();
    protected static final String RESOLUTION = "resolution";
    private final String url;
    private static final Logger LOGGER = LogManager.getLogger(RemoteBrowser.class);

    /**
     * This method setCapabilities the remote browser.
     *
     * @return DesiredCapabilities instance.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * This is the constructor.
     *
     * @param url url connection.
     */
    public RemoteBrowser(final String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
