package com.letcode.pages;

import com.letcode.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BaseClass {

    public static Properties prop;

    // Page Factory
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement linklogIn;

    @FindBy(xpath = "//input[@name='email']")
    WebElement userid;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwd;

    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    WebElement btnlogin;

    @FindBy(xpath = "//img[contains(@alt,'letcode')]")
    WebElement imglogo;

    //Initilizing the Page Object
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateTitleLoginPage() {
        return driver.getTitle();
    }

    public boolean validateLogo() {
        return imglogo.isDisplayed();
    }

    public void loginToPage(String un, String pwd) {
        linklogIn.click();
        userid.sendKeys(un);
        passwd.sendKeys(pwd);
        btnlogin.click();
    }
}
