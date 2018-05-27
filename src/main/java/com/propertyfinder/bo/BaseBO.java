package com.propertyfinder.bo;

import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.po.BasePO;
import com.propertyfinder.testUtils.TestLogger;
import com.propertyfinder.utils.WaitManager;

public abstract class BaseBO {
    protected WaitManager waitManager = new WaitManager();
    protected TestLogger LOG = TestLogger.getLogger();
    private BasePO basePO;

    public BaseBO() {
        basePO = new BasePO();
    }

    public void openPortal(String url) {
        WebDriverManager.getUrl(url);
    }

    public void error(String message) {
        LOG.error(message);
    }

    public void step(String message) {
        LOG.info(message);
    }
}
