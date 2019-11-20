package org.fundacionjala.core.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStack extends RemoteConnection implements Browser {
    private static final String URL = String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub",
            ENVIRONMENT.getValue("$['browserstack']['user']"),
            ENVIRONMENT.getValue("$['browserstack']['key']"));
    private static final String BROWSERNAME = "browserName";
    private static final String DEVICE = "device";
    private static final String REALMOBILE = "realMobile";
    private static final String OS_VERSION = "os_version";

    public BrowserStack() {
        super(URL);
    }

    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSERNAME, ENVIRONMENT.getValue("$['browserstack']['browserName']"));
        capabilities.setCapability(DEVICE, ENVIRONMENT.getValue("$['browserstack']['device']"));
        capabilities.setCapability(REALMOBILE, ENVIRONMENT.getValue("$['browserstack']['realMobile']"));
        capabilities.setCapability(OS_VERSION, ENVIRONMENT.getValue("$['browserstack']['os_version']"));
        return capabilities;
    }
}
