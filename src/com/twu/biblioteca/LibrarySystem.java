package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanzhang on 8/3/16.
 */
public class LibrarySystem {

    private IWelcome welcomeGen;
    private BookSheet bookSheet;

    private ArrayList<String> commandList;

    public void initSystem(){
        welcomeGen = new Welcome();
        bookSheet = initBookSheet();
        setCommandList();
    }

    public void run(){

        welcomeGen.printWelcomeMsg();

        printCommandList();

        System.out.println("Please input your choice(use the number):");
        Scanner scanner = new Scanner(System.in);
        String userInputMenu = scanner.next();

        while (!userInputMenu.isEmpty()){
            if(userInputMenu.equals("1")){
                printBookList(bookSheet);
                System.out.println("Please input your choice(use the number):");
            }
            else if(userInputMenu.equals("0")){
                System.out.println("Exsiting Online Library");
            }
            else{
                System.out.println("Invalid Input Command!");
                System.out.println("Please input your choice(use the number):");
            }
            userInputMenu = scanner.next();
        }
    }

    private void setCommandList(){
        commandList = new ArrayList<String>();
        commandList.add("List Books");
    }

    private void printCommandList(){
        System.out.println("System Menus: ");
        for(int i =0;i<commandList.size();++i){
            System.out.println(String.format("%4d  ->   %s",(i+1),commandList.get(i)));
        }
    }

    public ArrayList<String> getCommandList(){
        return commandList;
    }

    private void printBookList(BookSheet bookSheet) {
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

    private BookSheet initBookSheet() {
        ArrayList<IBook> initBookList = new ArrayList<IBook>();
        initBookList.add(new Book(1,"first book","yan,zhang", new Date(20140902)));
        initBookList.add(new Book(2,"second book","yan,zhang", new Date(20150902)));
        initBookList.add(new Book(3,"third book","yan,zhang", new Date(20160902)));
        return new BookSheet(initBookList);
    }
}
