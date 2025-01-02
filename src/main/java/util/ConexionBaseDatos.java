package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mariadb://localhost:3306/Jano";
    private static String username = "root";
    private static String password = "laa0304";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }

}
