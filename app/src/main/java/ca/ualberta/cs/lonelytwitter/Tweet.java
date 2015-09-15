package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 *
 * Classes
 *
 * constructors/methods/attributes
 *
 * attributes - store information about an object.
 * access_modifier Type name;
 *
 * access_modifier - Private (accessed within), protected (current/sub class)
 * public (accessed by any class) Usually private or protected
 * interface == multiple inheritance
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    private Date date;
    private ArrayList<CurrentMood> moodList;

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
        this.moodList = new ArrayList<CurrentMood>();
    }

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;
        this.moodList = new ArrayList<CurrentMood>();
    }

    public void addMood(CurrentMood mood) {
        this.moodList.add(mood);
    }

    public String getText() {
        return this.text;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        }
    }

    public abstract Boolean isImportant();
}
