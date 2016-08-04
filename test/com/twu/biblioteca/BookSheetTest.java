package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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

        List<IBook> testList = mockBookList();
        mockBookSheet(testList);

        List<IBook> bookList = bookSheet.getBookList();
        assertEquals(3,bookList.size());

        Book[] array = (Book[]) bookList.toArray(new Book[bookList.size()]);
        assertArrayEquals(testList.toArray(),array);
    }

    @Test
    public void when_pint_book_list_should_get_the_details() throws Exception{
        List<IBook> testList = mockBookList();
        mockBookSheet(testList);

        List<IBook> bookList = bookSheet.getBookList();
        assertNotNull(((Book)bookList.get(0)).getAuthor());
        assertNotNull(((Book)bookList.get(0)).getPublishYear());
        assertNotNull(((Book)bookList.get(0)).getName());
    }


    @Test
    public void when_book_4_was_checkedout_should_not_show_in_book_sheet() throws Exception{
        List<IBook> testList = mockBookListWithOneCheckedOut();
        mockBookSheet(testList);

        List<IBook> bookList = bookSheet.getBookList();
        assertEquals(2,bookList.size());
    }

    @Test
    public void when_bookSheet_has_three_books_then_checkedout_one_book() throws Exception{
        List<IBook> testList = mockBookList();
        mockBookSheet(testList);

        List<IBook> bookList = bookSheet.getBookList();
        assertEquals(3,bookList.size());

        bookSheet.checkedOutOneBook(3);
        bookList = bookSheet.getBookList();
        assertEquals(2,bookList.size());
    }

    private void mockBookSheet(List<IBook> testList) {
        bookSheet = new BookSheet(testList);
    }

    private List<IBook> mockBookList() {
        List<IBook> testList = new ArrayList<IBook>();
        testList.add(new Book(1,"first book","yan,zhang", new Date(20140902)));
        testList.add(new Book(2,"second book","yan,zhang", new Date(20150902)));
        testList.add(new Book(3,"third book","yan,zhang", new Date(20160902)));
        return testList;
    }

    private List<IBook> mockBookListWithOneCheckedOut() {
        List<IBook> testList = new ArrayList<IBook>();
        testList.add(new Book(1,"first book","yan,zhang", new Date(20140902)));
        testList.add(new Book(2,"second book","yan,zhang", new Date(20150902)));
        Book checkedBook  = new Book(3,"third book","yan,zhang", new Date(20160902));
        checkedBook.setCheckedOut(true);
        testList.add(checkedBook);
        return testList;
    }
}