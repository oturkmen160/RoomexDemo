package com.roomex.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    //preventing Driver object creation
    private Driver(){}

    private static WebDriver driver;


    public static WebDriver get(){
        if(driver==null){
            String browser = ConfigurationReader.get("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if(!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException(("Your OS doesn't support Internet Explorer"));
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    if(!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException(("Your OS doesn't support Internet Explorer"));
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                case "safari":
                    if(!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "remote-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("platform","Platform.ANY");
                    try {
                        driver = new RemoteWebDriver(new URL(ConfigurationReader.get("remoteURL")),
                                chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
