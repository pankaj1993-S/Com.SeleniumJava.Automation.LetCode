package com.letcode.pages;

import com.letcode.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@id='testing']")
    WebElement lnkworkpsce;

    @FindBy(xpath = "//a[normalize-space()='Product']")
    WebElement lnkproduct;

    @FindBy(xpath = "//*[@data-icon='home']")
    WebElement icnHome;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public ProductPage clickOnProductPage() {
        lnkproduct.click();
        return new ProductPage();
    }

    public WorkspacePage clickOnWorkspacePage() {
        lnkworkpsce.click();
        return new WorkspacePage();
    }

    public HomePage clickOnHomePage() {
        icnHome.click();
        return new HomePage();
    }


}
