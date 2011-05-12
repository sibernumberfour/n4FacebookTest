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
public class FbPostStatusTest {

    private LogicalLayer app = new LogicalLayer();

    @Before
    public void initEnv() {
        try {
            this.app.setUp();
            this.app.loadWebApp("http://www.facebook.com");
            this.app.performLogin();
        } catch (Exception ex) {
            Logger.getLogger(FbPostStatusTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void cleanupEnv() {
        try {
            this.app.tearDown();
        } catch (Exception ex) {
            Logger.getLogger(FbPostStatusTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public String getUserName() throws Exception {
        try {
            return this.app.getUserName();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public boolean loadNewsPage() throws Exception {
        try {
            return this.app.loadNewsPage();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void postStatus(String status) throws Exception{
        try {
            this.app.postStatus(status);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public String getStatus() throws Exception {
        try {
            return this.app.getStatus();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
