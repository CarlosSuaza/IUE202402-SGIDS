package org.app.dryprinciple.services;

import org.app.dryprinciple.clases.Carro;

import java.sql.SQLException;
import java.util.List;

public interface CarroService {

    public List<Carro> getCarros() throws SQLException, ClassNotFoundException;
    public void addCarro(Carro carro) throws SQLException, ClassNotFoundException;
    public void removeCarro(int id) throws SQLException, ClassNotFoundException;
    public void updateCarro(Carro carro, int id) throws SQLException, ClassNotFoundException;

}
