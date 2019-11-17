package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.utils.AbstractPage;
import org.fundacionjala.trello.pages.common.ISteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class Dashboard extends AbstractPage {
    private static final String WAY_BOARDS_PAGE = "boards page";
    private static final String WAY_ADD_BUTTON = "add button";
    private static final String WAY_BOARD_BUTTON = "board button";

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
