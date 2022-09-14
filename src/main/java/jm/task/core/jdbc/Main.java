package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService uS = new UserServiceImpl();
        uS.createUsersTable();
        uS.saveUser("Карабас", "Барабас", (byte) 60);
        uS.saveUser("Папа", "Карло", (byte) 55);
        uS.saveUser("Бура", "Тино", (byte) 1);
        uS.saveUser("Лиса", "Алиса", (byte) 25);
        uS.removeUserById(1);
        uS.getAllUsers();
        uS.cleanUsersTable();
        uS.dropUsersTable();
    }
}
