package com.dbs.kcmon.util;

import com.dbs.kcmon.element.MetricsElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class MetricsMap {
    public HashMap<String, MetricsElement> regionMetricsMap = new HashMap<>();
    public HashMap<String, MetricsElement> apiMetricsMap = new HashMap<>();

    MetricsMap(){
        // Api
        apiMetricsMap.put("apihub",new MetricsElement("apihub","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubacin",new MetricsElement("apihubacin","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubacco",new MetricsElement("apihubacco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubactr",new MetricsElement("apihubactr","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublain",new MetricsElement("apihublain","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublaco",new MetricsElement("apihublaco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublatr",new MetricsElement("apihublatr","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrfin",new MetricsElement("apihubrfin","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrfco",new MetricsElement("apihubrfco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrftr",new MetricsElement("apihubrftr","prom","query1", new ArrayList<>()));

        // Api
        apiMetricsMap.put("apihub",new MetricsElement("apihub","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubacin",new MetricsElement("apihubacin","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubacco",new MetricsElement("apihubacco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubactr",new MetricsElement("apihubactr","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublain",new MetricsElement("apihublain","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublaco",new MetricsElement("apihublaco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihublatr",new MetricsElement("apihublatr","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrfin",new MetricsElement("apihubrfin","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrfco",new MetricsElement("apihubrfco","prom","query1", new ArrayList<>()));
        apiMetricsMap.put("apihubrftr",new MetricsElement("apihubrftr","prom","query1", new ArrayList<>()));

        // Region
        regionMetricsMap.put("gateway",new MetricsElement("GATEWAY","prom","query1",new ArrayList<>()));
        regionMetricsMap.put("api", new MetricsElement("GAPI API","prom","query1",new ArrayList<>()));
        regionMetricsMap.put("online", new MetricsElement("ONLINE","prom","query1",new ArrayList<>()));
        regionMetricsMap.put("event", new MetricsElement("EVENT","prom","query1",new ArrayList<>()));
        regionMetricsMap.put("iso", new MetricsElement("ISO API","prom","query1",new ArrayList<>()));
    }
}
