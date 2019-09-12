package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void simpleformTest() throws InterruptedException {
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

    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> genders = driver.findElementsByName("optradio");
        for (WebElement i:genders){
            i.click();
            Thread.sleep(200);
            WebElement select = driver.findElementById("buttoncheck");
            select.click();
            Thread.sleep(200);
            WebElement message = driver.findElement(By.className("radiobutton"));
            assertEquals(message.getText(), "Radio button '"+i.getAttribute("value")+"' is checked");
            Thread.sleep(500);
        }
        Thread.sleep(100);
        List<WebElement> genders2 = driver.findElementsByName("gender");
        List<WebElement> ageGroup = driver.findElementsByName("ageGroup");
        for (WebElement i:genders2){
            for (WebElement j:ageGroup){
                i.click();
                j.click();
            }
        }
    }

    @Test
    public void selectDropdownListTest() throws InterruptedException {
        //website test is broken! something to do with javascript???
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

    @Test
    public void rangeSlidersTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        List<WebElement> sliders = driver.findElementsByName("range");
        Thread.sleep(2000);
        for (WebElement i:sliders){
            Actions action = new Actions(driver);
            action.moveToElement(i).clickAndHold().moveByOffset(-100, 0).release().perform();
            Thread.sleep(500);
            action.moveToElement(i).clickAndHold().moveByOffset(73,0).release().perform();
            Thread.sleep(500);
        }
        Thread.sleep(500);
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Thread.sleep(2000);
        WebElement j = driver.findElementById("mydropzone");
        List<WebElement> draggable = driver.findElementsById("todrag");
        for (WebElement i:draggable){
            Actions action = new Actions(driver);
            action.moveToElement(i).clickAndHold().moveToElement(j).release().perform();
            Thread.sleep(500);
        }
        Thread.sleep(2000);
    }
}
