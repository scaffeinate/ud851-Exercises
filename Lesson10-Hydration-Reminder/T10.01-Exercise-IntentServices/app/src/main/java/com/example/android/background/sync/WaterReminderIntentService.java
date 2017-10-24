package com.example.android.background.sync;/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// COMPLETED (9) Create WaterReminderIntentService and extend it from IntentService

//  COMPLETED (10) Create a default constructor that calls super with the name of this class

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

//  COMPLETED (11) Override onHandleIntent
//      COMPLETED (12) Get the action from the Intent that started this Service
//      COMPLETED (13) Call ReminderTasks.executeTaskForTag and pass in the action to be performed
public class WaterReminderIntentService extends IntentService {

    public WaterReminderIntentService() {
        super(WaterReminderIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        ReminderTasks.executeTask(this, action);
    }
}