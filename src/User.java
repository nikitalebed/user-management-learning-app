import java.util.Objects;

// TASK 1: не забывай удалять не используемые импорты
public class User {

    private final String id;
    private final String login;
    private final String password;

    public User(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'';
    }
}
