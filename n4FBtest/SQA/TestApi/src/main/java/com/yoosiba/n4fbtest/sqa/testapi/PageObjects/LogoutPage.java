/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author ereb
 */
public class LogoutPage {

    @FindBy(how = How.XPATH, using = "//input[@value='Logout']")
    WebElement buttonLogin;
    
    
    public void doLogin() {
        buttonLogin.click();
    }
}
