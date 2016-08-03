package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by yanzhang on 8/3/16.
 */
public class WelcomeTest {

    private Welcome welcomeGen = new Welcome();

    @Test
    public void should_print_welcomeMessage() throws Exception{
        welcomeGen.printWelcomeMsg();

        assertNotNull(welcomeGen.getWelcomeMsg());
    }

}