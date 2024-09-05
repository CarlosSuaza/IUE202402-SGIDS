package org.iuedesarrollosoftware.orm.repositorios;

import org.iuedesarrollosoftware.orm.entidades.AutorEntity;

import java.util.List;

public interface AutorRepositorio {

    AutorEntity save(AutorEntity autor);
    List<AutorEntity> findAll();
    AutorEntity findOne(String id);
    void delete(String id);
}
