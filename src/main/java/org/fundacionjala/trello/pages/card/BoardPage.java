package org.fundacionjala.trello.pages.card;

import org.fundacionjala.core.utils.WebDriverAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BoardPage {
    private WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebDriverAction webDriverAction;
    private String xpathCard = "//*[@class='list-card-title js-card-name' and contains(text(),'%s')]";


    public BoardPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".list-name-input")
    private WebElement txtNameList;

    @FindBy(css = ".mod-list-add-button.js-save-edit")
    private WebElement btnAddList;

    @FindBy(css = ".open-card-composer.card-templates-enabled.js-open-card-composer")
    private WebElement btnAddCard;

    @FindBy(css = ".js-cancel-edit")
    private WebElement btnExitCard;

    @FindBy(css = ".list-card-composer-textarea.js-card-title")
    private WebElement txtNameCard;

    @FindBy(css = ".js-add-card")
    private WebElement btnAcceptAddCard;

    @FindBy(css = ".js-cancel")
    private WebElement btnCancelAddCard;

    @FindBy(css = ".button-link.js-archive-card")
    private WebElement btnArchiveCard;

    @FindBy(css = ".button-link.js-delete-card.negate")
    private WebElement btnDeleteCard;

    @FindBy(css = ".js-confirm.full.negate")
    private WebElement btnConfirmDeleteCard;

    @FindBy(css = ".list-card.js-member-droppable.ui-droppable")
    private WebElement btnEdit;

    @FindBy(css = ".primary.wide.js-save-edits")
    private WebElement btnSave;

    @FindBy(how = How.XPATH, using = "//textarea[@class='list-card-edit-title js-edit-card-title']")
    private WebElement txtareaNewCardName;

    @FindBy(css = ".list-name-input")
    private WebElement listName;

    @FindBy(css = ".mod-list-add-button")
    private WebElement buttonAddList;

    @FindBy(css = ".js-add-a-card")
    private WebElement buttonAddCard;

    @FindBy(xpath = "//*[@class='list-header js-list-header u-clearfix is-menu-shown is-subscribe-shown']")
    private WebElement headerList;

    @FindBy(xpath = "//*[@id='board']")
    private WebElement lists;

    @FindBy(css = ".js-editing-target")
    private WebElement listEdit;

    @FindBy(css = ".list-header-name.mod-list-name.js-list-name-input")
    private WebElement listEditText;

    @FindBy(css = "a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-lg.icon-overflow-menu-horizontal")
    private WebElement menuList;

    @FindBy(css = ".js-move-list")
    private WebElement moveList;

    @FindBy(css = ".header-search-input")
    private WebElement searchDrawer;

    @FindBy(css = ".search-results-section .compact-board-tile-link-text-name")
    private WebElement firstFoundFile;

    @FindBy(css = ".js-close-list")
    private WebElement archiveListButton;

    @FindBy(xpath = "//textarea[@class='mod-card-back-title js-card-detail-title-input is-editing']")
    private WebElement txtAreaCardName;

    @FindBy(xpath = "//a[@class='description-fake-text-area hide-on-edit js-edit-desc js-hide-with-draft']")
    private WebElement btnDescription;

    @FindBy(xpath = "//textarea[@class='field field-autosave js-description-draft description card-description']")
    private WebElement txtDescription;

    @FindBy(xpath = "//textarea[@class='comment-box-input js-new-comment-input']")
    private WebElement btnComment;

    @FindBy(xpath = "//textarea[@class='comment-box-input js-new-comment-input']")
    private WebElement txtComment;

    @FindBy(xpath = "//textarea[@class='mod-card-back-title js-card-detail-title-input']")
    private WebElement btnAreaCardName;

    @FindBy(xpath = "//input[@class='primary confirm mod-no-top-bottom-margin js-add-comment']")
    private WebElement btnSaveComment;

    @FindBy(xpath = "//input[@class='primary confirm mod-submit-edit js-save-edit']")
    private WebElement btnSaveDescription;

    @FindBy(xpath = "//a[@class='icon-md icon-close dialog-close-button js-close-window']")
    private WebElement btnCloseCardForm;

    public void createList(final String nameList) {
        txtNameList.sendKeys(nameList);
        btnAddList.click();
        btnExitCard.click();
    }

    public void createCard(final String nameCard) {
        btnAddCard.click();
        txtNameCard.sendKeys(nameCard);
        btnAcceptAddCard.click();
        btnCancelAddCard.click();
    }

    public String extractTextToTheCard(final String cardName) {
        String node = String.format(xpathCard, cardName);
        return webDriver.findElement(By.xpath(node)).getText();
    }

    public void deleteCard(final String cardName) {
        String node = String.format(xpathCard, cardName);
         webDriver.findElement(By.xpath(node)).click();
         btnArchiveCard.click();
         btnDeleteCard.click();
         btnConfirmDeleteCard.click();
    }

    public List<WebElement> listOfCards(final String cardName) {
        String node = String.format(xpathCard, cardName);
        return webDriver.findElements(By.xpath(node));
    }

    public void rigthClickSelectCard(final String nameCard) {
        Actions actions = new Actions(webDriver);
        String node = String.format("//span[contains(text(),'%s')]", nameCard);
        WebElement btnEditR =  webDriver.findElement(By.xpath(node));
        actions.contextClick(btnEditR).perform();
    }

    public void editCreatedCard(final String nameCard, final String newNameCard) {
        rigthClickSelectCard(nameCard);
        txtareaNewCardName.sendKeys(newNameCard);
        btnSave.click();
    }

    public void selectCard(final String nameCard) {
        String node = String.format("//span[contains(text(),'%s')]", nameCard);
        WebElement btnSelect = webDriver.findElement(By.xpath(node));
        btnSelect.click();
    }

    public boolean verifySelectedCardNameInTheTitle(final String nameCard) {
        WebElement txtNameSelectedCard = webDriver.findElement(
                By.xpath(String.format("//a[@class='action-card' and contains(text(),'%s')]", nameCard)));
        return txtNameSelectedCard.getText().contains(nameCard);
    }

    public boolean verifyListSelectedCardNameInTheTitle(final String nameList) {
        WebElement txtTitleNameSelectedCard =  webDriver.findElement(
                By.xpath(String.format("//*[@class='js-open-move-from-header' and contains(text(),'%s')]", nameList)));
        return txtTitleNameSelectedCard.getText().contains(nameList);
    }

    public boolean verifyPageTtile(final String nameCard) {
        return webDriver.getTitle().contains(nameCard);
    }

    public boolean verifyCardNameInTheMenuActivity(final String nameCard) {
        WebElement node = webDriver.findElement(By.xpath(String.format(
                "//a[contains(text(),'%s')]", nameCard)));
        return  node.getText().contains(nameCard);
    }

    public void editList(final String name) {
        listEdit.click();
        listEditText.clear();
        listEditText.sendKeys(name);
        buttonAddList.click();
    }

    public void addList(final String name) {
        listName.sendKeys(name);
        buttonAddList.click();
    }

    public void addSeveralList(final List<String> lists) {
        for (String list : lists) {
            addList(list);
        }
    }

    public String getTitleList(final String listName) {
        String listXpath = String.format("//*[text()='%s' and contains(@class,'js-list-name-input')]", listName);
        By listSelectorName = By.xpath(listXpath);
        return headerList.findElement(listSelectorName).getText();
    }

    public int getSizeList() {
        return lists.findElements(By.cssSelector("div.js-list.list-wrapper")).size();
    }

    public void changeListToBoard(final String board) {
        menuList.click();
        moveList.click();
        By selectBoard = By.cssSelector("select.js-select-board");
        Select dropdown = new Select(webDriver.findElement(selectBoard));
        dropdown.selectByVisibleText(board);
        WebElement moveButton = webDriver.findElement(By.xpath("//*[@class='primary wide js-commit-position']"));
        moveButton.click();
    }

    public void openBoardDrawer(final String boardName) {
        searchDrawer.sendKeys(boardName);
        firstFoundFile.click();
    }

    public void openMenuList(final String nameList) {
        final String ancestor = "ancestor::div[contains(@class,'list js-list-content')]";
        final String descendant = "descendant::*[@class='list-header-extras']";
        WebElement nameListSelected = webDriver.findElement(By.xpath(String.format(
                "//textarea[@aria-label='%s']/%s/%s",
                nameList, ancestor, descendant)));
        nameListSelected.click();
        archiveListButton.click();
    }

    public boolean verifyListExist(final String nameList) {
        By element = By.xpath(String.format("//textarea[@aria-label='%s']", nameList));
        return webDriverAction.isExistingSelector(element);
    }

    public void updteDataFromForm(final String nameCard, final String newCardName,
                                  final String description, final String comment) {
        selectCard(nameCard);
        btnAreaCardName.click();
        txtAreaCardName.clear();
        txtAreaCardName.sendKeys(newCardName);
        txtDescription.click();
        txtDescription.sendKeys(description);
        btnSaveDescription.click();
        txtComment.click();
        txtComment.sendKeys(comment);
        btnSaveComment.click();
    }

    public void closeDataForm(){
        btnCloseCardForm.click();
    }
}
