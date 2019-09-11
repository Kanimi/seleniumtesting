package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void simpleformTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement inputField = driver.findElement(By.id("user-message"));
        inputField.sendKeys("My message");
        Thread.sleep(1000);
        WebElement showMessage = driver.findElement(By.id("get-input")).findElement(By.tagName("button"));
        showMessage.click();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement sum1Input = driver.findElement(By.id("sum1"));
        sum1Input.sendKeys("8");
        WebElement sum2Input = driver.findElement(By.id("sum2"));
        sum2Input.sendKeys("5");
        WebElement addValues = driver.findElement(By.id("gettotal")).findElement(By.tagName("button"));
        addValues.click();
        Thread.sleep(3000);

//        FIRST SELENIUM FOR GOOGLE IMAGES
//        driver.get("http://google.com");
//        Thread.sleep(2000);
//        WebElement searchField = driver.findElement(By.name("q"));
//        assertTrue(searchField.isDisplayed());
//        searchField.sendKeys("marble fox pictures");
//        Thread.sleep(3000);
//        WebElement submitButton = driver.findElement(By.name("btnK"));
//        submitButton.click();
//        Thread.sleep(3000);
//        WebElement linkToBiggerPicture = driver.findElementByLinkText("Images for marble fox");
//        linkToBiggerPicture.click();
//        Thread.sleep(1000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,500)");
//        Thread.sleep(5000);
    }

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement ageCheckbox = driver.findElement(By.id("isAgeSelected"));
        ageCheckbox.click();
        Thread.sleep(3000);
        List<WebElement> cb = driver.findElements(By.className("cb1-element"));
        for (WebElement el:cb) {
            el.click();
            Thread.sleep(500);
        }
//      page is broken, the "Check All" button changes values on the 3rd option being clicked
        Thread.sleep(1000);
        WebElement checkAll = driver.findElement(By.id("check1"));
        checkAll.click();
        Thread.sleep(2000);
    }
}
