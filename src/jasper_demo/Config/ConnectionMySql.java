/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper_demo.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author lts
 */
public class ConnectionMySql {

//    public Statement stmt;
    private String url = "jdbc:mysql://localhost/";
    private String db = "jasper_demo";
    private String driver = "com.mysql.jdbc.Driver";
    private String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
    private static Connection connection;

    private final static ConnectionMySql CONNECTION_MY_SQL = new ConnectionMySql();

    private ConnectionMySql() {
        try {
            // Load the JDBC driver
            Class.forName(driver);
            connection = DriverManager.getConnection(url + db + unicode, "root", "root");
            System.out.println("new connection");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "هناك خطأ في المكتبات اعد تثبيت البرنامج ثم حاول مره اخري"
                    + "\n اذا استمرت المشكله اتصل بنا", "خطأ", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            setConnection(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (CONNECTION_MY_SQL != null) {
            throw new IllegalStateException("Singleton already initialized");
        }

        setConnection(connection);

//        return connection;
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        }

    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static ConnectionMySql connectionMySql() {
        return CONNECTION_MY_SQL;
    }
}
