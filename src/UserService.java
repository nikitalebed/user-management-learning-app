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
    public void setCheckedNewUser (String login, String password){
        userRepository.newUser(login, password);
        if (login == null & password == null){
            throw new UserNotFoundException();
        }
    }
}


