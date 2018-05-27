package com.propertyfinder.po.scenarioA;

import com.propertyfinder.po.BasePO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VillaPO extends BasePO {

    @FindBy(xpath = ".//*[@class='card_title card_title-link']")
    private List<WebElement> title;

    @FindBy(xpath = ".//*[@class='card_pricevalue']")
    private List<WebElement> price;

    @FindBy(xpath = ".//*[@class='pagination_links']//*[@class='pagination_link ']")
    private List<WebElement> pagLinkCount;

    public List<WebElement> getPagLinkCount() {
        return pagLinkCount;
    }

    public List<WebElement> getTitles() {
        return title;
    }

    public List<WebElement> getPrices() {
        return price;
    }
}
