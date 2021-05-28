package v3;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String username;
    private String gender;

    public User(int userID, String username, String gender) {
        this.userID = userID;
        this.username = username;
        this.gender = gender;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
