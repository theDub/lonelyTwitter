package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by amarnaso on 9/29/15.
 *
 * TweetList class used to add, getMostRecent tweet
 * includes count method.
 */
public class TweetList {
    private Tweet mostRecentTweet;
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        this.mostRecentTweet = tweet;
        tweets.add(tweet);
    }

    public Tweet getMostRecentTweet() {
        return this.mostRecentTweet;
    }

    public int count() {
        return this.tweets.size();
    }

    public void addTweet(Tweet test) throws IllegalArgumentException {
        if(!tweets.contains(test)) {
            this.add(test);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Tweet> getTweets() {
        return this.tweets;
    }

    public void removeTweet(Tweet tweet) {
        this.tweets.remove(tweet);
    }

    public int getCount() {
        return this.count();
    }

    public boolean hasTweet(Tweet tweet) {
        if(this.tweets.contains(tweet)) {
            return true;
        } else {
            return false;
        }
    }
}
