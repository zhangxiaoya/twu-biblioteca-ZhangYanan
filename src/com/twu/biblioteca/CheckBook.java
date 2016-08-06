package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/5/16.
 */
public class CheckBook {

    public static void checkOut(BookSheet bookSheet,long bookId){

        if(bookSheet.checkedOutOneBook(bookId)){
            System.out.println("Thank you! Enjoy the book");
        }
        else{
            System.out.println("That book is not available.");
        }
    }
}
