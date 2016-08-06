package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by yanzhang on 8/6/16.
 */
public class MovieSheetTest {
    @Test
    public void should_get_a_empty_movie_list() throws Exception {
        MovieSheet movieSheet = new MovieSheet();
        assertNotNull(movieSheet.getMovieList());
    }

    @Test
    public void should_get_a_not_empty_movie_list_when_init_movie_sheet() throws Exception {
        List<IMovie> testList = mockMovieList();
        MovieSheet movieSheet = new MovieSheet(testList);

        assertNotNull(movieSheet);
        assertEquals(3,movieSheet.getMovieList().size());
    }

    private List<IMovie> mockMovieList(){
        List<IMovie> movieList = new ArrayList<IMovie>();
        movieList.add(new Movie(1, new Date(20140902),"Zhang San",((short) 1)));
        movieList.add(new Movie(2, new Date(20150902),"Lee Si",((short) 2)));
        movieList.add(new Movie(3, new Date(20160902),"Wang Wu",((short) 3)));

        return movieList;
    }
}