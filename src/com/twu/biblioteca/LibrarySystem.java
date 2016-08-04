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

    private String lastErrorMsg;
    private String lastPromotMsg;
    private String userCommand;

    public void initSystem(){
        welcomeGen = new Welcome();
        bookSheet = initBookSheet();
        lastErrorMsg = new String();
        lastPromotMsg = new String();
        setupCommandList();
    }

    public void run(){

        welcomeGen.printWelcomeMsg();

        printCommandList();

        printPromotMsg("> ");
        Scanner scanner = new Scanner(System.in);
        userCommand = scanner.nextLine();

        while (!userCommand.isEmpty()){

            if (translateCommand(userCommand)) break;

            userCommand = scanner.nextLine();
        }
    }

    private boolean translateCommand(String userInputMenu) {
        if(userInputMenu.equals("1")){
            printBookList(bookSheet);
            printPromotMsg("> ");
        }
        else if(userInputMenu.equals("0")){
            printPromotMsg("Exsiting Online Library...");
            return true;
        }
        else{
            printErrorMsg("Select a valid option!");
        }
        return false;
    }

    public String getLastErrorMsg(){
        return lastErrorMsg;
    }

    public String getLastPromotMsg(){
        return lastPromotMsg;
    }

    private void printPromotMsg(String Msg) {
        lastPromotMsg = Msg;
        System.out.println(Msg);
    }

    private void printErrorMsg(String Msg){
        lastErrorMsg = Msg;
        System.out.println(Msg);
    }

    private void setupCommandList(){
        commandList = new ArrayList<String>();
        commandList.add("List Books");
    }

    private void printCommandList(){
        printPromotMsg("System Menus: ");
        for(int i =0;i<commandList.size();++i){
            printPromotMsg(String.format("%4d  ->   %s",(i+1),commandList.get(i)));
        }
    }

    public ArrayList<String> getCommandList(){
        return commandList;
    }

    private void printBookList(BookSheet bookSheet) {
        printPromotMsg("The Following is Book List: ");
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
