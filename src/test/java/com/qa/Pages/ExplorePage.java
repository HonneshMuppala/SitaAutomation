package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.Base.Testbase;

public class ExplorePage {
    public WebDriver driver = Testbase.driver;
    
    @FindBy(xpath = "//div[@class='owl-item active']//h4[text()='Kingston']/parent::div//div[@class='main-button']")
    public WebElement kingstonButton;

    public WebElement getKingstonButton() {
        return kingstonButton;
    }

    public ExplorePage(WebDriver rDriver) {
        this.driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
}
