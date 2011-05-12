package com.yoosiba.n4fbtest.sqa.testapi;

import com.yoosiba.n4fbtest.sqa.testapi.executionengine.LocalDriverFactory;
import com.yoosiba.n4fbtest.sqa.testapi.executionengine.RemoteDriverFactory;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Hello world!
 *
 */
public class LogicalLayer {

    PhysicalLayer physical;

    public void setUp() throws Exception {
        this.physical = new PhysicalLayer();
        this.physical.setUp();
    }

    public void tearDown() throws Exception {
        this.physical.tearDown();
    }

    public boolean isReady() {
        return this.physical.isBrowserReady();
    }

    public void loadWebApp(String url) {
        this.physical.loadHomePage(url);
    }

    public boolean isLoginPageLoaded() {
        return this.physical.isLoginPageLoaded();
    }

    public void performLogin() {
        this.physical.enterEmail("sibernumberfour@yoosiba.com");
        this.physical.enterPassword("fb n4 testing");
        this.physical.clickLogin();
    }

    public boolean isHomePageLoaded() {
        return this.physical.checkHomePageURL();
    }

    public String getUserName() {
        return this.physical.getUserName();
    }

    public void loadUserMenu() {
        this.physical.clickUserMenu();
    }

    public void logout() {
        this.physical.logout();
    }

    public boolean loadNewsPage() {
        return this.physical.loadNewsPage();
    }

    public String getStatus() {
        return this.physical.getStatus();
    }

    public void postStatus(String status) throws Exception {
        this.physical.postStatus(status);
    }
}
