package lesson36.model;

import lesson36.exception.BadRequestException;
import lesson36.repository.GeneralRepository;

/**
 * Created by user on 30.11.2017.
 */
public class User {

    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;
    private boolean loginStatus;


    public User() {
    }

    public User(String userName, String password, String country, UserType userType) {
        this.id = GeneralRepository.generateId();
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = UserType.USER;
    }

    public long getId() {
        return id;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return id +
                "," + userName +
                "," + password +
                "," + country +
                "," + userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (loginStatus != user.loginStatus) return false;
        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        if (!country.equals(user.country)) return false;
        return userType == user.userType;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + userType.hashCode();
        result = 31 * result + (loginStatus ? 1 : 0);
        return result;
    }
}
