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

    public static void checkReturn(BookSheet bookSheet, long bookId){
        if(bookSheet.checkedReturnOneBook(bookId)){
            System.out.println("Thank you for returning the book.");
        }
        else{
            System.out.println("That is not a valid book to return.");
        }
    }
}
