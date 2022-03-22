package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() < 3) {
            return true;
        }
        if (password.length() < 8) {
            return true;
        }
        int letters = 0;
        int numbers = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch == '0' || ch == '1' || ch == '2' || ch == '3' ||
                ch == '4' || ch == '5' || ch == '6' || ch == '7' ||
                ch == '8' || ch == '9') {
                numbers++;
            } else {
                letters++;
            }
        }
        if (letters == 0 || numbers == 0) {
            return true;
        }
        return false;
    }
}
