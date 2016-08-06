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

    public List<IMovie> getMovieList(){
        return MovieList;
    }
}
