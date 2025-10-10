package br.cefetrj.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetrj.model.Compra;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

public class CompraDao
{
    private final Class<Compra> compra = Compra.class;

    public void inserir(Compra compra) throws SQLException
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(compra);
            entityManager.getTransaction().commit();

        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();

        }

    }

    public List<Compra> listarTodos() throws SQLException
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + compra.getSimpleName(), compra).getResultList();

        }

    }

}
