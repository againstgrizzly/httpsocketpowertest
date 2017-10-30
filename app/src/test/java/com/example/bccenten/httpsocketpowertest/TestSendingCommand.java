package com.example.bccenten.httpsocketpowertest;

import org.junit.After;
import org.junit.Before;

/**
 * Created by bccenten on 10/30/2017.
 */

public class TestSendingCommand {

    String command;

    @Before
    public void setup(){
        String command = "{\"yo\": 9}";
    }

    @After
    public void teardown(){

    }

}
