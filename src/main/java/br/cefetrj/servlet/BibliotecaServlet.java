package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefetrj.dao.BibliotecaDao;
import br.cefetrj.model.Biblioteca;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Biblioteca")
public class BibliotecaServlet extends HttpServlet
{
    private static final long serialVersionUID = 5L;
    private BibliotecaDao dao = new BibliotecaDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            List<Biblioteca> bibliotecas = dao.listarTodos();
            request.setAttribute("bibliotecas", bibliotecas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-bibliotecas.jsp");
            rd.forward(request, response);

        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }

    }
}
