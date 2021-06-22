package com.test.SpringTestFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class GoogleHomePage extends BasePage {
    @FindBy(how = How.NAME, using = "q")
    public WebElement searchTextBar;

    @FindBy(how = How.XPATH, using = "//*[@value='Google Search']")
    public WebElement searchBtn;

    public GoogleSearchResultPage Search(String text) throws InterruptedException {
        searchTextBar.sendKeys(text);
        Thread.sleep(5000);
        searchBtn.click();
        return new GoogleSearchResultPage();
    }



}
