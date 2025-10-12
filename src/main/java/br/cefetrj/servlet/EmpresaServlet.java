package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefetrj.dao.EmpresaDao;
import br.cefetrj.model.Desenvolvedora;
import br.cefetrj.model.Distribuidora;
import br.cefetrj.model.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Empresa")
public class EmpresaServlet extends HttpServlet
{
    private static final long serialVersionUID = 3L;
    private EmpresaDao dao = new EmpresaDao();

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            List<Empresa> empresas = dao.listarTodos();
            request.setAttribute("empresas", empresas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-empresas.jsp");
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
        
        try
        {
            if(request.getParameter("tipo").equals("desenvolvedora"))
            {
                Desenvolvedora empresa = new Desenvolvedora(nome);
                dao.inserir(empresa, null);

            }
            else if(request.getParameter("tipo").equals("distribuidora"))
            {
                Distribuidora empresa = new Distribuidora(nome);
                dao.inserir(empresa, null);

            }

            List<Empresa> empresas = dao.listarTodos();
            request.setAttribute("empresas", empresas);
            RequestDispatcher rd = request.getRequestDispatcher("lista-empresas.jsp");
            rd.forward(request, response);

        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }

    }*/

}
