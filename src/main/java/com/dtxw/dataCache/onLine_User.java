package com.dtxw.dataCache;

import java.util.HashMap;
import java.util.Map;

public class onLine_User {
    public volatile static Map<String,String> subscribeID_Path = new HashMap<>();
    public volatile static Map<String,Integer> path_count = new HashMap<>();
}
