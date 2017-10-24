package com.example.android.background.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.example.android.background.MainActivity;
import com.example.android.background.R;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static android.support.v4.app.NotificationCompat.DEFAULT_VIBRATE;
import static android.support.v4.app.NotificationCompat.PRIORITY_DEFAULT;
import static android.support.v4.app.NotificationCompat.PRIORITY_HIGH;

/**
 * Utility class for creating hydration notifications
 */
public class NotificationUtils {

    public static final int REQUESTOR_CODE = 441;

    private static final int NOTIFICATION_ID = 442;

    // COMPLETED (7) Create a method called remindUserBecauseCharging which takes a Context.
    // This method will create a notification for charging. It might be helpful
    // to take a look at this guide to see an example of what the code in this method will look like:
    // https://developer.android.com/training/notify-user/build-notification.html
    // COMPLETED (8) In the remindUser method use NotificationCompat.Builder to create a notification
    // that:
    // - has a color of R.colorPrimary - use ContextCompat.getColor to get a compatible color
    // - has ic_drink_notification as the small icon
    // - uses icon returned by the largeIcon helper method as the large icon
    // - sets the title to the charging_reminder_notification_title String resource
    // - sets the text to the charging_reminder_notification_body String resource
    // - sets the style to NotificationCompat.BigTextStyle().bigText(text)
    // - sets the notification defaults to vibrate
    // - uses the content intent returned by the contentIntent helper method for the contentIntent
    // - automatically cancels the notification when the notification is clicked
    // COMPLETED (9) If the build version is greater than JELLY_BEAN, set the notification's priority
    // to PRIORITY_HIGH.
    // COMPLETED (11) Get a NotificationManager, using context.getSystemService(Context.NOTIFICATION_SERVICE);
    // COMPLETED (12) Trigger the notification by calling notify on the NotificationManager.
    // Pass in a unique ID of your choosing for the notification and notificationBuilder.build()
    public static void remindUserBecauseCharging(Context context) {
        String contentTitle = context.getResources().getString(R.string.charging_reminder_notification_title);
        Notification notification = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.drawable.ic_drink_notification)
                .setLargeIcon(largeIcon(context))
                .setContentTitle(contentTitle)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(contentTitle))
                .setDefaults(DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true)
                .setPriority(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN ? PRIORITY_HIGH : PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    // COMPLETED (1) Create a helper method called contentIntent with a single parameter for a Context. It
    // should return a PendingIntent. This method will create the pending intent which will trigger when
    // the notification is pressed. This pending intent should open up the MainActivity.
    // COMPLETED (2) Create an intent that opens up the MainActivity
    // COMPLETED (3) Create a PendingIntent using getActivity that:
    // - Take the context passed in as a parameter
    // - Takes an unique integer ID for the pending intent (you can create a constant for
    //   this integer above
    // - Takes the intent to open the MainActivity you just created; this is what is triggered
    //   when the notification is triggered
    // - Has the flag FLAG_UPDATE_CURRENT, so that if the intent is created again, keep the
    // intent but update the data
    public static PendingIntent contentIntent(Context context) {
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUESTOR_CODE, mainIntent, FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

    // COMPLETED (4) Create a helper method called largeIcon which takes in a Context as a parameter and
    // returns a Bitmap. This method is necessary to decode a bitmap needed for the notification.
    // COMPLETED (5) Get a Resources object from the context.
    // COMPLETED (6) Create and return a bitmap using BitmapFactory.decodeResource, passing in the
    // resources object and R.drawable.ic_local_drink_black_24px
    public static Bitmap largeIcon(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_local_drink_black_24px);
    }

}
