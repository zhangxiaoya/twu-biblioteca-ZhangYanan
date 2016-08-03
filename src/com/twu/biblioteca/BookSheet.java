package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanzhang on 8/2/16.
 */
public class BookSheet implements IBookSheet {

    private List<IBook> bookList;

    public BookSheet(){
        bookList = new ArrayList<IBook>();
    }

    public BookSheet(List<IBook> booklist){
        bookList = new ArrayList<IBook>();
        for(int i =0;i<booklist.size();++i){
            bookList.add(booklist.get(i));
        }
    }

    public List<IBook> getBookList(){
        return bookList;
    }

}
