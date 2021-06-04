package demo;

import java.io.Serializable;
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

    public static void main(String[] args) {
        String sessionId = UUID.randomUUID().toString();
        System.out.println(sessionId);
        Map<String,Object> map = new HashMap<>();
        map.put("currentUser",new user)
    }
}
