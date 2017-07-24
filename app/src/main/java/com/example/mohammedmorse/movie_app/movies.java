package com.example.mohammedmorse.movie_app;

/**
 * Created by Mohammed Morse on 20/07/2017.
 */

public class movies {
    private  String movieimageuri="http://image.tmdb.org/t/p/w185/";
    private  String moviename;
    private  String movieid;
    private  String movierate;
    private  String moviereleasedate;
    private  String movieoverview;
    private  String movietrailer;
    private  String moviereview;


    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getMovierate() {
        return movierate;
    }

    public void setMovierate(String movierate) {
        this.movierate = movierate;
    }

    public String getMoviereleasedate() {
        return moviereleasedate;
    }

    public void setMoviereleasedate(String moviereleasedate) {
        this.moviereleasedate = moviereleasedate;
    }

    public String getMovieoverview() {
        return movieoverview;
    }

    public void setMovieoverview(String movieoverview) {
        this.movieoverview = movieoverview;
    }

    public String getMovietrailer() {
        return movietrailer;
    }

    public void setMovietrailer(String movietrailer) {
        this.movietrailer = movietrailer;
    }

    public String getMoviereview() {
        return moviereview;
    }

    public void setMoviereview(String moviereview) {
        this.moviereview = moviereview;
    }

    public String getMovieimageuri() {
        return movieimageuri;
    }

    public void setMovieimageuri(String movieimageuri) {
        this.movieimageuri += movieimageuri;
    }
}
