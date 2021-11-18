package com.gmail.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test(priority = 1)
    public void incorrectUsernameTest() {
        System.out.println("Starting incorrectUsernameTest");

		//Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUsername");


        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();


        // Verifications
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual: "
                        + actualErrorMessage + "\nExpected: "
                        + expectedErrorMessage);

        // Close browser
        driver.quit();
    }

    @Test(priority = 2, enabled = false)
    public void incorrectPasswordTest() {
        System.out.println("Starting incorrectPasswordTest");

        //Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");


        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("incorrectPassword!");

        //click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();



        // Verifications
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Actual error message does not contain expected. \nActual: "
                        + actualErrorMessage + "\nExpected: "
                        + expectedErrorMessage);

        // Close browser
        driver.quit();
    }

}
