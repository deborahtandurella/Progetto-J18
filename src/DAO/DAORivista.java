package DAO;

import model.Rivista;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAORivista {

    private static DAO.DAOFactory Dao;

    public void addRivista(Rivista riv) {
        try {
            Connection connection = Dao.createConnection();
            Statement st = connection.createStatement();
            String query=String.format("insert into books(ID,NOME,categotia,costo,TIPO_ABB) values (?,?,?,?,?)",
                    riv.getIDrivista(),riv.getNomeR(),riv.getCategoria(),riv.getCosto(),riv.getPeriodo());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
