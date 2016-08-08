package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by yanzhang on 8/6/16.
 */
public class MovieSheetTest {
    @Test
    public void should_get_a_empty_movie_list() throws Exception {
        MovieSheet movieSheet = new MovieSheet();
        assertNotNull(movieSheet);
    }

    @Test
    public void should_get_a_not_empty_movie_list_when_init_movie_sheet() throws Exception {
        List<IMovie> testList = mockMovieList();
        MovieSheet movieSheet = new MovieSheet(testList);

        assertNotNull(movieSheet);
        assertEquals(3,movieSheet.getMovieList().size());
    }

    @Test
    public void should_not_get_moive_3_when_check_out_it() throws Exception{
        List<IMovie> testList = mockMovieList();
        MovieSheet movieSheet = new MovieSheet(testList);

        assertEquals(3,movieSheet.getMovieList().size());
        movieSheet.CheckOutOneMoive(3);
        assertEquals(2,movieSheet.getMovieList().size());
    }

    @Test
    public void should_not_print_moive_3_when_check_out_it() throws Exception{
        List<IMovie> testList = mockMovieListWithOneCheckedOut();
        MovieSheet movieSheet = new MovieSheet(testList);

        assertEquals(2,movieSheet.getMovieList().size());
    }

    @Test
    public void should_return_success_moive_3_when_return_it() throws Exception{
        List<IMovie> testList = mockMovieListWithOneCheckedOut();
        MovieSheet movieSheet = new MovieSheet(testList);

        assertTrue(movieSheet.CheckReturnOneMoive(3));
        assertEquals(3,movieSheet.getMovieList().size());
    }

    private List<IMovie> mockMovieList(){
        List<IMovie> movieList = new ArrayList<IMovie>();
        movieList.add(new Movie(1, new Date(20140902),"Zhang San",((short) 1)));
        movieList.add(new Movie(2, new Date(20150902),"Lee Si",((short) 2)));
        movieList.add(new Movie(3, new Date(20160902),"Wang Wu",((short) 3)));

        return movieList;
    }

    private List<IMovie> mockMovieListWithOneCheckedOut(){
        List<IMovie> movieList = new ArrayList<IMovie>();
        movieList.add(new Movie(1, new Date(20140902),"Zhang San",((short) 1)));
        movieList.add(new Movie(2, new Date(20150902),"Lee Si",((short) 2)));
        Movie moive3 = new Movie(3, new Date(20160902),"Wang Wu",((short) 3));
        moive3.setCheckedOut(true);
        movieList.add(moive3);

        return movieList;
    }
}