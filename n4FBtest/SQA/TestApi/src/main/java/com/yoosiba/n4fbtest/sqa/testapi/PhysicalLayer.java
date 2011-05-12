/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi;

import com.yoosiba.n4fbtest.sqa.testapi.PageObjects.LoginPage;
import com.yoosiba.n4fbtest.sqa.testapi.PageObjects.LogoutPage;
import com.yoosiba.n4fbtest.sqa.testapi.PageObjects.MainPage;
import com.yoosiba.n4fbtest.sqa.testapi.PageObjects.NewsPage;
import com.yoosiba.n4fbtest.sqa.testapi.executionengine.LocalDriverFactory;
import com.yoosiba.n4fbtest.sqa.testapi.executionengine.RemoteDriverFactory;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 *
 * @author ereb
 */
public class PhysicalLayer {

    WebDriver driver = null;
    LoginPage pageLogin = new LoginPage();
    LogoutPage pageLogout = new LogoutPage();
    MainPage pageMain = new MainPage();
    NewsPage pageNews = new NewsPage();

    public void setUp() throws Exception {
        driver = initEnv();
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    public boolean isBrowserReady() {
        boolean res = false;
        if (this.driver != null) {
            res = true;
        }
        return res;
    }

    public void loadHomePage(String url) {
        driver.get(url);
        PageFactory.initElements(driver, this.pageLogin);
    }

    public boolean isLoginPageLoaded() {
        return this.driver.getTitle().equals("Welcome to Facebook - Log In, Sign Up or Learn More");
    }

    public void enterEmail(String email) {
        this.pageLogin.setEmail(email);
    }

    public void enterPassword(String pass) {
        this.pageLogin.setPass(pass);
    }

    public void clickLogin() {
        this.pageLogin.clickLogin();
        PageFactory.initElements(driver, this.pageMain);
    }

    public boolean checkHomePageURL() {
        return this.driver.getCurrentUrl().equals(this.pageMain.getUrl());
    }

    public String getUserName() {
        return this.pageMain.getUsername();
    }

    public void clickUserMenu() {
        this.pageMain.clickUserMenu();
    }

    public void logout() {
        PageFactory.initElements(driver, this.pageLogout);
        this.pageLogout.doLogin();
    }

    public boolean loadNewsPage() {
        driver.get("http://www.facebook.com/?sk=nf");
//        driver.get("http://www.facebook.com/?sk=wall");


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String jsScript = " function formfocus() { document.getElementByName('xhpc_message').focus(); }";
        jsExecutor.executeScript(jsScript);
        PageFactory.initElements(driver, this.pageNews);
        return driver.getCurrentUrl().equalsIgnoreCase(this.pageNews.getUrl());
//        return true;
    }

    public String getStatus() {
        return this.pageNews.getMessageBody();
    }

    public void postStatus(String status) throws Exception {

        this.pageNews.setStatus(status);
        this.pageNews.clickShare();

    }

    private WebDriver initEnv() throws Exception {
        WebDriver driver;
//        driver = (new LocalDriverFactory().withBrowserType("firefox")).CreateDriver();
//        driver = (new LocalDriverFactory().withBrowserType("htmlunit")).CreateDriver();


        //DesiredCapabilities capabillities = new DesiredCapabilities("internet explorer", "9", Platform.WINDOWS);
//    driver = (new RemoteDriverFactory().withBrowserType("firefox").withBrowserVersion("4").withPlatform("windows").withServerURL("http://127.0.0.1:4444/wd/hub")).CreateDriver();

//                    DesiredCapabilities capabillities = new DesiredCapabilities("firefox", "3.6.", Platform.WINDOWS);
//    capabillities.setCapability("username", "sibernumberfour");
//    capabillities.setCapability("accessKey", "8014610e-c21c-4ab2-9ae1-36843f91881a");
//    capabillities.setCapability("name", "Hello, Sauce OnDemand!");
//    WebDriver driver = new RemoteWebDriver(new URL("http://sibernumberfour:8014610e-c21c-4ab2-9ae1-36843f91881a@ondemand.saucelabs.com:80/wd/hub"), capabillities);


        driver = (new RemoteDriverFactory()
                                        .withBrowserType("firefox")
                                        .withBrowserVersion("4")
                                        .withPlatform("vista")
                                        .withServerURL("http://sibernumberfour:8014610e-c21c-4ab2-9ae1-36843f91881a@ondemand.saucelabs.com:80/wd/hub")
                                        .withCapability("username", "sibernumberfour")
                                        .withCapability("accessKey", "8014610e-c21c-4ab2-9ae1-36843f91881a")
                                        ).CreateDriver();



        return driver;
    }
}
