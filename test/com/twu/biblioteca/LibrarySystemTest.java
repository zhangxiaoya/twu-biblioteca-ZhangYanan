package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by yanzhang on 8/3/16.
 */
public class LibrarySystemTest {

    private final ByteArrayOutputStream outContend = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContend = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContend));
        System.setErr(new PrintStream(errContend));
    }

    @Test
    public void should_get_command_list_contain_List_Books_Command() throws Exception {
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("List Books"));
    }

    @Test
    public void should_get_command_list_contain_Check_Book_Command() throws Exception {
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("Check Book"));
    }

    @Test
    public void should_get_invalid_message_when_input_invalid_Command() throws Exception{

        String mockInput = "001-0001\n"
                + "abc123\n"
                + "other\n"
                + "Quit\n";
        ByteArrayInputStream mockIn = new ByteArrayInputStream(mockInput.getBytes());
        LibrarySystem system = new LibrarySystem();

        System.setIn(mockIn);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("Select a valid option!",outputList[outputList.length -2]);

        System.setIn(System.in);
    }

    @Test
    public void should_get_command_list_contain_Quit_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("Quit"));
    }

    @Test
    public void should_print_bookList_when_input_List_Books_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();

        String mockInput  = "001-0001\n"
                + "abc123\n"
                + "List Books\n"
                + "Quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        assertTrue(isPrintBookList());
        System.setIn(System.in);
    }

    @Test
    public void should_print_successfully_info_when_check_book_out_success() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                         + "abc123\n"
                         + "Check Book 1\n"
                         + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("Thank you! Enjoy the book.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_print_unsuccessfully_info_when_check_book_out_failed() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                         + "abc123\n"
                         + "Check Book 4\n"
                         + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("That book is not available.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_get_command_list_contain_Return_Book_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("Return Book"));
    }

    @Test
    public void should_print_successfully_info_when_check_book_return_success() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                         + "abc123\n"
                         + "Check Book 3\n"
                         + "Return Book 3\n"
                         + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("Thank you for returning the book.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_print_unsuccessfully_info_when_check_book_return_failed() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                + "abc123\n"
                + "Check Book 3\n"
                + "Return Book 4\n"
                + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("That is not a valid book to return.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_get_command_list_contain_List_Movies_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();

        ArrayList<String> commandList = system.getCommandList();
        assertTrue(commandList.contains("List Movies"));
    }

    @Test
    public void should_print_moviesList_when_input_List_Movies_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();

        String mockInput  = "001-0001\n"
                + "abc123\n"
                + "List Movies\n"
                + "Quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        assertTrue(isPrintMovieList());
        System.setIn(System.in);
    }

    @Test
    public void should_print_login_promot_message() throws Exception{
        LibrarySystem system = new LibrarySystem();

        String mockInput = "\n"
                         + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String outputList = outContend.toString();
        assertTrue(outputList.contains("Library Number: "));
        assertTrue(outputList.contains("Password: "));

        System.setIn(System.in);
    }

    @Test
    public void should_print_login_error_message_when_input_wrong_library_number() throws Exception{
        LibrarySystem system = new LibrarySystem();

        String mockInput = "001-0002\n"
                         + "00000\n"
                         + "\n"
                         + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertTrue(outputList[outputList.length-2].contains("Library Number or Password Wrong!"));

        System.setIn(System.in);
    }

    @Test
    public void should_get_command_list_contain_Show_Profile_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();
        ArrayList<String> commandList = system.getCommandList();

        assertTrue(commandList.contains("Show Profile"));
    }

    @Test
    public void should_get_current_user_profile_when_login_use_001_0001() throws Exception{
        LibrarySystem system = new LibrarySystem();

        String mockInput = "001-0001\n"
                         + "abc123\n"
                         + "List Books\n"
                         + "Show Profile\n"
                         + "Quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();


        String[] outputList = outContend.toString().split("\n");

        assertTrue(outputList[outputList.length-2].contains("Phone Number: 1234567890"));
        assertTrue(outputList[outputList.length-3].contains("Email: abc@gmail.com"));
        assertTrue(outputList[outputList.length-4].contains("Name: ZhangSan"));
        assertTrue(outputList[outputList.length-5].contains("User Id: 1"));

        System.setIn(System.in);

    }

    @Test
    public void should_get_command_list_contain_Check_Moive_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();
        ArrayList<String> commandList = system.getCommandList();

        assertTrue(commandList.contains("Check Moive"));
    }

    @Test
    public void should_get_command_list_contain_Return_Moive_Command() throws Exception{
        LibrarySystem system = new LibrarySystem();
        system.initSystem();
        ArrayList<String> commandList = system.getCommandList();

        assertTrue(commandList.contains("Return Moive"));
    }


    @Test
    public void should_print_successfully_info_when_check_moive_out_success() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                + "abc123\n"
                + "Check Moive 1\n"
                + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("Thank you! Enjoy the moive.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_print_unsuccessfully_info_when_check_moive_out_failed() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                + "abc123\n"
                + "Check Moive 4\n"
                + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("That moive is not available.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }


    @Test
    public void should_print_successfully_info_when_check_moive_return_success() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                + "abc123\n"
                + "Check Moive 3\n"
                + "Return Moive 3\n"
                + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("Thank you for returning the moive.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @Test
    public void should_print_unsuccessfully_info_when_check_moive_return_failed() throws Exception{
        LibrarySystem system = new LibrarySystem();
        String mockInput = "001-0001\n"
                + "abc123\n"
                + "Check Moive 3\n"
                + "Return Moive 4\n"
                + "quit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        system.initSystem();
        system.run();

        String[] outputList = outContend.toString().split("\n");
        assertEquals("That is not a valid moive to return.",outputList[outputList.length - 2]);

        System.setIn(System.in);
    }

    @After
    public void resetStreams(){
        System.setOut(System.out);
        System.setErr(System.err);
    }

    private boolean isPrintBookList(){

        String[] outPutList =  outContend.toString().split("\n");

        if(!outPutList[outPutList.length-5].contains("The Following is Book List: ")) return false;
        if(!outPutList[outPutList.length-4].contains("1 ==> first book                    yan,zhang           Thu Jan 01 13:35:40 CST 1970")) return false;
        if(!outPutList[outPutList.length-3].contains("2 ==> second book                   yan,zhang           Thu Jan 01 13:35:50 CST 1970")) return false;
        if(!outPutList[outPutList.length-2].contains("3 ==> third book                    yan,zhang           Thu Jan 01 13:36:00 CST 1970")) return false;

        return true;
    }

    private boolean isPrintMovieList(){

        String[] outPutList =  outContend.toString().split("\n");

        if(!outPutList[outPutList.length-5].contains("The Following is Moive List: ")) return false;
        if(!outPutList[outPutList.length-4].contains("1 ==> Thu Jan 01 13:35:40 CST 1970  Zhang San      1")) return false;
        if(!outPutList[outPutList.length-3].contains("2 ==> Thu Jan 01 13:35:50 CST 1970  Lee Si         2")) return false;
        if(!outPutList[outPutList.length-2].contains("3 ==> Thu Jan 01 13:36:00 CST 1970  Wang Wu        3")) return false;

        return true;
    }

}