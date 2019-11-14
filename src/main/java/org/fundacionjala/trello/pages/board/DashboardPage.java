package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.common.ISteps;
import org.fundacionjala.trello.pages.card.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class DashboardPage {
    private WebDriver webDriver;
    private static final String WAY_BOARDS_PAGE = "boards page";
    private static final String WAY_ADD_BUTTON = "add button";
    private static final String WAY_BOARD_BUTTON = "board button";

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

    public DashboardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BoardPage createBoard(final String nameBoard) {
        addButton.click();
        addBoardButton.click();
        addBoardTitle.sendKeys(nameBoard);
        createBoard.click();
        return new BoardPage(webDriver);
    }

    public BoardPage searchBoard(final String nameBoard) {
        boardButton.click();
        findBoard.sendKeys(nameBoard);
        selectBoard.click();
        return new BoardPage(webDriver);
    }

    public void deleteBoard(final String nameBoard) {
        searchBoard(nameBoard);
        moreOptions.click();
        closeBoard.click();
        closeButton.click();
        deleteBoard.click();
        closeButton.click();
    }

    public BoardCreationPage clickAddBoard(final String wayCreateProject) {
        HashMap<String, ISteps> waysToCreateBoard = new HashMap<>();
        waysToCreateBoard.put(WAY_BOARDS_PAGE, this::createBoardByCentralButton);
        waysToCreateBoard.put(WAY_ADD_BUTTON, this::createBoardByAddButton);
        waysToCreateBoard.put(WAY_BOARD_BUTTON, this::createBoardByBoardButton);
        waysToCreateBoard.get(wayCreateProject).execute();
        return new BoardCreationPage(webDriver);
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
}
