/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testapi.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author ereb
 */
public class NewsPage {

    String ulr = "http://www.facebook.com/?sk=nf";
    @FindBy(how = How.CLASS_NAME, using = "messageBody")
    WebElement divMessageBody;
    @FindBy(how = How.ID_OR_NAME, using = "xhpc_message")
    WebElement divStatus;
    @FindBy(how = How.XPATH, using = "//input[@value='Share']")
    WebElement buttonShare;

    private WebDriver driver = null;
    
    public String getUrl() {
        return this.ulr;
    }

    public String getMessageBody() {
//       System.out.println("getMessageBodyPresence:  " + this.divMessageBody.isEnabled()); 
//       System.out.println("getMessageBodyTesxt:  " + this.divMessageBody.getText()); 
//       System.out.println("getMessageBodyValue:  " + this.divMessageBody.getValue()); 
        
        
        
        return this.divMessageBody.getText();
    }

    public void setStatus(String status) {
        divStatus.sendKeys(status);
    }

    public void clickShare() {
        buttonShare.click();
    }
    
}
