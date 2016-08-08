package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/7/16.
 */
public class CheckMoive {

    public static void checkOut(MovieSheet movieSheet, long moiveid) {
        if(movieSheet.CheckOutOneMoive(moiveid)){
            System.out.println("Thank you! Enjoy the moive.");
        }
        else{
            System.out.println("That moive is not available.");
        }
    }

    public static void checkReturn(MovieSheet movieSheet, long moiveid) {
        if(movieSheet.CheckReturnOneMoive(moiveid)){
            System.out.println("Thank you for returning the moive.");
        }
        else{
            System.out.println("That is not a valid moive to return.");
        }
    }
}
