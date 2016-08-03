package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by yanzhang on 8/2/16.
 */
public class BookSheetTest {
    BookSheet bookSheet;

    @Test
    public void when_get_bookList_from_bookSheet_should_get_a_book_list() throws Exception{
        bookSheet = new BookSheet();
        assertNotNull(bookSheet.getBookList());
    }
    @Test
    public void when_bookSheet_is_empty_should_return_empty_list() throws Exception {
        bookSheet = new BookSheet();
        List<IBook> bookList = bookSheet.getBookList();
        assertEquals(0,bookList.size());
    }

    @Test
    public void when_bookSheet_is_not_empty_should_return_book_list() throws Exception {
        List<IBook> testList = new ArrayList<IBook>();
        testList.add(new Book(1,"first book"));
        testList.add(new Book(2,"second book"));
        testList.add(new Book(3,"third book"));

        bookSheet = new BookSheet(testList);
        List<IBook> bookList = bookSheet.getBookList();
        assertEquals(3,bookList.size());

        Book[] array = (Book[]) bookList.toArray(new Book[bookList.size()]);
        assertArrayEquals(testList.toArray(),array);
    }
}