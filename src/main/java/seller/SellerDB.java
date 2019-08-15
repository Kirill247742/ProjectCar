package seller;

import java.sql.*;
import java.util.ArrayList;

public class SellerDB {

    private static String url = "jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "247742";

    public static ArrayList<Seller> select() {

        ArrayList<Seller> sellers = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM sellers");
                while(resultSet.next()){

                    int seller_id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String  gender = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    String email = resultSet.getString(5);
                    long telnumber = resultSet.getLong(6);
                    Seller seller = new Seller(seller_id, name, gender, age, email, telnumber);
                    sellers.add(seller);


                }
                try { conn.close(); } catch (Exception e) { /* ignored */ }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }



        return sellers;
    }

    public static Seller selectOne(int seller_id) {

        Seller seller = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM sellers WHERE seller_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, seller_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int sellId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String gender = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        String email = resultSet.getString(5);
                        long telnumber = resultSet.getLong(6);
                        seller = new Seller(sellId, name, gender, age, email, telnumber);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return seller;
    }
    public static int insert(Seller seller) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO sellers (name, gender, age, email, telnumber) Values (?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, seller.getName());
                    preparedStatement.setString(2, seller.getGender());
                    preparedStatement.setInt(3, seller.getAge());
                    preparedStatement.setString(4, seller.getEmail());
                    preparedStatement.setLong(5, seller.getTelnumber());



                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Seller seller) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE sellers SET name = ?, gender = ?, age = ?, email = ?, telnumber = ? WHERE seller_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, seller.getName());
                    preparedStatement.setString(2, seller.getGender());
                    preparedStatement.setInt(3, seller.getAge());
                    preparedStatement.setString(4, seller.getEmail());
                    preparedStatement.setLong(5, seller.getTelnumber());
                    preparedStatement.setInt(6, seller.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int seller_id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM sellers WHERE seller_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, seller_id);

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