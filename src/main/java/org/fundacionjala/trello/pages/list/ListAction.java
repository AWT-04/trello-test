package org.fundacionjala.trello.pages.list;

import org.fundacionjala.core.utils.AbstractPage;
import org.fundacionjala.core.utils.WebDriverAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListAction extends AbstractPage {
    @FindBy(css = ".js-close-list")
    private WebElement archiveListButton;

    public ListAction(WebDriver webDriver, WebDriverWait webDriverWait, WebDriverAction webDriverAction) {
        super(webDriver, webDriverWait, webDriverAction);
    }

    public void archiveList() {
        webDriverAction.waitVisibility(archiveListButton);
        webDriverAction.click(archiveListButton);
    }
}