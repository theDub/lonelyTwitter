package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 *
 * polymorphism - treat object of any class
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet(String text) {
        super(text);
    }

    public ImportantTweet(String text, Date date) {
        super(text, date);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getText() {
        return "important!: " + super.getText();
    }
}
