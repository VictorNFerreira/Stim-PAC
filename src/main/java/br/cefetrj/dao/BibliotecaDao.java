package br.cefetrj.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetrj.model.Biblioteca;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

public class BibliotecaDao
{
    private final Class<Biblioteca> biblioteca = Biblioteca.class;

    public Biblioteca inserir(Biblioteca biblioteca) throws SQLException
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(biblioteca);
            entityManager.getTransaction().commit();
            
        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();

        }

        return biblioteca;

        /*String sql = "INSERT INTO biblioteca() VALUES()";
        PreparedStatement stmt = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if(generatedKeys.next())
        {
            Long id = generatedKeys.getLong(1);
            biblioteca.setId(id.intValue());

        }

        generatedKeys.close();
        stmt.close();
        return biblioteca;*/

    }

    public List<Biblioteca> listarTodos() throws SQLException
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + biblioteca.getSimpleName(), biblioteca).getResultList();

        }

        /*String sql = "SELECT id, quantidade_itens FROM biblioteca";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
        //JogoDao jogoDao = new JogoDao();
        
        while(rs.next())
        {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId(rs.getInt("id"));
            //biblioteca.setJogos(jogoDao.listarJogoBiblioteca(biblioteca));
            bibliotecas.add(biblioteca);

        }

        stmt.execute();
        stmt.close();
        return bibliotecas;*/

    }
    
}
