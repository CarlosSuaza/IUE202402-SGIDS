package org.iuedesarrollosoftware.orm.repositorios;

import org.iuedesarrollosoftware.orm.entidades.AutorEntity;

import java.util.List;
import java.util.UUID;

public interface AutorRepositorio {

    void save(AutorEntity autor);
    List<AutorEntity> findAll();
    AutorEntity findOne(String id);
    void delete(UUID id);
}
