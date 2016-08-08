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
    private MovieSheet movieSheet;

    private List<UserLogin> userLoginList;
    private List<UserProfile> userProfileList;

    private CheckedRecordHistory checkedRecordHistory;

    private ArrayList<String> commandList;

    private String userCommand;
    private String currentLibraryNumber;

    Scanner scanner ;

    public void initSystem(){
        welcomeGen = new Welcome();
        bookSheet = initBookSheet();
        movieSheet = initMovieSheet();
        checkedRecordHistory = new CheckedRecordHistory();
        scanner = new Scanner(System.in);

        setupCommandList();
        setupUserList();
    }

    public void run(){

        if(LogIn()){

            welcomeGen.printWelcomeMsg();

            printCommandList();
            userCommand = scanner.nextLine();

            while (true){
                if (translateCommand(userCommand)){
                    break;
                }

                userCommand = scanner.nextLine();
            }
        }

    }

    private boolean LogIn() {

        String libraryNumber;
        String password;

        System.out.print("Library Number: ");
        libraryNumber = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        while (true){
            if(libraryNumber.isEmpty() && password.isEmpty()){
                return false;
            }
            if(CheckLogin.Login(userLoginList,libraryNumber,password)){
                currentLibraryNumber = libraryNumber;
                return true;
            }

            System.out.println("Library Number or Password Wrong!");

            System.out.print("Library Number: ");
            libraryNumber = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();
        }
    }

    private boolean translateCommand(String userInputMenu) {

        String[] inputCommandList = userInputMenu.split(" ");
        if(inputCommandList[0].toLowerCase().equals("list") && inputCommandList[1].toLowerCase().equals("books")){
            printBookList();
        }
        else if(inputCommandList[0].toLowerCase().equals("list") && inputCommandList[1].toLowerCase().equals("movies")){
            PrintMovieList();
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
        else if(inputCommandList[0].toLowerCase().equals("check") && inputCommandList[1].toLowerCase().equals("moive")){
            if(inputCommandList.length == 2 || strToLong(inputCommandList[2])==0){
                System.out.println("Select a valid option!");
            }
            else{
                long moiveid = strToLong(inputCommandList[2]);
                CheckMoive.checkOut(movieSheet,moiveid);
            }
        }
        else if(inputCommandList[0].toLowerCase().equals("return") && inputCommandList[1].toLowerCase().equals("moive")){
        if(inputCommandList.length == 2 || strToLong(inputCommandList[2]) == 0){
            System.out.println("Select a valid option!");
        }
        else{
            long moiveid = strToLong(inputCommandList[2]);
            CheckMoive.checkReturn(movieSheet,moiveid);
        }
    }
        else if(inputCommandList[0].toLowerCase().equals("show") && inputCommandList[1].toLowerCase().equals("profile")){
            printUserProfile();
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

    private void printUserProfile() {
        UserProfile currentUserProfile = getCurrentUserProfile();
        System.out.println("User Id: " + currentUserProfile.getId());
        System.out.println("Name: " + currentUserProfile.getName());
        System.out.println("Email: " + currentUserProfile.getEmail());
        System.out.println("Phone Number: " + currentUserProfile.getPhoneNumber());
    }

    private long strToLong(String strArgu){
        long res = 0;
        for(int i= strArgu.length()-1; i >= 0;i--){
            res *= 10;
            res += strArgu.toCharArray()[i] - '0';
        }
        return res;
    }

    public ArrayList<String> getCommandList(){
        return commandList;
    }

    private void setupUserList() {
        userLoginList   = new ArrayList<UserLogin>();
        userProfileList = new ArrayList<UserProfile>();

        userLoginList.add(new UserLogin(1,"001-0001","abc123"));
        userProfileList.add(new UserProfile(1,"ZhangSan","abc@gmail.com","1234567890"));

        userLoginList.add(new UserLogin(1,"001-0002","abc134"));
        userProfileList.add(new UserProfile(1,"John","ahhh@gmail.com","1234560973"));
    }

    private void setupCommandList(){
        commandList = new ArrayList<String>();
        commandList.add("Quit");
        commandList.add("List Books");
        commandList.add("Check Book");
        commandList.add("Return Book");
        commandList.add("List Movies");
        commandList.add("Show Profile");
        commandList.add("Check Moive");
        commandList.add("Return Moive");
    }

    private void printCommandList(){
        System.out.println("System Menus: ");
        for(int i =0;i<commandList.size();++i){
            System.out.println(String.format("%4d  ->   %s",i ,commandList.get(i)));
        }
    }

    private void printBookList() {
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

    private void PrintMovieList(){

        System.out.println("The Following is Moive List: ");
        List<IMovie> currentMovieList = movieSheet.getMovieList();
        for(int i=0;i<currentMovieList.size();++i){
            System.out.print(String.format("%4d",((Movie)currentMovieList.get(i)).getId()));
            System.out.print(" ==> ");
            System.out.print(String.format("%-30s",((Movie)currentMovieList.get(i)).getPublishYear().toString()));
            System.out.print(String.format("%-15s",((Movie)currentMovieList.get(i)).getDirector()));
            System.out.print(String.format("%-3d",((Movie)currentMovieList.get(i)).getRate()));
            System.out.println("");
        }
    };

    private BookSheet initBookSheet() {
        ArrayList<IBook> initBookList = new ArrayList<IBook>();
        initBookList.add(new Book(1,"first book","yan,zhang", new Date(20140902)));
        initBookList.add(new Book(2,"second book","yan,zhang", new Date(20150902)));
        initBookList.add(new Book(3,"third book","yan,zhang", new Date(20160902)));
        return new BookSheet(initBookList);
    }

    private MovieSheet initMovieSheet(){
        ArrayList<IMovie> initMovieList = new ArrayList<IMovie>();
        initMovieList.add(new Movie(1, new Date(20140902),"Zhang San",((short) 1)));
        initMovieList.add(new Movie(2, new Date(20150902),"Lee Si",((short) 2)));
        initMovieList.add(new Movie(3, new Date(20160902),"Wang Wu",((short) 3)));

        return new MovieSheet(initMovieList);
    }

    public UserProfile getCurrentUserProfile() {
        long currentUserId = 0;
        for(int i = 0;i<userLoginList.size();++i){
            if(userLoginList.get(i).getLibraryNumber().equals(currentLibraryNumber)){
                currentUserId = userLoginList.get(i).getUserId();
                break;
            }
        }
        for(int i =0;i<userProfileList.size();++i){
            if(userProfileList.get(i).getId() == currentUserId){
                return userProfileList.get(i);
            }
        }
        return null;
    }

    public UserLogin getCurrentUserLogin() {
        for(int i = 0;i<userLoginList.size();++i){
            if(userLoginList.get(i).getLibraryNumber().equals(currentLibraryNumber)){
                return userLoginList.get(i);
            }
        }
        return null;
    }
}
