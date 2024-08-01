package io.deeplay.camp.user;

import entity.User;
import io.deeplay.camp.dao.UserDAO;
import io.deeplay.camp.password.PasswordService;

import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public int addUser(User user) throws SQLException {
        return userDAO.addUser(user);
    }
    
    public Optional<User> getUserByUsername(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }
    
    public boolean verifyPassword(String password, String userPassword) {
        return PasswordService.checkPassword(password, userPassword);
    }
}