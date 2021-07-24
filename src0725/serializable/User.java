package serializable;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String gender;

    public User(int id, String username, String gender) {
        this.id = id;
        this.username = username;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
