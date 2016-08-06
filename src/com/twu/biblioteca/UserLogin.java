package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/6/16.
 */
public class UserLogin implements IUserLogin {
    private long UserId;
    private String LibraryNumber;
    private String Password;

    public UserLogin(long userId,
                     String libraryNumber,
                     String password){
        UserId = userId;
        LibraryNumber = libraryNumber;
        Password = password;
    }

    public long getUserId(){
        return UserId;
    }
    public void setUserId(long userId){
        UserId = userId;
    }

    public String getLibraryNumber(){
        return LibraryNumber;
    }
    public void setLibraryNumber(String libraryNumber){
        LibraryNumber = libraryNumber;
    }

    public String getPassword(){
        return Password;
    }
    public void setPassword(String password){
        Password = password;
    }
}
