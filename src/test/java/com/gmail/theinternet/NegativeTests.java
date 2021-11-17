package com.gmail.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void incorrectUsernameTest() {

        System.out.println("Starting incorrectTest");
        //Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open test page
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is open");

        //maximize browser window
        driver.manage().window().maximize();

        //enter user name
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("wrongUsername");
        //enter password
        WebElement password = driver.findElement(By.name("wrongPassword"));
        password.sendKeys("SuperSecretPassword!");
        //click login button
        WebElement logInButton = driver.findElement(By.tagName("Button"));
        logInButton.click();

        // verifications:
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectErrorMessage = "Your username is invalid";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectErrorMessage),"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: " + expectErrorMessage);

    }
}
