package org.fundacionjala.trello.pages.list;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListAction extends AbstractPage {
    @FindBy(css = ".js-close-list")
    private WebElement archiveListButton;

    public void archiveList() {
        webDriverAction.waitVisibility(archiveListButton);
        webDriverAction.click(archiveListButton);
    }
}
