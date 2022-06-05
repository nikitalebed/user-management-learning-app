package ua.basarab;

public class User {

    private final int id;
    private final String login;
    private final String password;
    private final int roleId;

    public User(int id, String login, String password, int roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                "\n";
    }
}
