import java.sql.Connection;
import java.sql.DriverManager;

// TASK 1: Переиспользуй этот класс
// добавь обработку исключений на случай если пользователя нет в базе по такому айдишнику
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public User searchById(String id) {
        return userRepository.findById(id);
    }
}
