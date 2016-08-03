package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        LibrarySystem onlineSystem = new LibrarySystem();
        onlineSystem.initSystem();
        onlineSystem.run();
    }
}
