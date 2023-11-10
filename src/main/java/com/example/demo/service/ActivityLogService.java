package com.example.demo.service;

import com.example.demo.model.ActivityLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityLogService {

    static ArrayList<ActivityLog> activityLogs = new ArrayList<>();



    // return books to controller
    // get books form list static from class and return as signature
    public ArrayList<ActivityLog> getAllLogs (){
        return activityLogs;
    }


    public boolean addActivityLog (ActivityLog activityLog){

        boolean resultAdding = activityLogs.add(activityLog);
        //System.out.println(activityLogs);

        return resultAdding;
    }
}
