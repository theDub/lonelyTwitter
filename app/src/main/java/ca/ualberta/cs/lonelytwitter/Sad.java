package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 */
public class Sad extends CurrentMood {
    public Sad() {
        super();
    }

    public Sad(Date date) {
        super(date);
    }

    public String moodType() {
        return "Sad";
    }
}
