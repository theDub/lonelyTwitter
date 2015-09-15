package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 */
public abstract class CurrentMood {
    private Date date;


    public CurrentMood() {
        this.date = new Date();
    }

    public CurrentMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String moodType();

}
