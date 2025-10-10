package br.cefetrj.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetrj.model.Conta;
import br.cefetrj.utils.HibernateUtil;
import jakarta.persistence.EntityManager;

public class ContaDao
{
    private final Class<Conta> conta = Conta.class;

    public void inserir(Conta conta) throws SQLException
    {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(conta);
            entityManager.getTransaction().commit();

        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();

        }

        /*String sql = "INSERT INTO conta (nome, email, senha, id_biblioteca) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, conta.getNome());
        stmt.setString(2, conta.getEmail());
        stmt.setString(3, conta.getSenha());
        stmt.setInt(4, conta.getBiblioteca().getId());
        stmt.execute();
        stmt.close(); */

    }

    public List<Conta> listarTodos() throws SQLException
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.createQuery("FROM " + conta.getSimpleName(), conta).getResultList();

        }
         
        /*String sql = "SELECT id, nome, email, senha, saldo, id_biblioteca FROM conta";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Conta> contas = new ArrayList<Conta>();

        while(rs.next())
        {
            Conta conta = new Conta(rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
            conta.setId(rs.getInt("id"));
            conta.setSaldo(rs.getDouble("saldo"));

            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId(rs.getInt("id_biblioteca"));
            conta.setBiblioteca(biblioteca);
            
            contas.add(conta);

        }

        stmt.execute();
        stmt.close();
        return contas;*/

    }

    public Conta listarPorId(int id)
    {
        try(EntityManager entityManager = HibernateUtil.getEntityManager())
        {
            return entityManager.find(conta, id);
        }

    }

}
