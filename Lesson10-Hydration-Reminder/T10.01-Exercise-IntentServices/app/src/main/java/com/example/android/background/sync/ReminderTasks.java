package com.example.android.background.sync;

// COMPLETED (1) Create a class called ReminderTasks

// COMPLETED (2) Create a public static constant String called ACTION_INCREMENT_WATER_COUNT

// COMPLETED (6) Create a public static void method called executeTask
// COMPLETED (7) Add a Context called context and String parameter called action to the parameter list

// COMPLETED (8) If the action equals ACTION_INCREMENT_WATER_COUNT, call this class's incrementWaterCount

import android.content.Context;

import com.example.android.background.utilities.PreferenceUtilities;

// COMPLETED (3) Create a private static void method called incrementWaterCount
// COMPLETED (4) Add a Context called context to the argument list
// COMPLETED (5) From incrementWaterCount, call the PreferenceUtility method that will ultimately update the water count
public class ReminderTasks {
    public static final String ACTION_INCREMENT_WATER_COUNT = "incrementWaterCount";

    public static void executeTask(Context context, String action) {
        if (action.equals(ACTION_INCREMENT_WATER_COUNT)) {
            incrementWaterCount(context);
        }
    }

    private static void incrementWaterCount(Context context) {
        PreferenceUtilities.incrementWaterCount(context);
    }
}