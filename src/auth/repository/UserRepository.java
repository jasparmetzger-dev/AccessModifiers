package auth.repository;
import auth.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }
    public static void removeUser(User user) {
        users.remove(user);
    }
    public static List<User> showAll() {
        return List.copyOf(users);
    }
    public static User findByUsername(String username) {
        for (User user : users) {
            if(user.getUsername().equals(username)) return user;
        }
        return null;
    }
}
