package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by yanzhang on 8/2/16.
 */
public class Book implements IBook {

    private long Id;
    private String Name;
    private String Author;
    private Date PublishYear;

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

    public String getAuthor(){
        return Author;
    }

    public void setAuthor(String author){
        Author = author;
    }

    public Date getPublishYear(){
        return PublishYear;
    }

    public void setPublishYear(Date year){
        PublishYear = year;
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
