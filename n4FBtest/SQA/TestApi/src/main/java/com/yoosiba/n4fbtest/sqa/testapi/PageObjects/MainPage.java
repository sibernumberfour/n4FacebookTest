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
public class MainPage {

    String ulr = "http://www.facebook.com/home.php";
    
    @FindBy(how = How.CSS, using = "a.fbxWelcomeBoxName")
    WebElement divWelcomeBox;
    @FindBy(how = How.CSS, using = "a#navAccountLink")
    WebElement userMenu;

    public String getUrl() {
        return this.ulr;
    }

    public String getUsername() {
        return this.divWelcomeBox.getText();
    }

    public void clickUserMenu() {
        this.userMenu.click();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
