package org.fundacionjala.trello.pages.team;

import org.fundacionjala.trello.pages.card.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author lazaro on 11/14/2019.
 * trello-tests.
 */
public class TeamPage {
    private WebDriver webDriver;

    //team
    @FindBy(xpath = "//span[@data-test-id='home-team-tab-name' and text()='']")
    private WebElement teamNameSidebar;

    @FindBy(css = "h1[class='u-inline']")
    private WebElement nameTeamTitle;

    @FindBy(css = "span[name='house']")
    private WebElement dashboardHeaderButton;

    @FindBy(css = "div[class='tabbed-pane-header-details-content markeddown'] p")
    private WebElement nameTeamDesc;

    public TeamPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BoardPage validateTeamValues() {

        return new BoardPage(webDriver);
    }

    public String getNameTeam() {
        return nameTeamTitle.getText();
    }

    public String getDescriptionTeam() {
        return nameTeamDesc.getText();
    }

    public void dashboardHeaderButton() {
        dashboardHeaderButton.click();
    }

    public void teamNameSidebar() {
        teamNameSidebar.getText();
    }

    public String teamNameTitle() {
        return webDriver.getTitle();
    }
    public String teamNameUrl() {
        return webDriver.getCurrentUrl();
    }
}
