import java.util.Scanner;

class Demo {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Finding users by ID... write ID in next line:");
        String id = sc.nextLine();
        User user = userService.searchById(id);
        if (user != null) {
            System.out.printf("1 user found: %s\n\t", user);
        } else {
            System.out.println("0 users found.");
        }
    }
}