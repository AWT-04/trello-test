package org.fundacionjala.trello.pages.card;

import org.fundacionjala.core.utils.AbstractPage;
import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class BoardPage extends AbstractPage {

    private String xpathCard = "//*[@class='list-card-title js-card-name' and contains(text(),'%s')]";

    @FindBy(css = ".list-name-input")
    private WebElement txtNameList;

    @FindBy(xpath = "//span[@class='placeholder']")
    private WebElement btnAddTextList;

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

    @FindBy(css = ".js-open-more")
    private WebElement moreOptions;

    @FindBy(css = ".js-close-board")
    private WebElement closeBoard;

    @FindBy(css = ".negate")
    private WebElement closeButton;

    @FindBy(css = ".js-delete")
    private WebElement deleteBoard;

    @FindBy(css = ".js-confirm")
    private WebElement confirmDeleteBoard;

    @FindBy(xpath = "//a[@class='board-header-btn mod-show-menu js-show-sidebar']")
    private WebElement btnOpenMenu;

    @FindBy(xpath = "//a[@class='board-menu-header-close-button icon-lg icon-close js-hide-sidebar']")
    private WebElement btnCloseMenu;

    public void createList(final String nameList) {
        webDriverAction.click(btnAddTextList);
        webDriverAction.waitVisibility(txtNameList);
        webDriverAction.setValue(txtNameList, nameList);
        webDriverAction.click(btnAddList);
        webDriverAction.click(btnExitCard);
    }

    public void createCard(final String nameCard) {
        webDriverAction.waitVisibility(btnAddCard);
        btnAddCard.click();
        webDriverAction.waitVisibility(txtNameCard);
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
        WebElement btnEditR = webDriver.findElement(By.xpath(node));
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
        if (!Environment.getInstance().getDevice().contains("chrome")) {
            webDriverAction.click(btnCloseMenu);
        }
        webDriverAction.click(btnSelect);
    }

    public boolean verifySelectedCardNameInTheTitle(final String nameCard) {
        WebElement txtNameSelectedCard = webDriver.findElement(
                By.xpath(String.format("//a[@class='action-card' and contains(text(),'%s')]", nameCard)));
        return txtNameSelectedCard.getText().contains(nameCard);
    }

    public boolean verifyListSelectedCardNameInTheTitle(final String nameList) {
        WebElement txtTitleNameSelectedCard = webDriver.findElement(
                By.xpath(String.format("//*[@class='js-open-move-from-header' and contains(text(),'%s')]", nameList)));
        return txtTitleNameSelectedCard.getText().contains(nameList);
    }

    public boolean verifyPageTtile(final String nameCard) {
        return webDriver.getTitle().contains(nameCard);
    }

    public boolean verifyCardNameInTheMenuActivity(final String nameCard) {
        if (!Environment.getInstance().getDevice().contains("chrome")) {
            btnOpenMenu.click();
        }
        WebElement node = webDriver.findElement(By.xpath(String.format(
                "//a[@class = 'action-card' and contains(text(),'%s')]", nameCard)));
        return node.getText().contains(nameCard);
    }

    public String getTitleList(final String listName) {
        String listXpath = String.format("//*[text()='%s' and contains(@class,'js-list-name-input')]", listName);
        By listSelectorName = By.xpath(listXpath);
        return headerList.findElement(listSelectorName).getText();
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

    public void updteDataFromForm(final String nameCard, final String newCardName,
                                  final String description, final String comment) {
        selectCard(nameCard);
        btnAreaCardName.click();
        txtAreaCardName.clear();
        txtAreaCardName.sendKeys(newCardName);
        btnDescription.click();
        txtDescription.click();
        txtDescription.sendKeys(description);
        btnSaveDescription.click();
        txtComment.click();
        txtComment.sendKeys(comment);
        btnSaveComment.click();
    }

    public void closeDataForm() {
        btnCloseCardForm.click();
    }

    public void deleteCurrentBoard() {
        moreOptions.click();
        closeBoard.click();
        closeButton.click();
        deleteBoard.click();
        confirmDeleteBoard.click();
    }

    public void selectCreatedBoard(final String name) {
        WebElement nameListSelected = webDriver.findElement(By.xpath(String.format(
                "//div[@class='board-tile-details-name']//div[contains(text(),'%s')]", name)));
        nameListSelected.click();
    }
}
