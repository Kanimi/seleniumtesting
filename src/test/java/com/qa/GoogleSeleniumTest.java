package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
                WebElement getvalues = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button");
                getvalues.click();
                Thread.sleep(500);
            }
        }
    }

    @Test
    public void selectDropdownListTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Thread.sleep(2000);
        List<WebElement> dropdown = driver.findElementById("select-demo").findElements(By.tagName("option"));
        WebElement drop = driver.findElementById("select-demo");
        drop.click();
        assertEquals(dropdown.size(),8);
        for (WebElement i:dropdown){
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(500);
        }
        //website test is broken! something to do with javascript??? select all isn't working
    }

    @Test
    public void inputFormSubmitTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        Thread.sleep(2000);
        WebElement first_name = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input"));
        first_name.click();
        first_name.sendKeys("Karolina");
        Thread.sleep(500);
        WebElement last_name = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input"));
        last_name.click();
        last_name.sendKeys("Dudek");
        Thread.sleep(500);
        WebElement email = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input");
        email.click();
        email.sendKeys("firstname.lastname@gmail.com");
        Thread.sleep(500);
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input"));
        phone.click();
        phone.sendKeys("4242564");
        Thread.sleep(500);
        WebElement address = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input");
        address.click();
        address.sendKeys("420 Wherever");
        Thread.sleep(500);
        WebElement city = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input"));
        city.click();
        city.sendKeys("Manchester");
        Thread.sleep(500);
        new Select(driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select")).selectByVisibleText("daho");
        Thread.sleep(500);
        WebElement zip = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input");
        zip.click();
        zip.sendKeys("W3 3D");
        Thread.sleep(500);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        WebElement site = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input");
        site.click();
        site.sendKeys("cornhub.com");
        Thread.sleep(500);
        WebElement yes = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[1]/label/input");
        yes.click();
        Thread.sleep(500);
        WebElement no = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[2]/label/input");
        no.click();
        Thread.sleep(500);
        WebElement desc = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea");
        desc.click();
        desc.sendKeys("Form fullfilment");
        Thread.sleep(2000);
        WebElement send = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[13]/div/button");
        send.click();
        Thread.sleep(1000);
        // This is highly inefficient but I couldn't get it to work with loops
    }

    @Test
    public void ajaxFormSubmitTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
    }

    @Test
    public void jquerySelectDropdownTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
    }

    @Test
    public void bootstrapDatePickerTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    }

    @Test
    public void jqueryDatePickerTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
    }

    @Test
    public void tablePaginationTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
    }

    @Test
    public void tableSearchFilterTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    @Test
    public void tableSortAndSearchTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
    }

    @Test
    public void tableDataDownloadTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
    }

    @Test
    public void jqueryDownloadProgressBarsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    }

    @Test
    public void bootstrapProgressBarsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
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
    public void bootstrapAlertsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
    }

    @Test
    public void bootstrapModalsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
    }

    @Test
    public void windowsPopupModalTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
    }

    @Test
    public void progressBarModal() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
    }

    @Test
    public void javascriptAlertsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");
    }

    @Test
    public void bootstrapListBoxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");
    }

    @Test
    public void jqueryListBoxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html");
    }

    @Test
    public void dataListFilterTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/data-list-filter-demo.html");
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

    @Test
    public void dynamicDataLoadingTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
    }

    @Test
    public void chartsDemoTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/charts-mouse-hover-demo.html");
    }
}
