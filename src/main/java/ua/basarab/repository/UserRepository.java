package ua.basarab.repository;

import ua.basarab.DataBaseHandler;
import ua.basarab.User;
import java.sql.*;
import java.util.ArrayList;

public class UserRepository {

    static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE id=?";
    static final String SQL_INSERT_NEW_USER = "insert into users (login, password) values (?,?,?)";
    static final String SQL_DISPLAY_ALL_USERS = "select * from users;";

    static DataBaseHandler connection = new DataBaseHandler();

    public ArrayList<User> findALl () {
        ArrayList <User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.getDbConnection().prepareStatement(SQL_DISPLAY_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("role_id");
                users.add(new User (id,login,password,roleId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public User findById(int id) {
        User user = null;

        try (PreparedStatement preparedStatement = connection.getDbConnection().prepareStatement(SQL_FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                int roleId = resultSet.getInt(4);
                user = new User(id, login, password, roleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void newUser(String login, String password) {
        try (PreparedStatement preparedStatement = connection.getDbConnection().prepareStatement(SQL_INSERT_NEW_USER)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//    Старая база
//    private final ArrayList<ua.basarab.User> users = new ArrayList<>();
//
//    public ua.basarab.repository.UserRepository() {
//        users.add(new ua.basarab.User("0001", "Adam", "HeyAdam"));
//        users.add(new ua.basarab.User("0002", "Kristin", "HeyKristin"));
//        users.add(new ua.basarab.User("0003", "Jon", "HeyJon"));
//        users.add(new ua.basarab.User("0004", "Daniel", "HeyDaniel"));
//        users.add(new ua.basarab.User("0005", "Sofia", "HeySofia"));
//
//    }
//
//    ua.basarab.User findById(String id) {
//        for (ua.basarab.User user :
//                users) {
//            if (user.getId().equals(id)) {
//                return user;
//            }
//        }
//        return null;
//    }

