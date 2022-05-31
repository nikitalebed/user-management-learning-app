public class LibraryApp {
    private final UserRepository userRepo = new UserRepository();

    public void searchById(String id) {
        System.out.printf("Searching for users with ID: %s.\n", id);
        User user = userRepo.findById(id);
        if (user != null) {
            System.out.printf("1 user found:\n\tLogin: %s\n\t Password: %s\n\t", user.getLogin(), user.getPassword());
        } else {
            System.out.println("0 users found.");
        }
        System.out.println("\n\n");
    }
}
