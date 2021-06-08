package com.write.tomcat.http;

import com.write.standard.http.HttpSession;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpSessionImpl implements HttpSession {
    public Map<String,Object> sessionData = new HashMap<>();
    public final String sessionID;

    @Override
    public String toString() {
        return "HttpSessionImpl{" +
                "sessionData=" + sessionData +
                ", sessionID='" + sessionID + '\'' +
                '}';
    }

    //没有从 cookie 拿到session-id 时构建对象使用
    public HttpSessionImpl() {
        this.sessionID = UUID.randomUUID().toString();
        sessionData = new HashMap<>();
    }

    //从 cookie 中拿到 session-id 时构建对象使用
    public HttpSessionImpl(String sessionID) throws IOException, ClassNotFoundException {
        this.sessionID = sessionID;
        sessionData = loadSessionData(sessionID);
    }

    private static final String SESSION_BASE = "D:\\JavaDemo\\HTTPServlet\\sessions";
    // 文件名: <session-id>.session
    public Map<String, Object> loadSessionData(String sessionID)
            throws IOException, ClassNotFoundException {
        String sessionFilename = String.format("%s\\%s.session",SESSION_BASE,sessionID);
        File sessionFile = new File(sessionFilename);

        if(!sessionFile.exists()){
            return new HashMap<>();
        }

        try(InputStream is = new FileInputStream(sessionFile)) {
            //ObjectInputStream 进行对象读取
            try(ObjectInputStream objectInputStream = new ObjectInputStream(is)) {
                return (Map<String, Object>) objectInputStream.readObject();
            }
        }
    }

    public void saveSessionData() throws IOException, ClassNotFoundException {
        String sessionFilename = String.format("%s\\%s.session",SESSION_BASE,sessionID);
        try (OutputStream os = new FileOutputStream(sessionFilename)){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(os)) {
                objectOutputStream.writeObject(sessionData);
                objectOutputStream.flush();
            }
        }
    }

    @Override
    public Object getAttribute(String name) {
        return sessionData.get(name);
    }

    @Override
    public void removeAttribute(String name) {
        sessionData.remove(name);
    }

    @Override
    public void setAttribute(String name, Object attribute) {
        sessionData.put(name,attribute);
    }
}
