package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao uD = new UserDaoJDBCImpl();
        uD.createUsersTable();
        uD.saveUser("Карабас", "Барабас", (byte) 60);
        uD.saveUser("Папа", "Карло", (byte) 55);
        uD.saveUser("Бура", "Тино", (byte) 1);
        uD.saveUser("Лиса", "Алиса", (byte) 25);
        uD.removeUserById(1);
        uD.getAllUsers();
        uD.cleanUsersTable();
        uD.dropUsersTable();
    }
}
