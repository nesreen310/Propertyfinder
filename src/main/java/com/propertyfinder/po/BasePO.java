package com.propertyfinder.po;

import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.testUtils.TestLogger;
import com.propertyfinder.utils.WaitManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
    protected WaitManager waitManager = new WaitManager();
    protected TestLogger LOG = TestLogger.getLogger();

    public BasePO() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }
}
