package br.cefetrj.servlet;

import br.cefetrj.model.Biblioteca;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;


@WebServlet("/Biblioteca")
public class BibliotecaServlet extends GenericServlet<Biblioteca>
{
    @Override
    protected Biblioteca preencherEntidade(HttpServletRequest request)
    {
        Biblioteca biblioteca = new Biblioteca();
        return biblioteca;

    }
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
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

    }*/
}
