package com.test.test.services;

import com.test.test.entities.Activity;

public interface ActivityService {

    void saveActivity(Activity activity);

    Activity getActivityByDate(String date);
}
