package br.cefetrj.servlet;

import br.cefetrj.dao.ContaDao;
import br.cefetrj.dao.ProdutoDao;
import br.cefetrj.model.Compra;
import br.cefetrj.model.Conta;
import br.cefetrj.model.Dlc;
import br.cefetrj.model.Jogo;
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
        ProdutoDao produtoDao = new ProdutoDao();

        if(request.getParameter("tipo").equals("jogo"))
        {
            Jogo produto = (Jogo) produtoDao.listarPorId(Integer.parseInt(request.getParameter("produto")));

            Compra compra = new Compra(conta, produto, valor);
            compra.setFormaDePagamento(request.getParameter("forma-pagamento"));

            if(id == null || id.isEmpty())
                compra.setId(null);
            else
                compra.setId(Integer.parseInt(id));

            return compra;

        }
            
        else if(request.getParameter("tipo").equals("dlc"))
        {
            Dlc produto = (Dlc) produtoDao.listarPorId(Integer.parseInt(request.getParameter("produto")));

            Compra compra = new Compra(conta, produto, valor);
            compra.setFormaDePagamento(request.getParameter("forma-pagamento"));

            if(id == null || id.isEmpty())
                compra.setId(null);
            else
                compra.setId(Integer.parseInt(id));

            return compra;

        }

        else
            return null;
            
    }

}
