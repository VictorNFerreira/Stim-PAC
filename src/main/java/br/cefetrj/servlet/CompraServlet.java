package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefetrj.dao.CompraDao;
import br.cefetrj.dao.ContaDao;
import br.cefetrj.model.Compra;
import br.cefetrj.model.Conta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Compra")
public class CompraServlet extends HttpServlet
{
    private static final long serialVersionUID = 4L;
    private CompraDao dao = new CompraDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            List<Compra> compras = dao.listarTodos();
            request.setAttribute("compras", compras);
            RequestDispatcher rd = request.getRequestDispatcher("lista-compras.jsp");
            rd.forward(request, response);

        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ContaDao contaDao = new ContaDao();
        Conta conta = contaDao.listarPorId(Integer.parseInt(request.getParameter("conta")));
        double valor = Double.parseDouble(request.getParameter("valor"));

        Compra compra = new Compra(conta, valor);
        compra.setFormaDePagamento(request.getParameter("forma-pagamento"));

        try
        {
            dao.inserir(compra);
            
            List<Compra> compras = dao.listarTodos();
            request.setAttribute("compras", compras);
            RequestDispatcher rd = request.getRequestDispatcher("lista-compras.jsp");
            rd.forward(request, response);

        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }

    }

}
