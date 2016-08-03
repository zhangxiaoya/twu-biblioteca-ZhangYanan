package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        IWelcome welcomeGen = new Welcome();
        welcomeGen.printWelcomeMsg();
    }
}
