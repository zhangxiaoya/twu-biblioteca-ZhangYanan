package com.twu.biblioteca;

import java.time.LocalDate;

public class BibliotecaApp {

    public static void main(String[] args) {
        String datestr = LocalDate.now().toString();
        System.out.println("#####################################################");
        System.out.println("                                                     ");
        System.out.println("     Today is " + datestr + "                        ");
        System.out.println("     Welcome to Online Bangalore Public Library      ");
        System.out.println("                                                     ");
        System.out.println("#####################################################");
    }
}
