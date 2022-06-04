import java.sql.*;

// TASK 1: Переиспользуй этот класс
// Вынеси все что связано с базой в этот класс включая драйвер
// вместо массива юзеров используй базу данных
// SQL вынеси в константу

public class UserRepository {

    static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASS = "200604";
    static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE id=?";
    static final String SQL_INSERT_NEW_USER = "insert into users (login, password) values (?,?)";

    public User findById(int id) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                user = new User(id, login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void newUser (String login, String password){
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_NEW_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


//    Старая база
//    private final ArrayList<User> users = new ArrayList<>();
//
//    public UserRepository() {
//        users.add(new User("0001", "Adam", "HeyAdam"));
//        users.add(new User("0002", "Kristin", "HeyKristin"));
//        users.add(new User("0003", "Jon", "HeyJon"));
//        users.add(new User("0004", "Daniel", "HeyDaniel"));
//        users.add(new User("0005", "Sofia", "HeySofia"));
//
//    }
//
//    User findById(String id) {
//        for (User user :
//                users) {
//            if (user.getId().equals(id)) {
//                return user;
//            }
//        }
//        return null;
//    }

