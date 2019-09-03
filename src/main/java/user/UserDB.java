package user;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {

    private static String url = "jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String pasword = "247742";

    public static ArrayList<User> select() {

        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int user_id = resultSet.getInt(1);
                    String login = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String role = resultSet.getString(4);

                    User user = new User(user_id, login, password, role);
                    users.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }

    public static User selectOne(int user_id) {

        User user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                String sql = "SELECT * FROM users WHERE user_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, user_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int userId = resultSet.getInt(1);
                        String login = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        String role = resultSet.getString(4);

                        user = new User(userId, login, password, role);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }

    public static int insert(User user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                String sql = "INSERT INTO users (login, password, role) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPassword());
                    preparedStatement.setString(3, user.getRole());

                    return  preparedStatement.executeUpdate();

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;

    }


    public static int delete(int user_id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                String sql = "DELETE FROM users WHERE user_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, user_id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }


    public static String selectRoleByLoginPassword(String login, String password) {

        String role=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                String sql = "SELECT role FROM users WHERE (login=?) and (password=?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        role = resultSet.getString(1);


                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return role;
    }


    public static boolean userIsExist(String login, String password) {
        boolean a=false;
        Integer user_id=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, pasword)){

                String sql = "SELECT user_id FROM users WHERE (login=?) and (password=?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        user_id = resultSet.getInt(1);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        if(user_id!=null) a=true;
        return a;
    }
}
