import java.util.ArrayList;

public class UserRepository {
    private final ArrayList<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("0001", "Adam", "HeyAdam"));
        users.add(new User("0002", "Kristin", "HeyKristin"));
        users.add(new User("0003", "Jon", "HeyJon"));
        users.add(new User("0004", "Daniel", "HeyDaniel"));
        users.add(new User("0005", "Sofia", "HeySofia"));

    }

    public User findById(String id) {
        for (User user :
                users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
