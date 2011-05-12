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
public class LoginPage {

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    WebElement fieldEmail;
    @FindBy(how = How.ID, using = "pass")
    WebElement fieldPass;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    WebElement buttonLogin;
    
    

    public void setEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    public void setPass(String pass) {
        fieldPass.sendKeys(pass);
    }

    public void clickLogin() {
        buttonLogin.click();
    }
}
