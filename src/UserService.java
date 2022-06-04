import java.sql.SQLException;

// TASK 1: Переиспользуй этот класс
// добавь обработку исключений на случай если пользователя нет в базе по такому айдишнику

public class UserService {

    static class UserNotFoundException extends RuntimeException {
        public String toString() {
            return "User with that ID not found.";
        }
    }

    private final UserRepository userRepository = new UserRepository();

    public User searchById(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}


