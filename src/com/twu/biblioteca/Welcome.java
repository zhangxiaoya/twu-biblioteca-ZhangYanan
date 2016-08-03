package com.twu.biblioteca;

import java.time.LocalDate;

/**
 * Created by yanzhang on 8/3/16.
 */
public class Welcome implements IWelcome {

    public String welcomeStr;

    public Welcome(){
        welcomeStr = new String();
    }

    @Override
    public void printWelcomeMsg(){
        String datestr = LocalDate.now().toString();

        welcomeStr  = "#####################################################\n";
        welcomeStr += "                                                     \n";
        welcomeStr += "     Today is " + datestr + "                        \n";
        welcomeStr += "     Welcome to Online Bangalore Public Library      \n";
        welcomeStr += "                                                     \n";
        welcomeStr += "#####################################################\n";

        System.out.println(welcomeStr);
    }

    public String getWelcomeMsg(){
        return welcomeStr;
    }
}
