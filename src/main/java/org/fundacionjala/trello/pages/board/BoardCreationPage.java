package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.card.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BoardCreationPage {
    private WebDriver webDriver;
    private String titleString;
    private String privacyString;
    private String backgroundString;
    private static final Map<String, String> BACKGROUNDCOLORS;

    static {
        Map<String, String> backgroundColors = new HashMap<>();
        backgroundColors.put("blue", "rgb(0, 121, 191)");
        backgroundColors.put("orange", "rgb(210, 144, 52)");
        backgroundColors.put("green", "rgb(81, 152, 57)");
        backgroundColors.put("red", "rgb(176, 70, 50)");
        backgroundColors.put("null", "null");
        BACKGROUNDCOLORS = Collections.unmodifiableMap(backgroundColors);
    }


    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement addBoardTitle;

    public BoardCreationPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement createBoardButton;


    public String getTitleString() {
        return titleString;
    }

    public String getPrivacyString() {
        return privacyString;
    }

    public String getBackgroundString() {
        return BACKGROUNDCOLORS.get(backgroundString == null ? "null" : backgroundString.toLowerCase());
    }

    public BoardPage createNewBoard(final Map<BoardFields, String> inputData) {
        EnumMap<BoardFields, ISteps> enumMap = new EnumMap<>(BoardFields.class);
        titleString = inputData.get(BoardFields.TITLE);
        enumMap.put(BoardFields.TITLE, () -> addBoardTitle.sendKeys(titleString));
        createBoardButton.click();
        return new BoardPage(webDriver);
    }
}
