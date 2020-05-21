package lld;

import lld.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserManager {

    List<User> users;

    public UserManager() {
        users = populateDefaultUsers();
    }

    private List<User> populateDefaultUsers() {
        List<User> userList = new LinkedList<>();
        User user = new User(1, "aman,", "jadon");
        User user2 = new User(2, "rahul,", "baksh");
        User user3 = new User(3, "shivam,", "kash");
        User user4 = new User(4, "shaurya,", "oravat");
        User user5 = new User(5, "mehek,", "bakshi");

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        return userList;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }
}
