package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.common.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Page object of the TeamCreation page from Trello.
 */
public class TeamCreation {
    private WebDriver webDriver;

    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement nameTeamInputField;

    @FindBy(css = "textarea[name='desc']")
    private WebElement descriptionTeamInputField;

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-members")
    private WebElement tabMenbers;

    @FindBy(css = "input.autocomplete-input")
    private WebElement userNameTextField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement buttonInvited;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement createTeamButton;

    @FindBy(css = "button[data-test-id='header-create-menu-button']")
    private WebElement createTeamButtonPlus;

    /**
     * Method for add a members.
     *
     * @param data is type map.
     */
    public void createTeamFromHeader(final Map<String, String> data) {

        HeaderPage headerPage = new HeaderPage(webDriver);
        headerPage.createButtonHeader();
        headerPage.createTeamButtonHeader();
        nameTeamInputField(data.get("Team Name"));
        createTeamButtonHeader(data.get("Team description"));
        createTeamButton();
    }

    private void nameTeamInputField(final String teamName) {
        nameTeamInputField.sendKeys(teamName);
    }

    private void createTeamButtonHeader(final String teamName) {
        nameTeamInputField.sendKeys(teamName);
    }

    private void createTeamButton() {
        createTeamButton.click();
    }

    public TeamCreation(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
