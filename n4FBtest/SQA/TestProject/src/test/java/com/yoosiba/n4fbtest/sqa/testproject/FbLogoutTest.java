/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoosiba.n4fbtest.sqa.testproject;

import com.yoosiba.n4fbtest.sqa.testapi.LogicalLayer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author ereb
 */
@RunWith(ConcordionRunner.class)
public class FbLogoutTest {

    private LogicalLayer app = new LogicalLayer();

    @Before
    public void initEnv() {
        try {
            this.app.setUp();
            this.app.loadWebApp("http://www.facebook.com");
            this.app.performLogin();
        } catch (Exception ex) {
            Logger.getLogger(FbLogoutTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void cleanupEnv() {
        try {
            this.app.tearDown();
        } catch (Exception ex) {
            Logger.getLogger(FbLogoutTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isLoginPageLoaded() throws Exception {
        try {
            return this.app.isLoginPageLoaded();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String getUserName() throws Exception {
        try {
            return this.app.getUserName();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void loadUserMenu() throws Exception {
        try {
            this.app.loadUserMenu();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public void logout() throws Exception {
        try {
            this.app.logout();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
