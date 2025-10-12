package br.cefetrj.servlet;

import br.cefetrj.dao.GenericDao;
import br.cefetrj.model.Entidade;
import br.cefetrj.model.Conta;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericServlet<Classe extends Entidade> extends HttpServlet
{
    protected GenericDao<Classe> dao;
    private Class<Classe> classe;

    @SuppressWarnings("unchecked")
    public GenericServlet()
    {
        this.classe = (Class<Classe>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dao = new GenericDao<Classe>(classe)
        {

        };

    }

    // método utilitário para pegar o usuário logado
    protected Conta getUsuarioLogado(HttpServletRequest request)
    {
        return (Conta) request.getSession().getAttribute("usuarioLogado");

    }

    protected abstract Classe preencherEntidade(HttpServletRequest request);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String acao = request.getParameter("acao");
        if(acao == null)
            acao = "listar";
        Conta usuario = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + classe.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);
        if(usuario == null)
        {
            /**
             * Implementar redirecionamento para página de acesso negado. Faremos mais para
             * frente
             * response.sendRedirect("acesso-negado.jsp");
             * return;
             */
        }

        try
        {
            switch(acao)
            {
                case "deletar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.deletar(id);
                    response.sendRedirect(urlSubmit + "?acao=listar");
                    break;

                case "listar":
                    List<Classe> lista = dao.listarTodos();
                    request.setAttribute("lista", lista);
                    try
                    {
                        request.getRequestDispatcher("lista-" + classe.getSimpleName().toLowerCase() + "s.jsp").forward(request, response);

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();

                    }
                    break;

                case "buscar":
                    int idBuscar = Integer.parseInt(request.getParameter("id"));
                    Classe entidade = dao.listarPorId(idBuscar);
                    request.setAttribute("entidade", entidade);
                    try
                    {
                        request.getRequestDispatcher("cadastro-" + classe.getSimpleName().toLowerCase() + ".jsp").forward(request, response);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();

                    }
                    break;
                case "novo":
                    try
                    {
                        request.getRequestDispatcher("cadastro-" + classe.getSimpleName().toLowerCase() + ".jsp").forward(request, response);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();

                    }
                    break;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            //response.sendRedirect("erro.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String acao = request.getParameter("acao");
        Conta conta = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + classe.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);

        try
        {
            switch(acao)
            {
                case "cadastrar":
                    Classe entidade = preencherEntidade(request);
                    dao.inserir(entidade, conta);
                    break;
                case "atualizar":
                    Classe entidadeAtualizada = preencherEntidade(request);
                    dao.atualizar(entidadeAtualizada, conta);
                    break;

            }
            response.sendRedirect(urlSubmit + "?acao=listar");

        }
        catch(Exception e)
        {
            e.printStackTrace();
            //response.sendRedirect("erro.jsp");

        }

    }

}
