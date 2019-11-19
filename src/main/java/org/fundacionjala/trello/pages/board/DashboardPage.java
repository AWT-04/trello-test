package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.common.ISteps;
import org.fundacionjala.trello.pages.team.TeamCreationPage;
import org.fundacionjala.trello.pages.card.BoardPage;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class DashboardPage {
    private WebDriver webDriver;
    private static final int PRIVATE_OUT_IN_SECONDS = 30;
    private static final String WAY_BOARDS_PAGE = "boards page";
    private static final String WAY_ADD_BUTTON = "add button";
    private static final String WAY_BOARD_BUTTON = "board button";
    private static final String WAY_TEAM_ROM_HEADER = "Team from header";
    private static final String WAY_TEAM_FROM_SIDEBAR = "Team from sidebar";

    @FindBy(css = "._2BQG4yPMt5s_hu._2hgn5meZL7bJdx._3r1LXvjBp8zfAv._1iYprMLTeGpyW9")
    private WebElement addButton;
    @FindBy(css = "._2DBw9GxD3tha0R")
    private WebElement addBoardButton;
    @FindBy(css = "._23NUW98LaZfBpQ")
    private WebElement addBoardTitle;
    @FindBy(css = "._2MgouXHqRQDP_5")
    private WebElement createBoard;

    @FindBy(css = ".MEu8ZECLGMLeab")
    private WebElement boardButton;
    @FindBy(css = "._2Z9q8nPvS1HJuT")
    private WebElement findBoard;
    @FindBy(css = "._2sW4tjfiXjrots._3kPuB_9ssJHK2z")
    private WebElement selectBoard;


    @FindBy(css = ".js-open-more")
    private WebElement moreOptions;
    @FindBy(css = ".js-close-board")
    private WebElement closeBoard;
    @FindBy(css = ".negate")
    private WebElement closeButton;
    @FindBy(css = ".js-delete")
    private WebElement deleteBoard;

    // Create board by board button
    @FindBy(css = ".board-tile.mod-add")
    private WebElement createBoardButton;

    // Create board by add button
    @FindBy(css = "#header span[name='add']")
    private WebElement addButtonHeader;
    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement createNewBoardRightPanel;

    // Create board by board button
    @FindBy(css = "#header span[name='board']")
    private WebElement boardButtonHeader;
    @FindBy(css = "button[data-test-id='header-boards-menu-create-board']")
    private WebElement createNewBoardLeftPanel;


    // Team create
    @FindBy(css = "input[data-test-id='header-search-input']")
    private WebElement teamSearchInDashboardInput;

    @FindBy(css = "button[data-test-id='header-create-team-button']")
    private WebElement createTeamButtonHeader;

    @FindBy(css = "button[data-test-id='home-navigation-create-team-button'] span span")
    private WebElement createTeamButtonSidebar;

    public DashboardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BoardCreationPage clickAddBoard(final String wayCreateProject) {
        HashMap<String, ISteps> waysToCreateBoard = new HashMap<>();
        waysToCreateBoard.put(WAY_BOARDS_PAGE, this::createBoardByCentralButton);
        waysToCreateBoard.put(WAY_ADD_BUTTON, this::createBoardByAddButton);
        waysToCreateBoard.put(WAY_BOARD_BUTTON, this::createBoardByBoardButton);
        waysToCreateBoard.get(wayCreateProject).execute();
        return new BoardCreationPage();
    }

    public void createBoardByCentralButton() {
        createBoardButton.click();
    }

    public void createBoardByAddButton() {
        addButtonHeader.click();
        createNewBoardRightPanel.click();
    }

    public void createBoardByBoardButton() {
        boardButtonHeader.click();
        createNewBoardLeftPanel.click();
    }

    @FindBy(css = "span[class='js-board-editing-target board-header-btn-text']")
    private WebElement titleHeader;

    public String getTitleStringHeader() {
        WebDriverWait wait = new WebDriverWait(webDriver, PRIVATE_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.invisibilityOf(titleHeader));
        return titleHeader.getText();
    }

    @FindBy(css = "#permission-level")
    private WebElement permissionHeader;

    public String getPermissionHeader() {
        WebDriverWait wait = new WebDriverWait(webDriver, PRIVATE_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(permissionHeader));
        return permissionHeader.getText().toLowerCase();
    }

    @FindBy(css = "span[class='board-menu-navigation-item-link-icon js-fill-background-preview']")
    private WebElement backgroundColor;

    public String getBackgroundColor() {
        WebDriverWait wait = new WebDriverWait(webDriver, PRIVATE_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(backgroundColor));
        return backgroundColor.getAttribute("style");
    }
    public TeamCreationPage teamClickAddHeader(final String wayCreateTeams) {
        HashMap<String, ISteps> waysToCreateTeam = new HashMap<>();
        waysToCreateTeam.put(WAY_TEAM_ROM_HEADER, this::createTeamFromHeader);
        waysToCreateTeam.put(WAY_TEAM_FROM_SIDEBAR, this::createTeamFromSidebar);
        waysToCreateTeam.get(wayCreateTeams).execute();
        return new TeamCreationPage(webDriver);
    }

    public String getTeamNameDashboard(final String teamNameToVerify) {
        String node = String.format("//h3[@class='boards-page-board-section-header-name' "
                + "and contains(text(),'%s')]", teamNameToVerify);
        WebElement teamTitleInDashboard =  webDriver.findElement(By.xpath(node));
        return teamTitleInDashboard.getText();
    }

    public String getTeamNameSidebar(final String teamNameToVerify) {
        String node = String.format("//span[@data-test-id='home-team-tab-name' "
                + "and contains(text(),'%s')]", teamNameToVerify);
        WebElement teamTitleInSidebar =  webDriver.findElement(By.xpath(node));
        return teamTitleInSidebar.getText();
    }

    public TeamPage getTeamPage() {
        return new TeamPage(webDriver);
    }

    public void createTeamFromHeader() {
        addButtonHeader.click();
        createTeamButtonHeader.click();
    }

    public String searchTeamButtonHeader(final String teamNameToVerify) {
        teamSearchInDashboardInput.click();
        teamSearchInDashboardInput.sendKeys(teamNameToVerify);
        String node = String.format("//a[contains(text(),'%s')]", teamNameToVerify);
        WebElement teamTitleInDashboard =  webDriver.findElement(By.xpath(node));
        return teamTitleInDashboard.getText();
    }

    public void createTeamFromSidebar() {
        createTeamButtonSidebar.click();
    }
}
