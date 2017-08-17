package lesson22.hw22;

public class UserRepository {
    private static User[] users = new User[10];

    public static User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            // продолжение следующего кода;
            System.out.println("User with id " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServelException("Not enough space to save user with id " + user.getId());

    }

    public static User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServelException("Unexpected error");
    }

    public static void delete(long id) throws Exception {

        findById(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

    public static User findById(long id) throws Exception {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public static User[] getUsers() {
        return users;
    }
}
