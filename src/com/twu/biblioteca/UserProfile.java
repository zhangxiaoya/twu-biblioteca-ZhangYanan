package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/6/16.
 */
public class UserProfile implements IUserProfile {
    private long Id;
    private String Name;
    private String Email;
    private String PhoneNumber;

    public UserProfile(long id,
                       String name,
                       String email,
                       String phoneNumber){
        Id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public long getId(){
        return Id;
    }
    public void setId(long id){
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name){
        Name = name;
    }

    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        Email = email;
    }

    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
}
