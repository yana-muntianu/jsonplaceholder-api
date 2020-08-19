package org.softserve.edu.uipageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappCheckboxesPage {

    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='checkboxes']/input[1]")
    WebElement checkbox;

    public HerokuappCheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckboxesLinkInRightBar() {
        driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a")).click();
    }

    /*
    Navigate to the Checkboxes page
     */
    public HerokuappCheckboxesPage navigateToCheckboxesPage() {
        clickOnCheckboxesLinkInRightBar();
        return new HerokuappCheckboxesPage(driver);
    }

    /*
    Tick unchecked checkbox
     */
    public void tickCheckbox(){
        this.checkbox.click();
    }

    /*
    Verify checkbox status
     */
    public boolean isCheckboxChecked(){
        return checkbox.isSelected();
    }


}

