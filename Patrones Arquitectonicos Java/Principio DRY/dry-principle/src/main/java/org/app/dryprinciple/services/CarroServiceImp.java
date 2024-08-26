package org.app.dryprinciple.services;

import org.app.dryprinciple.Clases.Carro;
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
    public List<Carro> getCarros() throws SQLException {
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
    public Carro getCarroById(int id) throws SQLException {
        try (Statement statement = sqLconnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from carro where id = " + id);
            if (resultSet.next()) {
                return new Carro(resultSet.getInt("id"),resultSet.getString("marca"),resultSet.getString("modelo"));
            }
            throw new SQLException("Carro no encontrado");
        }
    }

    @Override
    public boolean addCarro(Carro carro) throws SQLException{
        try(PreparedStatement preparedStatement = sqLconnection.getConnection().prepareStatement("insert into carro(marca, modelo) values (?,?)")){
            preparedStatement.setString(1,carro.getMarca());
            preparedStatement.setString(2,carro.getModelo());
            preparedStatement.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean removeCarro(Carro carro) {
        return false;
    }

    @Override
    public boolean updateCarro(Carro carro) {
        return false;
    }
}
