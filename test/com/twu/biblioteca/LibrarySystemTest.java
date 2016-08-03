package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


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

}