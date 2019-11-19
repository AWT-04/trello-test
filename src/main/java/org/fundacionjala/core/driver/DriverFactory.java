package org.fundacionjala.core.driver;

import org.fundacionjala.core.browser.Browser;
import org.fundacionjala.core.browser.Chrome;
import org.fundacionjala.core.browser.ChromeHeadless;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory() {
    }

    private static final Map<DriverType, Supplier<Browser>> BROWSERS = new EnumMap<>(DriverType.class);

    static {
        BROWSERS.put(DriverType.CHROME, Chrome::new);
        BROWSERS.put(DriverType.CHROME_HEADLESS, ChromeHeadless::new);
    }

    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSERS.getOrDefault(driverType, ChromeHeadless::new).get().getBrowser();
    }
}
