package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY = "insert into workshop3.users (email, username, password) values (?,?,?);";
    private static final String READ_USER_QUERY_BY_ID = "select * from workshop3.users where id = ?;";
    private static final String UPDATE_USER_QUERY = "update workshop3.users set email=?, username=?, password=? where id = ?;";
    private static final String DELETE_USER_BY_ID = "delete from workshop3.users where id = ?;";
    private static final String READ_ALL_USERS = "select * from workshop3.users;";

    public User create(User user) {
        try (Connection connection =  DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, hashPassword(user.getPassword()));

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }

            return user;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int UserId) {
        try(Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_QUERY_BY_ID)) {

            preparedStatement.setInt(1,UserId);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setUserName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));

                return user;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


    public void update (User user) {
        try(Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {

            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3,hashPassword(user.getPassword()));
            preparedStatement.setInt(4, user.getId());

            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId) {
        try(Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID)) {

            preparedStatement.setInt(1,userId);
            preparedStatement.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User [] findAll() {
        try(Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement()) {

            User [] users = new User[0];


            try(ResultSet resultSet = statement.executeQuery(READ_ALL_USERS)) {
                while(resultSet.next()) {

                    User user = new User();

                    user.setId(resultSet.getInt(1));
                    user.setEmail(resultSet.getString(2));
                    user.setUserName(resultSet.getString(3));
                    user.setPassword(resultSet.getString(4));

                    users = addNewUser(users, user);

                }
            }

            return users;

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return new User [0];

    }


    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static User [] addNewUser(User [] arr, User user) {
        arr = Arrays.copyOf(arr, arr.length+1);
        arr[arr.length-1] = user;
        return arr;
    }

}


