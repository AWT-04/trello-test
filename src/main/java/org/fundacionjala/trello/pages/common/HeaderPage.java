package org.fundacionjala.trello.pages.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author lazaro on 11/12/2019.
 * trello-tests.
 */
public class HeaderPage {
    private WebDriver webDriver;

    @FindBy(css = "button[class='._2ZNy4w8Nfa58d1' and data-test-id='header-create-menu-button']")
    private WebElement createButtonHeader;
    @FindBy(css = "button[data-test-id='header-create-business-team-button']")
    private WebElement createTeamButtonHeader;

    public void createButtonHeader() {
        createButtonHeader.click();
    }

    public void createTeamButtonHeader() {
        createTeamButtonHeader.click();
    }
    public HeaderPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
