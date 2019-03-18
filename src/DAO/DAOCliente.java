package DAO;

import model.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//Classe per settare la connesione con il database
public class DAOCliente {

    private static DAO.DAOFactory Dao;

    public static boolean Validate(String username, String pass) {


        boolean v = false;
        try {
            Connection connection = Dao.getConnection();
            Statement st = connection.createStatement();
            String query = String.format("SELECT * FROM users WHERE username=useername AND pass=pass");
            st.execute(query);
            v = true;
        } catch (SQLException e) {
        }
        return v;
    }

    public void save(Cliente customer) {
        try {
            Connection connection = Dao.getConnection();
            Statement st = connection.createStatement();
            String query = String.format("insert into users (USERNAME,PASS,NOME,COGNOME,INDIRIZZO,DATANASCITA,EMAIL) values (?,?,?,?,?,?,?)",
                    customer.getUsername(), customer.getPassword(), customer.getNome(), customer.getCognome(), customer.getIndirizzo(),
                    customer.getDataNascita(), customer.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}