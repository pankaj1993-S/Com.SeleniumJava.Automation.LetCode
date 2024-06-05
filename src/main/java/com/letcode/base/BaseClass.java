package com.letcode.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/letcode/config/letcodeconfig.properties");
            prop.load(ip);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    public static void initialization() throws InterruptedException {

        String browserName = prop.getProperty("browser");
        System.out.println("Execution Started..........");
        if(browserName.equals("chrome")) {
            System.out.println("Chrome Browser Launched..........");
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
            driver =new ChromeDriver();
        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
            driver =new FirefoxDriver();
        }
        System.out.println("Browser Maximized..........");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Waiting Page to load..........");
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PageLoadWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("ImplicitWait")), TimeUnit.SECONDS);
        System.out.println("Enter URL into browser..........");
        Thread.sleep(5000);
        driver.get(prop.getProperty("url"));

    }

}

