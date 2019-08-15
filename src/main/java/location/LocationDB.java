package location;

import java.sql.*;
import java.util.ArrayList;

public class LocationDB {

    private static String url = "jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "247742";

    public static ArrayList<Location> select() {

        ArrayList<Location> locations = new ArrayList<Location>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM locations");
                while(resultSet.next()){

                    int location_id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Location location = new Location(location_id, name);
                    locations.add(location);
                }
                try { conn.close(); } catch (Exception e) { /* ignored */ }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return locations;
    }
    public static Location selectOne(int location_id) {

        Location location = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM locations WHERE location_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, location_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int locId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        location = new Location(locId, name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return location;
    }
    public static int insert(Location location) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO locations (name) Values (?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, location.getName());


                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Location location) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE locations SET name = ? WHERE location_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, location.getName());
                    preparedStatement.setInt(2, location.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int location_id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM locations WHERE location_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, location_id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}