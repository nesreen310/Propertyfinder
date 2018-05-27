package com.propertyfinder.po.scenarioB;

import com.propertyfinder.model.Agent;
import com.propertyfinder.po.BasePO;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgentModelPO extends BasePO {

    @FindBy(xpath = ".//*[@class='tiles_tile'][1]")
    private WebElement firstAgent;

    @FindBy(xpath = ".//*[@class='title title-size1 bioinfo_name']")
    private WebElement name;
    @FindBy(xpath = ".//*[@class='pane_column pane_column-fullwidth']/p[1]/span[2]")
    private WebElement nationality;
    @FindBy(xpath = ".//*[@class='pane_column pane_column-fullwidth']/p[2]/span[2]")
    private WebElement languages;
    @FindBy(xpath = ".//*[@class='pane_section pane_section-style1']//*[@class='pane-textsmall pane_columns']//p[2]/span[2]")
    private WebElement licenseNo;
    @FindBy(xpath = ".//*[@class='tab_content tab_content-size1 tab_content-active']")
    private WebElement aboutMe;
    @FindBy(xpath = ".//*[@class='button_text button_text-value button_phone-ltr button_text-ishidden']")
    private WebElement phoneNumber;
    @FindBy(xpath = ".//*[@class='brokerthumbnail_text']/p[1]")
    private WebElement companyName;
    @FindBy(xpath = ".//*[@class='pane_section pane_section-style1']//*[@class='pane-textsmall pane_columns']//p[3]/span[2]")
    private WebElement experience;
    @FindBy(xpath = ".//*[@class='pane_section pane_section-style1']//*[@class='pane-textsmall pane_columns']//p[1]/span[2]")
    private WebElement noofActiveListings;
    @FindBy(xpath = ".//*[@class='pane_section pane_section-style1']//*[@class='pane-textsmall pane_columns']//p[4]/span[2]/a")
    private WebElement linkedInUrl;

    @FindBy(xpath = ".//*[text()='About me']")
    private WebElement aboutMeClick;

    @FindBy(xpath = ".//*[text()='Find agent']")
    private WebElement findAgent;

    @FindBy(xpath = ".//*[@class='globalswitch globalswitch-style1']/*[@class='globalswitch_language']/a")
    private WebElement arabicLanguage;


    public AgentModelPO act_clickArabicLanguage(){
        waitManager.untilClickable(arabicLanguage);
        arabicLanguage.click();
        return this;
    }

    public AgentModelPO act_clickFindAgent() {
        waitManager.untilClickable(findAgent);
        findAgent.click();
        return this;
    }


    public AgentModelPO act_clickFirstAgent() {
        waitManager.untilClickable(firstAgent);
        firstAgent.click();
        return this;
    }

    public AgentModelPO act_clickAboutMeButton() {
        waitManager.untilClickable(aboutMeClick);
        aboutMeClick.click();
        return this;
    }
    public Agent convertToAgentModel(){
        Agent agent = new Agent();
        agent.setName(name.getText());
        agent.setNationality(nationality.getText());
        agent.setLanguages(languages.getText());
        agent.setLicenseNo(licenseNo.getText());
        agent.setAboutMe(aboutMe.getText());
        agent.setPhoneNumber(phoneNumber.getText());
        agent.setCompanyName(companyName.getText());
        agent.setExperience(experience.getText());
        agent.setNoofActiveListings(noofActiveListings.getText());
        agent.setLinkedInUrl(linkedInUrl.getAttribute("href"));

        return agent;
    }
}
