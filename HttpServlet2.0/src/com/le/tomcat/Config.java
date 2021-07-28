package com.le.tomcat;

import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    public Map<String,String> servletToServletClassNameMap;
    public LinkedHashMap<String,String> urlToServletNameMap;

    public Config(Map<String, String> servletToServletClassNameMap, LinkedHashMap<String, String> urlToServletNameMap) {
        this.servletToServletClassNameMap = servletToServletClassNameMap;
        this.urlToServletNameMap = urlToServletNameMap;
    }
}
