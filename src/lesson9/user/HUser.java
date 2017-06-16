package lesson9.user;

/**
 * Created by user on 26.05.2017.
 */
public class HUser {
    private  long id;
    private String name;
    private String sessionId;

    public HUser(long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
