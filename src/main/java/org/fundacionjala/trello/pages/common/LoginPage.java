package org.fundacionjala.trello.pages.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fundacionjala.core.utils.Environment;
import org.fundacionjala.trello.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver webDriver;
    private static final int IMPLICIT_TIME = 15;

    @FindBy(css = "#user")
    private WebElement userField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "#login")
    private WebElement loginButton;

    public void setUserField(final String stringUserField) {
        userField.sendKeys(stringUserField);
    }

    public void setPasswordField(final String stringPasswordField) {
        passwordField.sendKeys(stringPasswordField);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public LoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, TimeUnit.SECONDS);
        webDriver.get("https://trello.com/login");
        PageFactory.initElements(webDriver, this);
    }

    public DashboardPage login(final String username, final String password) {
        userField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardPage(webDriver);
    }

    public DashboardPage loginWithAccount(final String account) {
        String userName = Environment.getInstance().getValue(String.format("credentials.%s.username", account));
        String password = Environment.getInstance().getValue(String.format("credentials.%s.password", account));
        userField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardPage(webDriver);
    }
}
