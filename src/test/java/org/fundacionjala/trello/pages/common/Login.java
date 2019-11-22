package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.board.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    @FindBy(css = "#user")
    private WebElement userField;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "#login")
    private WebElement loginButton;

    private void setUserName(final String userName) {
        webDriverAction.waitVisibility(userField);
        webDriverAction.setValue(userField, userName);
    }

    private void setPassword(final String password) {
        webDriverAction.waitVisibility(passwordField);
        webDriverAction.setValue(passwordField, password);
    }

    private Dashboard clickLoginButton() {
        webDriverAction.waitVisibility(loginButton);
        webDriverAction.click(loginButton);
        return new Dashboard();
    }

    public Dashboard login(final String username, final String password) {
            webDriver.get("https://trello.com/login");
            this.setUserName(username);
            this.setPassword(password);
            return this.clickLoginButton();
    }
}
