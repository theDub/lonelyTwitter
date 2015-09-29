package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by amarnaso on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHoldsStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }

    public void testHoldsManyThings() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.add(new NormalTweet("test1"));
        assertEquals(list.count(), 2);
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.removeTweet(tweet);
        assertEquals(list.count(), 0);
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        assertEquals(list.getCount(), 1);
        list.add(new NormalTweet("Test1"));
        assertEquals(list.getCount(), 2);
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        assertEquals(list.hasTweet(tweet), true);
        Tweet tweet1 = new NormalTweet("Test1");
        assertEquals(list.hasTweet(tweet1), false);
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        Tweet tweet1 = new NormalTweet("Test1");
        list.add(tweet1);
        list.getTweets();
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Test");
        list.addTweet(tweet);
    }
}