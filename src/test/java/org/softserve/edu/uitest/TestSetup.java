package org.softserve.edu.uitest;

import org.softserve.edu.commons.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestSetup {

    private WebDriver driver;

    @BeforeClass
    public void driverSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestProperties.getWaiterTimeout(), TimeUnit.SECONDS);
    }

    @AfterClass
    public void driverTearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver.get(TestProperties.getHomePageURL());
    }

    @AfterMethod
    public void tearDown() {
        driver.get(TestProperties.getHomePageURL());
    }

    public WebDriver getDriver() {
        return this.driver;
    }


}
