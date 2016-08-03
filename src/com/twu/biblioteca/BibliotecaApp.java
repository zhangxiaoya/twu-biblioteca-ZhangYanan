package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        IWelcome welcomeGen = new Welcome();
        welcomeGen.printWelcomeMsg();

        BookSheet bookSheet = initBookSheet();

        printBookList(bookSheet);

    }

    private static void printBookList(BookSheet bookSheet) {
        System.out.println("The Following is Book List: ");
        List<IBook> currentBookList = bookSheet.getBookList();
        for(int i=0;i<currentBookList.size();++i){
            System.out.print(String.format("%4d",((Book)currentBookList.get(i)).getId()));
            System.out.print(" ==> ");
            System.out.print(String.format("%-30s",((Book)currentBookList.get(i)).getName()));
            System.out.print(String.format("%-20s",((Book)currentBookList.get(i)).getAuthor()));
            System.out.print(String.format("%-10s",((Book)currentBookList.get(i)).getPublishYear().toString()));
            System.out.println();
        }
    }

    private static BookSheet initBookSheet() {
        ArrayList<IBook> initBookList = new ArrayList<IBook>();
        initBookList.add(new Book(1,"first book","yan,zhang", new Date(20140902)));
        initBookList.add(new Book(2,"second book","yan,zhang", new Date(20150902)));
        initBookList.add(new Book(3,"third book","yan,zhang", new Date(20160902)));
        return new BookSheet(initBookList);
    }
}
