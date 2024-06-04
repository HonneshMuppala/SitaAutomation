package com.qa.Testscripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Base.Testbase;

public class SitaTest extends Testbase {

    @Test(priority = 1)
    public void Sita_Home_page() throws IOException {
        boolean homepage = driver.getCurrentUrl().contains("https://sitatesting.github.io/AutomationTest/index.html");
        if (homepage) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is not displayed");
            driver.quit();
        }
        Assert.assertTrue(homepage, "Home page is not displayed");
        System.out.println("Home page is displayed");
        screenShort(driver, null);
    }

    @Test(priority = 2)
    public void Explore_more() throws InterruptedException, IOException {
        jse.executeScript("window.scrollBy(0,1200);");
        Thread.sleep(2000);
        WebElement exploreMoreButton = wait.until(ExpectedConditions.elementToBeClickable(homepage.getExploreMore()));
        Assert.assertNotNull(exploreMoreButton, "Explore More button is not clickable or present");
        exploreMoreButton.click();
        System.out.println("Explore More button clicked");
        screenShort(driver, null);
    }

    @Test(priority = 3)
    public void Explore_more_page() throws InterruptedException, IOException {
        jse.executeScript("window.scrollBy(0,1500);");
        Thread.sleep(10000);
        WebElement kingstonLink = wait.until(ExpectedConditions.elementToBeClickable(explorepage.getKingstonButton()));
        Assert.assertNotNull(kingstonLink, "Kingston link is not clickable or present");
        kingstonLink.click();
        System.out.println("Kingston link clicked");
        screenShort(driver, null);
    }

    @Test(priority = 4)
    public void Reservation_page() throws InterruptedException, IOException {
        jse.executeScript("window.scrollBy(0,1400);");
        Thread.sleep(3000);
        screenShort(driver, null);
        WebElement nameInput = reservationpage.getName();
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).click();
        nameInput.clear();
        nameInput.sendKeys("raju");
        Assert.assertEquals(nameInput.getAttribute("value"), "raju", "Name input failed");

        WebElement numberInput = reservationpage.getNumber();
        numberInput.click();
        numberInput.clear();
        numberInput.sendKeys("0899512260");
        Assert.assertEquals(numberInput.getAttribute("value"), "0899512260", "Number input failed");

        WebElement guestsDropdown = wait
                .until(ExpectedConditions.elementToBeClickable(reservationpage.getChooseGuests()));
        new Select(guestsDropdown).selectByVisibleText("2");
        Assert.assertEquals(new Select(guestsDropdown).getFirstSelectedOption().getText(), "2",
                "Guests selection failed");

        String dateAfterTwoDays = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(reservationpage.getDate()));
        wait.until(ExpectedConditions.elementToBeClickable(dateElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dateElement)).clear();
        dateElement.sendKeys(dateAfterTwoDays);
        System.out.println("entered date: " + dateAfterTwoDays);
        System.out.println("entered date");

        new Select(reservationpage.getChooseCategory()).selectByIndex(2);
        Thread.sleep(3000);
        System.out.println("selected Category");
        screenShort(driver, null);

        WebElement submitButton = reservationpage.getReservationButton();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not clickable");
        Thread.sleep(3000);
    }

}
