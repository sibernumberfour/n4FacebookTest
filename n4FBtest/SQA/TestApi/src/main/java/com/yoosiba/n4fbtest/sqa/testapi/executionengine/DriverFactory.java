/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi.executionengine;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author ereb
 */
public interface DriverFactory {
    
    public WebDriver CreateDriver() throws Exception ;
    
}
