package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.commons.ConnectionFactory;
import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Jogo;

public class JogoDao
{
    private Connection con;

    public JogoDao()
    {
        this.con = ConnectionFactory.getConnection();

    }

    public void inserir(Jogo jogo) throws SQLException
    {
        String sql = "INSERT INTO jogo (nome, preco, genero) VALUES(?, ?, ?)";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, jogo.getNome());
        stmt.setDouble(2, jogo.getPreco());
        stmt.setString(3, jogo.getGenero());
        stmt.execute();
        stmt.close();
        con.close();

    }

    public List<Jogo> listarJogoBiblioteca(Biblioteca biblioteca) throws SQLException
    {
        String sql = "SELECT id, nome, preco, genero FROM jogo WHERE idBiblioteca = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, biblioteca.getId());
        ResultSet rs = stmt.executeQuery();
        List<Jogo> jogos = new ArrayList<Jogo>();
        
        while(rs.next())
        {
            Jogo jogo = new Jogo(rs.getString("nome"), rs.getDouble("preco"), rs.getString("genero"));
            jogo.setId(rs.getInt("id"));
            jogos.add(jogo);

        }

        stmt.execute();
        stmt.close();
        return jogos;

    }

}
