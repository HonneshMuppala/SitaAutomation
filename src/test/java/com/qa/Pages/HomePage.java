package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Testbase;

public class HomePage {
    public WebDriver driver = Testbase.driver;

    @FindBy(xpath = "//h4[text()='CARIBBEAN']/following-sibling::div//a[contains(text(), 'Explore More')]")
    public WebElement exploreMore;

    public WebElement getExploreMore() {
        return exploreMore;
    }


    public HomePage(WebDriver rDriver) {
        this.driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
}
