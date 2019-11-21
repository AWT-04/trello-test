package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.ISteps;
import org.fundacionjala.trello.pages.card.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.EnumMap;
import java.util.Map;

public class TeamCreationPage {

    //team
    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement nameTeamInputField;

    @FindBy(css = "textarea[placeholder='Our team organizes everything here.']")
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

    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement iLLWeDoThisLater;

    public TeamCreationPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public BoardPage createNewTeam(final Map<TeamFields, String> inputData) {
        EnumMap<TeamFields, ISteps> enumTeamFields = new EnumMap<>(TeamFields.class);
        String nameTeam = inputData.get(TeamFields.NAME);
        String descriptionTeam = inputData.get(TeamFields.DESCRIPTION);
        enumTeamFields.put(TeamFields.NAME, () -> nameTeamInputField.sendKeys(nameTeam));
        enumTeamFields.put(TeamFields.DESCRIPTION, () -> descriptionTeamInputField.sendKeys(descriptionTeam));

        for (TeamFields key : inputData.keySet()) {
            enumTeamFields.get(key).execute();
        }

        createTeamButton.click();
        iLLWeDoThisLater.click();
        return new BoardPage();
    }
}
