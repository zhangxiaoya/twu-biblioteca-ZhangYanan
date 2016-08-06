package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by yanzhang on 8/6/16.
 */
public class Movie implements IMovie {
    private long Id;
    private Date PublishYear;
    private String Director;
    private short Rate;

    public Movie(long id, Date year, String director, short rate){
        Id = id;
        PublishYear = year;
        Director = director;
        Rate = rate;
    }

    public long getId(){
        return Id;
    }
    public void setId(long id){
        Id = id;
    }

    public Date getPublishYear(){
        return PublishYear;
    }
    public void setPublishYear(Date year){
        PublishYear = year;
    }

    public String getDirector(){
        return Director;
    }
    public void setDirector(String director){
        Director = director;
    }

    public short getRate(){
        return Rate;
    }
    public void setRate(short rate){
        Rate = rate;
    }
}
