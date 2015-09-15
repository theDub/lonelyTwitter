package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 */
public class Happy extends CurrentMood {
    public Happy() {
        super();
    }

    public Happy(Date date) {
        super(date);
    }

    public String moodType() {
        return "Happy";
    }
}
