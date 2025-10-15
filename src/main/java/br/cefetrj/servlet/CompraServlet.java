package br.cefetrj.servlet;

import br.cefetrj.dao.ContaDao;
import br.cefetrj.model.Compra;
import br.cefetrj.model.Conta;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/compra")
public class CompraServlet extends GenericServlet<Compra>
{
    @Override
    protected Compra preencherEntidade(HttpServletRequest request)
    {
        String id = request.getParameter("id");
        ContaDao contaDao = new ContaDao();
        Conta conta = contaDao.listarPorId(Integer.parseInt(request.getParameter("conta")));
        double valor = Double.parseDouble(request.getParameter("valor"));

        Compra compra = new Compra(conta, valor);
        compra.setFormaDePagamento(request.getParameter("forma-pagamento"));

        if(id == null || id.isEmpty())
            compra.setId(null);
        else
            compra.setId(Integer.parseInt(id));

        return compra;

    }

}
