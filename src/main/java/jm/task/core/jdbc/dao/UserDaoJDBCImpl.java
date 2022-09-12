package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    private String createUsersTable = "CREATE TABLE IF NOT EXISTS `users` ("
            + "`id` BIGINT NOT NULL AUTO_INCREMENT,"
            + "`name` VARCHAR(45) NOT NULL,"
            + "`lastName` VARCHAR(45) NOT NULL,"
            + "`age` TINYINT NOT NULL,"
            + "PRIMARY KEY (`id`))";
    private String dropUsersTable = "DROP TABLE IF EXISTS `users`";
    private String saveUser = "INSERT INTO users(name, lastName, age) VALUES(?, ?, ?)";
    private String removeUserById = "DELETE FROM users WHERE id = ";
    private String getAllUsers = "select * from users";
    private String cleanUsersTable = "TRUNCATE TABLE users";
    private PreparedStatement preparedstatement = null;
    private Connection connection = null;
    private Statement statement = null;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(createUsersTable);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void dropUsersTable() throws SQLException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(dropUsersTable);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(saveUser);
            preparedstatement.setString(1, name);
            preparedstatement.setString(2, lastName);
            preparedstatement.setByte(3, age);
            preparedstatement.executeUpdate();
            connection.commit();
            System.out.println("User с именем – "+ name +" добавлен в базу данных ");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) throws SQLException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(removeUserById + id);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
                System.out.println(user.toString());
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(cleanUsersTable);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
