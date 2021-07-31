package com.le.tomcat;

import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    private Map<String,String> servletToServletClassNameMap;
    private LinkedHashMap<String,String> urlToServletNameMap;

    public Config(Map<String, String> servletToServletClassNameMap, LinkedHashMap<String, String> urlToServletNameMap) {
        this.servletToServletClassNameMap = servletToServletClassNameMap;
        this.urlToServletNameMap = urlToServletNameMap;
    }

    public Map<String, String> getServletToServletClassNameMap() {
        return servletToServletClassNameMap;
    }

    public LinkedHashMap<String, String> getUrlToServletNameMap() {
        return urlToServletNameMap;
    }
}
