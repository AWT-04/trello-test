package org.fundacionjala.core.browser;

import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserStack extends RemoteConnection implements Browser {
    private static final String URL = String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub",
            ENVIRONMENT.getValue("$['browserstack']['user']"),
            ENVIRONMENT.getValue("$['browserstack']['key']"));
    private static final String BROWSER = "browser";
    private static final String BROWSER_VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";

    public BrowserStack() {
        super(URL);
    }

    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(OS, ENVIRONMENT.getValue("$['browserstack']['os']"));
        capabilities.setCapability(OS_VERSION, ENVIRONMENT.getValue("$['browserstack']['os_version']"));
        capabilities.setCapability(BROWSER, ENVIRONMENT.getValue("$['browserstack']['browser']"));
        capabilities.setCapability(BROWSER_VERSION, ENVIRONMENT.getValue("$['browserstack']['browser_version']"));
        return capabilities;
    }
}
