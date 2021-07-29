package demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GenerateDemoSession {
    private static class User implements Serializable {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        String sessionID = UUID.randomUUID().toString();
        System.out.println(sessionID);
        Map<String,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("currentUser",new User("张三","123"));
        stringObjectMap.put("teacher",new User("李四","456"));

        String path = "D:\\JavaDemo\\HttpServlet2.0\\sessions"+"\\"+sessionID+".session";
        try(OutputStream os = new FileOutputStream(path)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(stringObjectMap);
            objectOutputStream.flush();
        }
    }
}
