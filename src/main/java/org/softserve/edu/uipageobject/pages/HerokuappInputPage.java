package org.softserve.edu.uipageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappInputPage {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@type='number']")
    WebElement inputField;

    public HerokuappInputPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnInputLinkInRightBar(){
        driver.findElement(By.xpath("//*[@id='content']/ul/li[27]/a")).click();
    }

    /*
    Navigate to the Inputs page
     */
    public HerokuappInputPage navigateToInputsPage() {
        clickOnInputLinkInRightBar();
        return new HerokuappInputPage(driver);
    }

    /*
    Input text into input field
     */
    public void setInputText(String text){
        this.inputField.sendKeys(text);
    }

    /*
    Verify text displayed
     */
    public String getTextFromInput(){
        return this.inputField.getAttribute("value");
    }


}
