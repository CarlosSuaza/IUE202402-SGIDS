package org.app.dryprinciple.services;

import org.app.dryprinciple.Clases.Carro;

import java.sql.SQLException;
import java.util.List;

public interface CarroService {

    public List<Carro> getCarros() throws SQLException;
    public Carro getCarroById(int id) throws SQLException;
    public boolean addCarro(Carro carro) throws SQLException;
    public boolean removeCarro(Carro carro);
    public boolean updateCarro(Carro carro);

}
