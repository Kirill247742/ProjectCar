package car;

import java.sql.*;
import java.util.ArrayList;

public class CarDB {

    private static String url = "jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "247742";

    public static ArrayList<Car> select() {

        ArrayList<Car> cars = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
                while(resultSet.next()){

                    int car_id = resultSet.getInt(1);
                    int seller_id = resultSet.getInt(2);
                    int location_id = resultSet.getInt(3);
                    String model = resultSet.getString(4);
                    String brand = resultSet.getString(5);
                    int age = resultSet.getInt(6);
                    int mileage = resultSet.getInt(7);
                    int price = resultSet.getInt(8);
                    String colour = resultSet.getString(9);

                    Car car = new Car(car_id, seller_id, location_id, model, brand, age, mileage,
                            price, colour);
                    cars.add(car);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return cars;
    }

    public static Car selectOne(int car_id) {

        Car car = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM cars WHERE car_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, car_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int carId = resultSet.getInt(1);
                        int sellId = resultSet.getInt(2);
                        int locId = resultSet.getInt(3);
                        String model = resultSet.getString(4);
                        String brand = resultSet.getString(5);
                        int age = resultSet.getInt(6);
                        int mileage = resultSet.getInt(7);
                        int price = resultSet.getInt(8);
                        String colour = resultSet.getString(9);

                        car = new Car(carId, sellId, locId, model, brand, age, mileage, price, colour);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return car;
    }
    public static int insert(Car car) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO cars (seller_id, location_id, model, brand, age, mileage, price, colour) Values (?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, car.getSeller_id());
                    preparedStatement.setInt(2, car.getLocation_id());
                    preparedStatement.setString(3, car.getModel());
                    preparedStatement.setString(4, car.getBrand());
                    preparedStatement.setInt(5, car.getAge());
                    preparedStatement.setInt(6, car.getMileage());
                    preparedStatement.setInt(7, car.getPrice());
                    preparedStatement.setString(8, car.getColour());



                    return  preparedStatement.executeUpdate();

                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;

    }

    public static int update(Car car) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE cars SET seller_id = ?, location_id = ?, model = ?, brand = ?, age = ?, mileage = ?, price = ?, colour = ? WHERE car_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, car.getSeller_id());
                    preparedStatement.setInt(2, car.getLocation_id());
                    preparedStatement.setString(3, car.getModel());
                    preparedStatement.setString(4, car.getBrand());
                    preparedStatement.setInt(5, car.getAge());
                    preparedStatement.setInt(6, car.getMileage());
                    preparedStatement.setInt(7, car.getPrice());
                    preparedStatement.setString(8, car.getColour());
                    preparedStatement.setInt(9, car.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int car_id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM cars WHERE car_id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, car_id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }



    public static ArrayList<Car> selectfiltr(String searchbrand) {

        ArrayList<Car> cars = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "SELECT * FROM cars WHERE brand=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, searchbrand);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {

                        int car_id = resultSet.getInt(1);
                        int seller_id = resultSet.getInt(2);
                        int location_id = resultSet.getInt(3);
                        String model = resultSet.getString(4);
                        String brand = resultSet.getString(5);
                        int age = resultSet.getInt(6);
                        int mileage = resultSet.getInt(7);
                        int price = resultSet.getInt(8);
                        String colour = resultSet.getString(9);

                        Car car = new Car(car_id, seller_id, location_id, model, brand, age, mileage,
                                price, colour);
                        cars.add(car);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return cars;
    }
}