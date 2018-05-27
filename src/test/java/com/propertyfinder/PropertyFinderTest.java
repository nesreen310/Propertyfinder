package com.propertyfinder;

import com.propertyfinder.bo.scenarioA.FrontBO;
import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.core.injector.Injector;
import com.propertyfinder.model.Agent;
import com.propertyfinder.testUtils.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.propertyfinder.constants.CommonConsts.OUTPUT;
import static com.propertyfinder.constants.CommonConsts.PROPERTY_FINDER_AE_URL;
import static com.propertyfinder.constants.CommonConsts.PROPERTY_FINDER_URL;

public class PropertyFinderTest extends BaseTestClass {
    private final static String FILE_PATH_SCENARIO_A = OUTPUT+"ScenarioA.csv";
    private final static String FILE_PATH_TASK1 = OUTPUT+"task1.csv";
    private final static String AGENT_MODEL_CSV = OUTPUT+"agent.csv";

    @Injector
    private
    FrontBO frontBO;

    @Test
    public void task1() {
        WebDriverManager.getDriver().get(PROPERTY_FINDER_AE_URL);
        frontBO
                .openUrl(PROPERTY_FINDER_AE_URL)
                .task1()
                .find()
                .writeVillaList(FILE_PATH_TASK1);
    }

    @Test
    public void scenarioA() {

        frontBO
                .openUrl(PROPERTY_FINDER_URL)
                .searchFor(FrontBO.LOCATION)
                .findAndSort()
                .writeVillaList(FILE_PATH_SCENARIO_A);
    }

    @Test
    public void scenarioB() {
        frontBO
                .openUrl(PROPERTY_FINDER_AE_URL);

        Integer[] arr = frontBO.scenarioB();

        Assert.assertEquals(arr[0], arr[1]);

    }

    @Test
    public void scenarioC() {
        frontBO
                .openUrl(PROPERTY_FINDER_AE_URL);
        frontBO
                .scenarioC();
        Agent agent = frontBO.getAgentModel();
        frontBO.writeAgent(AGENT_MODEL_CSV,agent);
        frontBO.scenarioCscreenShot();
    }
}
