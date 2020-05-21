package lld.model;

import java.util.Date;

public class Show {
    private Movie movie;
    private Date date;
    private String startTime;

    public Show(Movie movie, Date date, String startTime) {
        this.movie = movie;
        this.date = date;
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }
}
