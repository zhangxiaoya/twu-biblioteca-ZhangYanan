package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanzhang on 8/3/16.
 */
public class LibrarySystem {

    private IWelcome  welcomeGen;
    private BookSheet bookSheet;

    private ArrayList<String> commandList;

    private String userCommand;

    public void initSystem(){
        welcomeGen = new Welcome();
        bookSheet = initBookSheet();
        setupCommandList();
    }

    public void run(){

        welcomeGen.printWelcomeMsg();

        printCommandList();

        Scanner scanner = new Scanner(System.in);
        userCommand = scanner.nextLine();

        while (!userCommand.isEmpty()){

            if (translateCommand(userCommand)) break;

            userCommand = scanner.nextLine();
        }
    }

    private boolean translateCommand(String userInputMenu) {

        String[] inputCommandList = userInputMenu.split(" ");
        if(inputCommandList[0].toLowerCase().equals("list") && inputCommandList[1].toLowerCase().equals("books")){
            printBookList(bookSheet);
        }
        else if(inputCommandList[0].toLowerCase().equals("check") && inputCommandList[1].toLowerCase().equals("book")){
            if(inputCommandList.length == 2 || strToLong(inputCommandList[2])==0){
                System.out.println("Select a valid option!");
            }
            else{
                long bookid = strToLong(inputCommandList[2]);
                CheckBook.checkOut(bookSheet,bookid);
            }
        }
        else if(inputCommandList[0].toLowerCase().equals("return") && inputCommandList[1].toLowerCase().equals("book")){
            if(inputCommandList.length == 2 || strToLong(inputCommandList[2]) == 0){
                System.out.println("Select a valid option!");
            }
            else{
                long bookid = strToLong(inputCommandList[2]);
                CheckBook.checkReturn(bookSheet,bookid);
            }
        }
        else if(inputCommandList[0].toLowerCase().equals("quit")){
            System.out.print("Exsiting Online Library...");
            return true;
        }
        else{
            System.out.println("Select a valid option!");
        }
        return false;
    }

    private long strToLong(String strArgu){
        long res = 0;
        for(int i= strArgu.length()-1; i >= 0;i--){
            res *= 10;
            res += strArgu.toCharArray()[i] - '0';
        }
        return res;
    }

    private void setupCommandList(){
        commandList = new ArrayList<String>();
        commandList.add("Quit");
        commandList.add("List Books");
        commandList.add("Check Book");
        commandList.add("Return Book");
    }

    private void printCommandList(){
        System.out.println("System Menus: ");
        for(int i =0;i<commandList.size();++i){
            System.out.println(String.format("%4d  ->   %s",i ,commandList.get(i)));
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
            System.out.println("");
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
