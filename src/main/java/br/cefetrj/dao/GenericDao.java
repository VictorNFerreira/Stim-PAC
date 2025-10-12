package br.cefetrj.dao;

import java.util.List;

import br.cefetrj.model.Entidade;
import br.cefetrj.model.Conta;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

public abstract class GenericDao<Classe extends Entidade>
{
    private final Class<Classe> classe;

    public GenericDao(Class<Classe> classe)
    {
        this.classe = classe;

    }

    public void inserir(Classe entidade, Conta conta)
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            entidade.setCriadoPor(conta);
            entidade.setDataCriacao(java.time.LocalDate.now());
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();

        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();

        }
    }

    public void atualizar(Classe entidade, Conta conta)
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entidade.setAlteradoPor(conta);
        entidade.setDataUltimaAlteracao(java.time.LocalDate.now());
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();

    }

    public void deletar(int id)
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Classe usuario = entityManager.find(classe, id);
        if(usuario != null)
            entityManager.remove(usuario);
        entityManager.getTransaction().commit();

    }

    public List<Classe> listarTodos()
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + classe.getSimpleName(), classe).getResultList();

        }

    }

    public Classe listarPorId(int id)
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.find(classe, id);

        }

    }

    public List<Classe> listarPorTipo(String tipo)
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + classe.getSimpleName() + "WHERE tipo = " + tipo, classe).getResultList();

        }

    }

}
