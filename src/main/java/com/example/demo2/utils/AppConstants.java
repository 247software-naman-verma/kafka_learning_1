package com.example.demo2.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
    public static final String TOPIC_INCIDENTS = "incidents";
    public static final String TOPIC_ACTIVITY = "activity";
    public static final String GROUP_ID = "group_id";


    public static List<String> getValidTopics() {
        return Arrays.asList(TOPIC_INCIDENTS, TOPIC_ACTIVITY);
    }
}