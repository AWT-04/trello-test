package org.fundacionjala.core.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements Browser {

    @Override
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
