package com.propertyfinder.bo.scenarioA;

import com.propertyfinder.bo.BaseBO;
import com.propertyfinder.core.driver.WebDriverManager;
import com.propertyfinder.parser.model.Villa;
import com.propertyfinder.po.scenarioA.VillaPO;
import com.propertyfinder.utils.WaitManager;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class VillaBO extends BaseBO {

    List<Villa> villas = new ArrayList<>();
    private VillaPO villaPO = new VillaPO();

    public List<Villa> getVillasModels() {

        int linksCount = villaPO.getPagLinkCount().size();

        if (linksCount > 0) {

            for (int i = 1; i <= linksCount; i++) {
                scrapeItems();
                WebDriverManager.getDriver().findElement(By.xpath(".//*[@class='pagination_links']//*[@class='pagination_link '][" + i + "]")).click();
                WaitManager.sleepTimeOut(1000);
            }
        }
        {
            scrapeItems();
        }

        return villas;
    }

    public void scrapeItems() {

        int sizeTitles = villaPO.getTitles().size();
//        int sizePrices = villaPO.getPrices().size();
        for (int j = 0; j < sizeTitles; j++) {
            String title = villaPO.getTitles().get(j).getText();
            String prices = villaPO.getPrices().get(j).getText();
            villas.add(new Villa(title, prices));
        }

    }
}
