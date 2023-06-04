package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumHomeWork {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expected = driver.getTitle();
        String actual = "Web Orders Login";
        Assert.assertEquals(expected, actual);

        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Web Orders");
        String expected2 = driver.getTitle();
        String actual2 = "Web Orders";
        Assert.assertEquals(expected2, actual2);
        WebElement PageName = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(PageName);
        String expectedHeader= "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);
        WebElement allProducts = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        System.out.println(allProducts.getText());
        allProducts.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        System.out.println(driver.getCurrentUrl());
        String url = driver.getCurrentUrl();
        String actualUrl= "Products";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertTrue(expectedUrl.contains(actualUrl));
/*
Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"

Validate the url has "Products" keyword
     */

    }
    @Test
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");


        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);

        WebElement allOrders=driver.findElement(By.xpath(  "//a[.='View all orders' ]"));
        WebElement allProducts=driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orders=driver.findElement(By.xpath(  "//a[.= 'Order']"));

        String value1 = allOrders.getAttribute("href");
        String value2 = allProducts.getAttribute("href");
        String value3 = orders.getAttribute ("href");


        Assert.assertTrue(value1.contains("Default.aspx"));
        Assert.assertTrue(value2.contains("Products.aspx"));
        Assert.assertTrue(value3.contains("Process.aspx"));

    }
    @Test
    public void practice4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement UserName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        UserName.sendKeys("Tester");
        WebElement Password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        Password.sendKeys("test");
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        BrowserUtils.clickWithJs(driver, clickButton);
        Thread.sleep(2000);
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(product, "ScreenSaver", "value");
        WebElement quanity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quanity.sendKeys("5");
        Thread.sleep(2000);
        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys("2200 E devon");
        Thread.sleep(2000);
        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys("Des Plaines");
        Thread.sleep(2000);
        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys("Illinois");
        Thread.sleep(2000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCode.sendKeys("60018");
        Thread.sleep(2000);
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        Thread.sleep(2000);
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(2000);
        WebElement experationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        experationDate.sendKeys("03/24");
        Thread.sleep(2000);
        WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        process.click();
        Thread.sleep(2000);
        WebElement successmessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successmessage.isDisplayed());
        WebElement allOrders = driver.findElement(By.linkText("View all orders"));
        BrowserUtils.clickWithJs(driver, allOrders);
        Thread.sleep(2000);
        List<WebElement> allOredrs = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "06/03/2023",
                "2200 E devon", "Des Plaines", "Illinois",
                "60018", "MasterCard", "444993876233", "03/24");
        for (int i = 1; i < actualList.size(); i++) {
            actualList.add(allOredrs.get(i).getText());
            if (allOredrs.get(i).getText().equals("03/24")) {
                break;
            }
            System.out.println(actualList);
            Assert.assertEquals(actualList, expectedList);


        }
    }
}

