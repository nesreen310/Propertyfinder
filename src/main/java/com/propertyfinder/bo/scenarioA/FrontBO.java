package com.propertyfinder.bo.scenarioA;

import com.propertyfinder.bo.BaseBO;
import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.model.Agent;
import com.propertyfinder.parser.CSVParser;
import com.propertyfinder.parser.model.Villa;
import com.propertyfinder.po.scenarioA.FrontPO;
import com.propertyfinder.po.scenarioB.AgentModelPO;
import com.propertyfinder.po.scenarioB.AgentsPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.propertyfinder.utils.Utils.getFirstPartOfPhrase;

public class FrontBO extends BaseBO {
    public static final String LOCATION = "The Pearl";
    public static final String VILLA = "Villa";
    public static final String BUY = "Buy";
    public static final String APARTMENT = "Apartment";
    public static final String MARINA = "Marina";

    private FrontPO frontPO = new FrontPO();
    private AgentsPO agentsPO = new AgentsPO();
    private AgentModelPO agentModelPO = new AgentModelPO();
    private VillaBO villaBO = new VillaBO();


    //     Scenario A
    @Given("Open (.*)$")
    public FrontBO openUrl(String url) {
        openPortal(url);
        return this;
    }

    @When("Search for VILLA to BUY in location THE PEARL with minimum 3BEDS and maximum 7BEDS")
    public FrontBO searchFor(String location) {
        frontPO
                .act_chooseCategory(BUY)
                .act_clickTypeDropDown(VILLA)
                .enter_location(location)
                .act_clickFirstLocation()
                .act_clickBad(3, 7);
        return this;
    }

    @Then("Sort the villas from maximum price to lowest price")
    public FrontBO findAndSort() {
        frontPO.act_clickFind()
                .sortedFromMaxToMin();
        return this;
    }

    @And("Fetch all the prices of the listing and save it in a csv file with format : listing title - price")
    public FrontBO writeVillaList(String fileName) {
        List<Villa> list = villaBO.getVillasModels();
        CSVParser csvParser = new CSVParser();
        csvParser.writeCsvFromBean(Paths.get(fileName), list);
        return this;
    }

    @And("Capture following info in a text file")
    public FrontBO writeAgent(String fileName, Agent agent) {
        List<Agent> list = Collections.singletonList(agent);
        CSVParser csvParser = new CSVParser();
        csvParser.writeCsvFromBean(Paths.get(fileName), list);
        return this;
    }


    //    Task 1
    public FrontBO task1() {
        frontPO
//                .act_chooseCategory("")
                .act_clickTypeDropDown(APARTMENT)
                .enter_location(MARINA)
                .act_clickFirstLocation()
                .act_clickBad(2, 2)
                .act_clickFind()
                .sortedFromMaxToMin();
        return this;
    }

    public FrontBO find() {
        frontPO.act_clickFind()
                .sortedFromMaxToMin();
        return this;
    }

    //     Scenario B
    @When("Click on FIND AGENTS tab (present on top panel)Select the First agent")
    public void scenarioC() {
        agentModelPO
                .act_clickFindAgent()
                .act_clickFirstAgent()
                .act_clickAboutMeButton();
    }

    public Agent getAgentModel() {
        return agentModelPO.convertToAgentModel();
    }


    @And("Capture Screenshot of the page, change language to Arabic ,Capture screenshot again")
    public void scenarioCscreenShot() {
        WebDriverManager.makeScreenShot("screenShots/Ver1.png");
        agentModelPO
                .act_clickArabicLanguage();
        WebDriverManager.makeScreenShot("screenShots/Ver2.png");

    }

    public Integer[] scenarioB() {
        agentsPO
                .act_clickFindAgent()
                .act_clickLanguages(Arrays.asList("Hindi", "English", "Arabic"));

        agentsPO.act_clickFind();
        Integer countAll = getCount();
        agentsPO.act_clickNationality("India");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer countIndian = getCount();

        return new Integer[]{countAll, countIndian};
    }


    @And("Note down the total count of agents")
    public int getCount() {
        return Integer.valueOf(getFirstPartOfPhrase(agentsPO.getAgentCount()));
    }
}
