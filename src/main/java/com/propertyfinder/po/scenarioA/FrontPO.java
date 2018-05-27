package com.propertyfinder.po.scenarioA;


import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.po.BasePO;
import com.propertyfinder.utils.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPO extends BasePO {

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_type']/*[@class='dropdown dropdown-height1']")
    private WebElement typeDropDown;

    @FindBy(xpath = ".//*[text()='Villa']")
    private WebElement villa;

    @FindBy(xpath = ".//*[@class='autocomplete_inputwrapper']/*[@class='autocomplete_input']")
    private WebElement location;

    @FindBy(xpath = ".//*[@class='autocomplete_suggestions']/*[1]")
    private WebElement selectFirstLocation;

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_bed']/*[1]")
    private WebElement minBad;

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_bed']/*[2]")
    private WebElement maxBad;

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_bed']/*[1]/*[2]//*[text()='3 Bedrooms']")
    private WebElement minBad3option;

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_bed']/*[2]/*[2]//*[text()='7 Bedrooms']")
    private WebElement maxBad7option;

    @FindBy(xpath = ".//button[@class='button button-fullheight button-connectedright']")
    private WebElement find;

    @FindBy(xpath = ".//*[@class='dropdown dropdown-bordered']")
    private WebElement sortedBy;

    @FindBy(xpath = "//*[text()='Price (high)']")
    private WebElement fromMaxToMin;

    @FindBy(xpath = ".//*[@class='searchproperty_column searchproperty_category']")
    private WebElement category;

    @FindBy(xpath = ".//*[text()='Buy']")
    private WebElement buyCategory;


    public FrontPO act_chooseCategory(String cat) {
        waitManager.untilClickable(category);
        category.click();
        WaitManager.sleepTimeOut(1000);
        WebDriverManager.getDriver().findElement(By.xpath(".//*[text()='" + cat + "']"));
//        buyCategory.click();
        return this;
    }

    public FrontPO act_clickFind() {
        waitManager.untilClickable(find);
        find.click();
        return this;
    }

    public FrontPO sortedFromMaxToMin() {
        waitManager.untilClickable(sortedBy);
        sortedBy.click();

        waitManager.untilClickable(fromMaxToMin);
        fromMaxToMin.click();
        return this;
    }

    public FrontPO act_clickBad(int minBadOption, int maxBadOption) {
        WaitManager.sleepTimeOut(1300);
        minBad.click();

        WaitManager.sleepTimeOut(1300);
//        Min bad option
        WebDriverManager.getDriver().findElement(
                By.xpath(".//*[@class='searchproperty_column searchproperty_bed']/*[1]/*[2]//*[text()='" + minBadOption + " Bedrooms']"))
                .click();
//        minBad3option.click();

        WaitManager.sleepTimeOut(1300);
        maxBad.click();

        WaitManager.sleepTimeOut(1300);
        WebDriverManager.getDriver().findElement(
                By.xpath(".//*[@class='searchproperty_column searchproperty_bed']/*[2]/*[2]//*[text()='" + maxBadOption + " Bedrooms']"))
                .click();
//        maxBad7option.click();
        return this;
    }

    public FrontPO enter_location(String place) {
        waitManager.untilClickable(location);
        location.sendKeys(place);
        return this;
    }

    public FrontPO act_clickFirstLocation() {
        waitManager.untilClickable(selectFirstLocation);
        selectFirstLocation.click();
        return this;
    }

    public FrontPO act_clickTypeDropDown(String type) {
        waitManager.untilClickable(typeDropDown);
        WaitManager.sleepTimeOut(3000);
//        typeDropDown.click();
        WebDriverManager.executeScript("arguments[0].click();", typeDropDown);

        WaitManager.sleepTimeOut(3000);
        WebDriverManager.getDriver().findElement(By.xpath(".//*[text()='" + type + "']")).click();
        return this;
    }
}
