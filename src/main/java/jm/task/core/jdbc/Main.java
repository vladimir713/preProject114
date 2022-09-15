package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService uS = new UserServiceImpl();
        uS.createUsersTable();
        uS.saveUser("Карабас", "Барабас", (byte) 60);
        uS.saveUser("Папа", "Карло", (byte) 55);
        uS.saveUser("Бура", "Тино", (byte) 1);
        uS.saveUser("Лиса", "Алиса", (byte) 25);
        uS.removeUserById(3);
        List<User> users = uS.getAllUsers();
        for (User u: users) {
            System.out.println(u.toString());
        }
        uS.cleanUsersTable();
        uS.dropUsersTable();
    }
}
