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
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Conta conta = new Conta(nome, email, senha);

        Biblioteca biblioteca = new Biblioteca();
        BibliotecaDao bibliotecaDao = new BibliotecaDao();
        biblioteca.setConta(conta);
        conta.setBiblioteca(biblioteca);
        bibliotecaDao.inserir(biblioteca, conta);

        return conta;

    }
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            List<Conta> contas = dao.listarTodos();
            request.setAttribute("contas", contas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-contas.jsp");
            rd.forward(request, response);

        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
 
        Conta conta = new Conta(nome, email, senha);

        try
        {
            dao.inserir(conta);

            Biblioteca biblioteca = new Biblioteca();
            BibliotecaDao bibliotecaDao = new BibliotecaDao();
            biblioteca.setConta(conta);
            conta.setBiblioteca(biblioteca);
            biblioteca = bibliotecaDao.inserir(biblioteca);
            
            List<Conta> contas = dao.listarTodos();
            request.setAttribute("contas", contas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-contas.jsp");
            rd.forward(request, response);

        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

    }*/

}
