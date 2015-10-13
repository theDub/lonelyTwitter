package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button saveButton;
    private Button clearButton;
    private ListView oldTweetsList;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditATweet(){
        // startup lonely twitter
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        clearButton = activity.getClearButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                clearButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();  // make sure all threads finish


        // user clicks on tweet they want to edit
        bodyText = activity.getBodyText();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburgers");
            }
        });
        getInstrumentation().waitForIdleSync();  // make sure all threads finish

        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();  // make sure all threads finish
        oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("hamburgers", tweet.getText());

        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);


        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });

        getInstrumentation().waitForIdleSync();  // make sure all threads finish


        // Code below was taken from: https://developer.android.com/training/activity-testing/activity-functional-testing.html
        // Validate that ReceiverActivity is started
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //test that the tweet being shown on the edit screen is the tweet we clicked on

        // edit the text of that tweet
        //save our edits
        //assert that our edits were saved into the tweet correctly
        //assert that our edits are shown on the screen to the user
        //back in the main activity


        // end of test: clear the data
        // end of test: make sure the edit activity is closed
        receiverActivity.finish();
    }
}