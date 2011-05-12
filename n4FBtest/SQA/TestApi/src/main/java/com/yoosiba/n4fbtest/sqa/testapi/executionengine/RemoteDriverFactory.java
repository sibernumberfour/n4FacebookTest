/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi.executionengine;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author ereb
 */
public class RemoteDriverFactory implements DriverFactory {

    private String serverURL;
    private String browserType;
    private String browserVersion;
    private Platform platformType;
    
    private HashMap capabilitiesProperties = new HashMap();

    public WebDriver CreateDriver() throws Exception {

        WebDriver driver = null;
        try {
            DesiredCapabilities capabillities = new DesiredCapabilities(this.browserType, this.browserVersion, this.platformType);
            
            Set entrySet = this.capabilitiesProperties.entrySet();
            Iterator it = entrySet.iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                capabillities.setCapability((String) entry.getKey(), (String) entry.getValue());
            }
            
            
            
            driver = new RemoteWebDriver(new URL(this.serverURL), capabillities);
        } catch (Exception ex) {
            throw ex;
        }
        return driver;
    }

    public RemoteDriverFactory withServerURL(String url) {
        this.serverURL = url;
        return this;
    }

    public RemoteDriverFactory withPlatform(String platform) {

        //jdk7 required
//        switch (platform) {
//
//        }

        if (platform == "windows") {
            this.platformType = Platform.WINDOWS;
        } else if(platform == "vista"){
            this.platformType = Platform.VISTA;
        };
        return this;
    }

    public RemoteDriverFactory withBrowserType(String browserType) {
        this.browserType = browserType;
        return this;
    }

    public RemoteDriverFactory withBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
        return this;
    }
    public RemoteDriverFactory withCapability(String key, String value) {
        this.capabilitiesProperties.put(key, value);
        return this;
    }
    

}
