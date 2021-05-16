package sample;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Maryam Askari
 * Date: 5/14/2021
 * Time: 6:51 PM
 * Project: IntelliJ IDEA
 */
public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getConnection() {
        String databaseUser="maryam";
        String databasePassword = "myjava123";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
