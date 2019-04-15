package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * L'url al database
     */
    public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/progettoj18";
    /**
     * Lo username per le operazioni sul DB
     */
    public static final String USER = "root";
    /**
     * La password per le operazioni sul DB
     */
    public static final String PASS = "root";

    /**
     * Metodo per creare una connessione sul DB MySQL
     *
 * @return l'oggetto Connection.
     */

    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }



}