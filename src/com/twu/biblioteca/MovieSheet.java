package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanzhang on 8/6/16.
 */
public class MovieSheet implements IMovieSheet {
    private List<IMovie> MovieList;

    public MovieSheet(){
        MovieList = new ArrayList<IMovie>();
    }

    public MovieSheet(List<IMovie> movieList){
        MovieList = new ArrayList<IMovie>();
        for(int i =0;i<movieList.size();++i){
            MovieList.add(movieList.get(i));
        }
    }

    public boolean CheckOutOneMoive(long moiveId){
        for(int i=0;i<MovieList.size();++i){
            if(((Movie)MovieList.get(i)).getId() == moiveId){
                ((Movie)MovieList.get(i)).setCheckedOut(true);
                return true;
            }
        }
        return  false;

    }

    public boolean CheckReturnOneMoive(long moiveId){
        for(int i=0;i<MovieList.size();++i){
            if(((Movie)MovieList.get(i)).getId() == moiveId){
                ((Movie)MovieList.get(i)).setCheckedOut(false);
                return true;
            }
        }
        return false;
    }

    public List<IMovie> getMovieList(){

        List<IMovie> movieList = new ArrayList<IMovie>();
        for(int i=0;i<MovieList.size();++i){
            if(!((Movie)MovieList.get(i)).getIsCheckedOut()){
                movieList.add(MovieList.get(i));
            }
        }

        return movieList;
    }
}
