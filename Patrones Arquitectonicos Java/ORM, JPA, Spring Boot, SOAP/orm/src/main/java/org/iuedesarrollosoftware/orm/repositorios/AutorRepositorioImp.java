package org.iuedesarrollosoftware.orm.repositorios;

import jakarta.persistence.*;
import org.iuedesarrollosoftware.orm.entidades.AutorEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AutorRepositorioImp implements AutorRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    public AutorRepositorioImp() {
        emf = Persistence.createEntityManagerFactory("autorPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public void save(AutorEntity autor){
        tx.begin();
        try{
            em.persist(autor);
            tx.commit();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(AutorEntity autor) {
        tx.begin();
        try{
            AutorEntity aut = em.find(AutorEntity.class, autor.getId());
             aut.setNombres(autor.getNombres());
             aut.setApellidos(autor.getApellidos());
             aut.setBiografia(autor.getBiografia());
             aut.setFechanacimiento(autor.getFechanacimiento());
             aut.setFechamuerte(autor.getFechamuerte());
             aut.setFechaactualizacion(LocalDate.now());
             aut.setActivo(true);
             em.merge(aut);
             tx.commit();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AutorEntity> findAll() {
        try{
            List<AutorEntity> lista = em.createQuery("select a from AutorEntity a").getResultList();
            return lista;
        }catch(NoResultException e){
            return new ArrayList<AutorEntity>();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public AutorEntity findOne(UUID id) throws NoResultException {
        return em.find(AutorEntity.class, id);
    }

    @Override
    public void delete(UUID id) {
        tx.begin();
        try {
            em.remove(em.find(AutorEntity.class, id));
            tx.commit();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}
