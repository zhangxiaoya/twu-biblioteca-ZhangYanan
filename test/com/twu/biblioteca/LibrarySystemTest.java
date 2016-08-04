package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by yanzhang on 8/3/16.
 */
public class LibrarySystemTest {
    @Test
    public void should_get_command_list_contain_ListBooks() throws Exception {
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("List Books"));
    }


    @Test
    public void should_get_invalid_message_when_input_not_a_option() throws Exception{

        String mockInput = "sss\n0";
        ByteArrayInputStream mockIn = new ByteArrayInputStream(mockInput.getBytes());
        LibrarySystem system = new LibrarySystem();

        System.setIn(mockIn);

        system.initSystem();
        system.run();

        System.setIn(System.in);
        assertEquals("Select a valid option!",system.getLastErrorMsg());
    }

    @Test
    public void should_get_command_list_contain_Quit() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("Quit"));
    }

}