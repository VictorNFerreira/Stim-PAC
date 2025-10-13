package br.cefetrj.servlet;

import br.cefetrj.dao.BibliotecaDao;
import br.cefetrj.model.Biblioteca;
import br.cefetrj.model.Conta;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/conta")
public class ContaServlet extends GenericServlet<Conta>
{
    @Override
    protected Conta preencherEntidade(HttpServletRequest request)
    {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Conta conta = new Conta(nome, email, senha);

        if(id == null || id.isEmpty())
            conta.setId(null);
        else
            conta.setId(Integer.parseInt(id));

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        biblioteca.setConta(conta);
        conta.setBiblioteca(biblioteca);
        bibliotecaDao.inserir(biblioteca, conta);

        return conta;

    }

}
