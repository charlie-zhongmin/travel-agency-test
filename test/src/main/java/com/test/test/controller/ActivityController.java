package com.test.test.controller;

import com.test.test.entities.Activity;
import com.test.test.services.ActivityService;
import com.test.test.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping()
    public Response getAcitivityByDate(@RequestParam String date) {
        String activity = activityService.getActivityByDate(date).getActivity();
        return Response.success(activity, "Get success");
    }

    @PostMapping()
    public void addActivity(@RequestBody Activity activity){
        activityService.saveActivity(activity);
    }

    @GetMapping("/local")
    public Response getLocalActivity(@RequestParam String date) {
        String activity = activityService.getLocalActivity(date);
        if (activity == null) {
            return Response.failed("Date '" + date + "' not found");
        }
        return Response.success(activityService.getLocalActivity(date), "Activity get success");
    }
}
