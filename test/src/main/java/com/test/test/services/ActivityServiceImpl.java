package com.test.test.services;

import com.test.test.entities.Activity;
import com.test.test.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public Activity getActivityByDate(String date) throws NoSuchElementException {
        return activityRepository.findByDate(date)
                .orElseThrow(() -> new NoSuchElementException("Date "+ date + " not found"));
    }
}
