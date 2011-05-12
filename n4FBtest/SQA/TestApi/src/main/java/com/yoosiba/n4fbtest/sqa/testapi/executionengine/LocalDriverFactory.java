/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi.executionengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author ereb
 */
public class LocalDriverFactory implements DriverFactory {

    public enum BrowserType {
        IE,
        FF,
        HtmlUnit
    };
        private BrowserType browser;

    public WebDriver CreateDriver() throws Exception {
        WebDriver driver = null;
        try {
            switch (this.browser) {
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                case FF:
                    driver = new FirefoxDriver();
                    break;
                case HtmlUnit:
                    driver = new HtmlUnitDriver();
                    break;
                default:
                    break;
            }
            if (driver == null) {
                throw new Exception("Local driver not initialised correctly");
            }
        } catch (Exception ex) {
            throw ex;
        }
        return driver;
    }

    public LocalDriverFactory withBrowserType(String browserType) {
        //jdk7 required
//        switch (browserType) {
//
//        }

        if (browserType.equalsIgnoreCase("IE") || browserType.equalsIgnoreCase("InternetExplorer")) {
            this.browser = BrowserType.IE;
        } else if(browserType.equalsIgnoreCase("FF") || browserType.equalsIgnoreCase("FireFox")) {
            this.browser = BrowserType.FF;
        } else if(browserType.equalsIgnoreCase("HtmlUnit")) {
            this.browser = BrowserType.HtmlUnit;
        }
        return this;
    }
}

