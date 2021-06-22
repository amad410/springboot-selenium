package com.ea.SpringStart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoogleResultsPage extends BasePage {


    @FindBy(how = How.NAME, using = "q")
    public WebElement searchTextBar;

    @FindAll({
            @FindBy(xpath = "//h3[contains(text(),'Selenium')]")
    })
    public List<WebElement> results;

    public Boolean IsResultsFoundContaining () throws InterruptedException {
        Boolean isFound = false;
        Thread.sleep(5000);
        isFound = results.size() > 0;
        return isFound;

    }

}
