package com.le.tomcat.http;

import com.le.standard.http.HttpSession;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpSessionImpl implements HttpSession {
    private final String sessionID;
    private final Map<String,Object> sessionData;
    private static final String SESSION_BASE = "D:\\JavaDemo\\HttpServlet2.0\\sessions";

    public HttpSessionImpl(){
        sessionID = UUID.randomUUID().toString();
        sessionData = new HashMap<>();
    }

    public HttpSessionImpl(String sessionID) throws IOException, ClassNotFoundException {
        this.sessionID = sessionID;
        sessionData = loadSessionData(sessionID);
    }

    private Map<String, Object> loadSessionData(String sessionID) throws IOException, ClassNotFoundException {
        String path = SESSION_BASE+"\\"+sessionID+".session";
        File file = new File(path);
        if(!file.exists()){
            return new HashMap<>();
        }else{
            try(InputStream inputStream = new FileInputStream(file)){
                try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
                    return (Map<String, Object>) objectInputStream.readObject();
                }
            }
        }
    }

    @Override
    public Object getAttribute(String name) {
        return sessionData.get(name);
    }

    public String getSessionID() {
        return sessionID;
    }

    public Map<String, Object> getSessionData() {
        return sessionData;
    }

    public static String getSessionBase() {
        return SESSION_BASE;
    }

    @Override
    public void removeAttribute(String name) {
        sessionData.remove(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        sessionData.put(name,value);
    }

    public void saveSessionData() throws IOException {
        String path = SESSION_BASE+"\\"+sessionID+".session";
        try(OutputStream os = new FileOutputStream(path)){
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(os)){
                objectOutputStream.writeObject(sessionData);
                objectOutputStream.flush();
            }
        }
    }

    @Override
    public String toString() {
        return "HttpSessionImpl{" +
                "sessionData=" + sessionData +
                '}';
    }
}
