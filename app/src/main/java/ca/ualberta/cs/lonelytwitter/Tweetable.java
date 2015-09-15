package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by amarnaso on 9/15/15.
 */
public interface Tweetable {
    public void setText(String text);
    public String getText();
    public void setDate(Date date);
    public Date getDate();

}
