public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public User searchById(String id) {
        return userRepository.findById(id);
    }
}
