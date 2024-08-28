package org.app.dryprinciple.services;

import org.app.dryprinciple.clases.Carro;
import org.app.dryprinciple.sqlUtil.SQLconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarroServiceImp implements CarroService{

    private final SQLconnection sqLconnection;

    public CarroServiceImp() {
        sqLconnection = new SQLconnection();
    }

    @Override
    public List<Carro> getCarros() throws SQLException, ClassNotFoundException {
        List<Carro> carros = new ArrayList<Carro>();
        try (Statement statement = sqLconnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from carro");
            while (resultSet.next()) {
                Carro carro = new Carro(resultSet.getInt("id"),resultSet.getString("marca"),resultSet.getString("modelo"));
                carros.add(carro);
            }
            return carros;
        }
    }

    @Override
    public void addCarro(Carro carro) throws SQLException, ClassNotFoundException {
        try(PreparedStatement preparedStatement = sqLconnection.getConnection().prepareStatement("insert into carro(marca, modelo) values (?,?)")) {
            preparedStatement.setString(1, carro.getMarca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void removeCarro(int id) throws SQLException, ClassNotFoundException {
        try(PreparedStatement preparedStatement = sqLconnection.getConnection().prepareStatement("delete from carro where id=?")) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateCarro(Carro carro, int id) throws SQLException, ClassNotFoundException {
        try(PreparedStatement preparedStatement = sqLconnection.getConnection().prepareStatement("update carro set marca=?, modelo=? where id=?")) {
            preparedStatement.setString(1,carro.getMarca());
            preparedStatement.setString(2,carro.getModelo());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        }
    }
}
