package br.cefetrj.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetrj.model.Empresa;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

public class EmpresaDao
{
    private final Class<Empresa> empresa = Empresa.class;

    public void inserir(Empresa empresa) throws SQLException
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(empresa);
            entityManager.getTransaction().commit();

        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();

        }

    }

    public List<Empresa> listarTodos() throws SQLException
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + empresa.getSimpleName(), empresa).getResultList();

        }

    }
    
}
