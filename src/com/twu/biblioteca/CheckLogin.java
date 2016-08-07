package com.twu.biblioteca;

import java.util.List;

/**
 * Created by yanzhang on 8/6/16.
 */
public class CheckLogin {
    public static boolean Login(List<UserLogin> userLoginList,String libararyNumber,String password){
        for(int i=0;i<userLoginList.size();++i){
            if(userLoginList.get(i).getLibraryNumber().equals(libararyNumber) &&
                    userLoginList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
