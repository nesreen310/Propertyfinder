package com.propertyfinder.po.scenarioB;

import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.po.BasePO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AgentsPO extends BasePO {

    @FindBy(xpath = ".//*[text()='Find agent']")
    private WebElement findAgent;

    @FindBy(xpath = ".//*[text()='Languages']")
    private WebElement languages;

    @FindBy(xpath = ".//*[@class='heading']/h1[@class='title']")
    private WebElement agentCount;

    @FindBy(xpath = ".//*[text()='Nationality']")
    private WebElement nationality;

    @FindBy(xpath = ".//button[@class='button button-fullheight button-connectedright']")
    private WebElement find;


    @When("Click on FIND AGENTS tab (present on top panel)")
    public AgentsPO act_clickFindAgent() {
        waitManager.untilClickable(findAgent);
        findAgent.click();
        return this;
    }

    public AgentsPO act_clickFind() {
        waitManager.untilClickable(find);
        find.click();
        return this;
    }

    @Then("Filter agents who can speak \"HINDI, ENGLISH, ARABIC\"")
    public AgentsPO act_clickLanguages(List<String> language) {
        waitManager.untilClickable(languages);
        languages.click();
        for (String aLanguage : language) {
            WebDriverManager.getDriver().findElement(By.xpath(".//*[text()='" + aLanguage + "']")).click();
        }
        return this;
    }

    public String getAgentCount() {
        return agentCount.getText();
    }

    @And("Now further filter agents from India")
    public AgentsPO act_clickNationality(String national) {
        nationality.click();
        WebDriverManager.getDriver().findElement(By.xpath(".//*[text()='" + national + "']")).click();

        return this;
    }
}
