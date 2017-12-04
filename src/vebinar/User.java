package vebinar;


/**
 * Created by user on 08.10.2017.
 */
public class User {

        private String sessionId;
        private String ipAddress;
        private UserType userType;

        public User(String sessionId, String ipAddress) {
            this.sessionId = sessionId;
            this.ipAddress = ipAddress;
            this.userType = UserType.USER;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setUserType(UserType userType) {
            this.userType = userType;
        }

        public UserType getUserType() {
            return userType;
        }

}
