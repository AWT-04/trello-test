package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BoardCreationPage {
    private WebDriver webDriver;
    private String titleString;
    private String privacyString;
    private String backgroundString;
    private static final int PRIVATE_OUT_IN_SECONDS = 30;
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
    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement createBoardButton;

    public BoardCreationPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

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
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, PRIVATE_OUT_IN_SECONDS);
        EnumMap<BoardFields, ISteps> enumMap = new EnumMap<>(BoardFields.class);
        titleString = inputData.get(BoardFields.TITLE);
        webDriverWait.until(ExpectedConditions.visibilityOf(addBoardTitle));
        enumMap.put(BoardFields.TITLE, () -> addBoardTitle.sendKeys(titleString));
        for (BoardFields key : inputData.keySet()) {
            enumMap.get(key).execute();
        }
        createBoardButton.click();
        return new BoardPage(webDriver);
    }
}
