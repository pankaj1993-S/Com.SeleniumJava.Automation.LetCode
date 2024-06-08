package com.letcode.testcases;

import com.letcode.base.BaseClass;
import com.letcode.pages.LoginPage;
import org.apache.log4j.Priority;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    LoginPage loginpage;

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginpage = new LoginPage();
        loginpage.loginToPage(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = -1)
    public void loginPageTitleTest() {
        String title = loginpage.validateTitleLoginPage();
        Assert.assertEquals(title, "LetCode - Testing Hub");
        System.out.println("Title of the Page :" + title);

    }

    @Test(priority = -2)
    public void validatelogoOfThePage() {
        boolean flag = loginpage.validateLogo();
        Assert.assertTrue(flag, "Page Logo Displayed");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
