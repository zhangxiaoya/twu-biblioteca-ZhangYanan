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

        List<IBook> bookListWithoutChecked = new ArrayList<IBook>();
        Book tmpIndex = new Book();
        for(int i =0;i<bookList.size();++i){
            tmpIndex = (Book) bookList.get(i);
            if(!tmpIndex.getCheckedOut()){
                bookListWithoutChecked.add(tmpIndex);
            }
        }
        return bookListWithoutChecked;
    }

    public boolean checkedOutOneBook(long bookId){
        for(int i=0;i<bookList.size();++i){
            if(((Book)bookList.get(i)).getId() ==bookId){
                ((Book)bookList.get(i)).setCheckedOut(true);
                return true;
            }
        }
        return false;
    }
}
