package org.fundacionjala.trello.pages.board;

import org.fundacionjala.trello.pages.BoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @FindBy(css = "._23NUW98LaZfBpQ")
    private WebElement addBoardTitle;

    public BoardCreationPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "._2MgouXHqRQDP_5")
    private WebElement createBoardButton;

    static {
        Map<String, String> backgroundColors = new HashMap<>();
        backgroundColors.put("blue", "rgb(0, 121, 191)");
        backgroundColors.put("orange", "rgb(210, 144, 52)");
        backgroundColors.put("green", "rgb(81, 152, 57)");
        backgroundColors.put("red", "rgb(176, 70, 50)");
        backgroundColors.put("null", "null");
        BACKGROUNDCOLORS = Collections.unmodifiableMap(backgroundColors);
    }

    public String getTitleString() {
        return titleString;
    }

    public String getPrivacyString() {
        return privacyString;
    }

    public String getBackgroundString() {
        return BACKGROUNDCOLORS.get(backgroundString == null ? "null" : backgroundString.toLowerCase() );
    }
    public BoardPage createNewBoard(final Map<BoardFields,String> inputData){
        EnumMap<BoardFields, IWebElementProject> enumMap = new EnumMap<>(BoardFields.class);
        titleString = inputData.get(BoardFields.TITLE);
        enumMap.put(BoardFields.TITLE,()-> addBoardTitle.sendKeys(titleString));
        createBoardButton.click();
        return new BoardPage(webDriver);
    }
}
