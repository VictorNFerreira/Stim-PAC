package br.cefetrj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.model.Produto;
import br.cefetrj.model.Jogo;
import br.cefetrj.model.Dlc;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Produto")
public class ProdutoServlet extends HttpServlet
{
    private static final long serialVersionUID = 2L;
    private List<Produto> produtos = criarProduto();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("lista-produtos.jsp");
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        if(request.getParameter("tipo").equals("jogo"))
            produtos.add(new Jogo(request.getParameter("nome"), Double.parseDouble(request.getParameter("preco")), request.getParameter("genero")));
        else if(request.getParameter("tipo").equals("dlc"))
        {
            Jogo jogoAssociado = new Jogo(request.getParameter("jogo-associado"), 0, null);
            produtos.add(new Dlc(request.getParameter("nome"),  Double.parseDouble(request.getParameter("preco")), jogoAssociado));

        }
            
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("lista-produtos.jsp");
        rd.forward(request, response);

    }

    private List<Produto> criarProduto()
    {
        List<Produto> produtos = new ArrayList<Produto>();

        Jogo jogo1 = new Jogo("Destiny 2", 250, "FPS");
        Jogo jogo2 = new Jogo("Minecraft", 100, "Simulação");
        Jogo jogo3 = new Jogo("Hollow Knight", 60, "Metroidvania");

        Dlc dlc1_jogo1 = new Dlc("Renegados", 200, jogo1);
        jogo1.adicionarDlc(dlc1_jogo1);
        dlc1_jogo1.setJogoAssociado(jogo1);

        Dlc dlc2_jogo1 = new Dlc("A Forma Final", 400, jogo1);
        jogo1.adicionarDlc(dlc2_jogo1);
        dlc2_jogo1.setJogoAssociado(jogo1);

        produtos.add(jogo1);
        produtos.add(jogo2);
        produtos.add(jogo3);
        produtos.add(dlc1_jogo1);
        produtos.add(dlc2_jogo1);

        return produtos;

    }

}
