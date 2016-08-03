package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/2/16.
 */
public class Book implements IBook {

    private long Id;
    private String Name;

    public long getId(){
        return Id;
    }

    public void setId(long id){
        Id = id;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name = name;
    }

    public Book(){
        Id = 0;
        Name = new String();
    }

    public Book(long id, String name){
        Id = id;
        Name = name;
    }

    public Book(String name){
        Id = 0;
        Name = name;
    }
}
