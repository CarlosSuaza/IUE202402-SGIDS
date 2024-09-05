package org.iuedesarrollosoftware.orm.repositorios;

import jakarta.persistence.*;
import org.iuedesarrollosoftware.orm.entidades.AutorEntity;

import java.util.ArrayList;
import java.util.List;


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
    public AutorEntity save(AutorEntity autor){
        AutorEntity au = null;
        tx.begin();
        try{
            au = em.merge(autor);
            tx.commit();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
        return au;
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
    public AutorEntity findOne(String id) throws NoResultException {
        return em.find(AutorEntity.class, id);
    }

    @Override
    public void delete(String id) {
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
