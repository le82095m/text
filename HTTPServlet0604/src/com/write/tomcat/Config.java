package com.write.tomcat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    public Map<String,String> servletNameToClassNameMap = new HashMap<>();
    public LinkedHashMap<String,String> urlToServletNameMap = new LinkedHashMap<>();

    public Config(Map<String, String> servletNameToClassNameMap, LinkedHashMap<String, String> urlToServletNameMap) {
        this.servletNameToClassNameMap = servletNameToClassNameMap;
        this.urlToServletNameMap = urlToServletNameMap;
    }
}
