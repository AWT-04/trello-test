package org.fundacionjala.trello.pages;

import org.fundacionjala.core.utils.AbstractPage;
import org.fundacionjala.trello.pages.common.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigator extends AbstractPage {

    @FindBy(css = "a[href='/login?returnUrl=%2F']")
    private WebElement linkInit;

    public Login clickInitLink() {
        webDriverAction.click(linkInit);
        return new Login();
    }

    public void goToPersonalPage(final String user) {
        By homeLeftSideBar = By.cssSelector(".home-left-sidebar-container");
        if (!webDriverAction.isExistingSelector(homeLeftSideBar)) {
            webDriver.navigate().to("https://trello.com/" + user + "/boards");
        }
    }
}
