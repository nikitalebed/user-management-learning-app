import java.sql.*;
import java.util.Scanner;

// TASK 1: в методе мейн оставь только запрос от пользователя ввести ID и вызов UserService
// С помощью цикла while реализуй программу которая будет бесконечно запрашивать ID пока не напечатаешь слово EXIT
// когда нужно выполнить запрос с параметром (у тебя это id) то используй PreparedStatement

class Demo {

    public static void main(String[] args) {

        while (true) {
            UserService userService = new UserService();
            System.out.println("Type id of the user you’re looking for");
            Scanner scanner = new Scanner(System.in);
            var userInput = scanner.nextLine();
            if (userInput.equals("Exit")) {
                return;
            }
            int id = Integer.parseInt(userInput.trim());
            System.out.println("Searching by ID: " + userInput);
            User user = userService.searchById(id);
            System.out.println("user found: " + user);
        }
    }
}

// мой вариант вывода
//        while (true) {
//            UserService userService = new UserService();
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Finding users by ID... write ID in next line:");
//            String answer = sc.nextLine();
//            if (answer == "EXIT")
//                break;
//            int id = Integer.parseInt(answer.trim());
//            User user = userService.searchById(id);
//            System.out.println(user);
//        }


//версия 4
//    static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
//    static final String USER = "postgres";
//    static final String PASS = "200604";

//        try {
//            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = connection.createStatement();
//            System.out.println("Connection successful, created access-to-BD object.");
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Finding users by ID... \nWrite ID in next line:");
//            String searchingId = sc.nextLine();
//
//            ResultSet resultSet = statement.executeQuery("SELECT* FROM users WHERE id='"+searchingId+"'");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id")+" "
//                +resultSet.getString("login")+" "
//                +resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//блок проверка подключения к базе
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (connection != null) {
//            System.out.println("Connection is already done.");
//        } else {
//            System.out.println("Not connected");
//        }


//старый блок реализации поиска по id
//        UserService userService = new UserService();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Finding users by ID... write ID in next line:");
//        String id = sc.nextLine();
//        User user = userService.searchById(id);
//        if (user != null) {
//            System.out.printf("1 user found: %s\n\t", user);
//        } else {
//            System.out.println("0 users found.");
//        }
