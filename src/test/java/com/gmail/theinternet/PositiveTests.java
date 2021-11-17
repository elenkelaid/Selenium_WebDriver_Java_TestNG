package com.gmail.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
    @Test
    public void loginTest(){

        System.out.println("Starting loginTest");
        //Create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open test page
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is open");

        //maximize browser window
        driver.manage().window().maximize();

        //enter user name
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        //click login button
        WebElement logInButton = driver.findElement(By.tagName("Button"));
        logInButton.click();

        // verifications:
        // new url
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,"Actual page url is not the same as expected");
        //logout button is visible
        WebElement logOutInButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        //successful login message
        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
        //Close browser
        driver.quit();

    }
}
