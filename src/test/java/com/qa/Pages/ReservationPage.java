package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Testbase;

public class ReservationPage {
    public WebDriver driver = Testbase.driver;

    @FindBy(name = "Name")
    public WebElement name;

    @FindBy(name = "Number")
    public WebElement number;

    @FindBy(id = "chooseGuests")
    public WebElement chooseGuests;

    @FindBy(className = "date")
    public WebElement date;

    @FindBy(id = "chooseCategory")
    public WebElement chooseCategory;

    @FindBy(xpath = "//button[normalize-space()='Make Your Reservation Now']")
    public WebElement reservationButton;

    
    public WebElement getName() {
        return name;
    }

    public WebElement getNumber() {
        return number;
    }

    public WebElement getChooseGuests() {
        return chooseGuests;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getChooseCategory() {
        return chooseCategory;
    }

    public WebElement getReservationButton() {
        return reservationButton;
    }


    public ReservationPage(WebDriver rDriver) {
        this.driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
}
