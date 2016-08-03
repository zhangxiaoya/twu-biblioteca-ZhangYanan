package com.twu.biblioteca;

import java.util.List;
import java.util.*;

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
            System.out.print(((Book)currentBookList.get(i)).getId());
            System.out.print("--");
            System.out.print(((Book)currentBookList.get(i)).getName());
            System.out.println();
        }
    }

    private static BookSheet initBookSheet() {
        ArrayList<IBook> initBookList = new ArrayList<IBook>();
        initBookList.add(new Book(1,"first book"));
        initBookList.add(new Book(2,"second book"));
        initBookList.add(new Book(3,"third book"));
        return new BookSheet(initBookList);
    }
}
