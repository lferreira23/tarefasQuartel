
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Classe ConnectionManager para gerenciar conexões com o Banco de Dados
 */
public class ConnectionManager {
    
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/quartel";
    static String username = "quartel";
    static String password = "123456";
    
    private static Connection connection = null;
    
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(true);
        return connection;
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
    public static boolean isConnected() {
        return connection != null;
    }
}
