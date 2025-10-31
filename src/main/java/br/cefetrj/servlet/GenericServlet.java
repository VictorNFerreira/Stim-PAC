// package br.cefetrj.servlet;

// import br.cefetrj.dao.GenericDao;
// import br.cefetrj.model.Entidade;
// import br.cefetrj.model.Conta;
// import jakarta.servlet.http.*;

// import java.io.IOException;
// import java.lang.reflect.ParameterizedType;
// import java.util.List;

// public abstract class GenericServlet<Classe extends Entidade> extends HttpServlet
// {
//     protected GenericDao<Classe> dao;
//     private Class<Classe> classe;

//     @SuppressWarnings("unchecked")
//     public GenericServlet()
//     {
//         this.classe = (Class<Classe>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//         this.dao = new GenericDao<Classe>(classe)
//         {

//         };

//     }

//     // método utilitário para pegar o usuário logado
//     protected Conta getUsuarioLogado(HttpServletRequest request)
//     {
//         return (Conta) request.getSession().getAttribute("usuarioLogado");

//     }

//     protected abstract Classe preencherEntidade(HttpServletRequest request);

//     protected void inserirBibliotecaJogo(Classe entidade, Conta conta)
//     {

//     }

//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
//     {
//         String acao = request.getParameter("acao");
//         if(acao == null)
//             acao = "listar";
//         Conta usuario = getUsuarioLogado(request);
//         String urlSubmit = request.getContextPath() + "/" + classe.getSimpleName().toLowerCase();
//         request.setAttribute("urlSubmit", urlSubmit);
//         if(usuario == null)
//         {
//             /**
//              * Implementar redirecionamento para página de acesso negado. Faremos mais para
//              * frente
//              * response.sendRedirect("acesso-negado.jsp");
//              * return;
//              */
//         }

//         try
//         {
//             if(acao.equals("inserir"))
//             {
//                 try
//                 {
//                     request.getRequestDispatcher(classe.getSimpleName().toLowerCase() + "/form.jsp").forward(request, response);

//                 }
//                 catch (Exception e)
//                 {
//                     e.printStackTrace();

//                 }

//             }

//             else if(acao.equals("listar"))
//             {
//                 List<Classe> lista = dao.listarTodos();
//                 request.setAttribute("lista", lista);
//                 try
//                 {
//                     request.getRequestDispatcher(classe.getSimpleName().toLowerCase() + "/lista.jsp").forward(request, response);

//                 }
//                 catch(Exception e)
//                 {
//                     e.printStackTrace();

//                 }

//             }
                    
//             else if(acao.equals("listarPorId"))
//             {
//                 int idBuscar = Integer.parseInt(request.getParameter("id"));
//                 Classe entidade = dao.listarPorId(idBuscar);
//                 request.setAttribute("entidade", entidade);
//                 try
//                 {
//                     request.getRequestDispatcher(classe.getSimpleName().toLowerCase() + "/form.jsp").forward(request, response);

//                 }
//                 catch (Exception e)
//                 {
//                     e.printStackTrace();

//                 }
                
//             }
            
//             else if(acao.equals("deletar"))
//             {
//                 int id = Integer.parseInt(request.getParameter("id"));
//                 dao.deletar(id);
//                 response.sendRedirect(urlSubmit + "?acao=listar");
            
//             }

//         }
//         catch (Exception e)
//         {
//             e.printStackTrace();
//             //response.sendRedirect("erro.jsp");

//         }

//     }

//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
//     {
//         String acao = request.getParameter("acao");
//         Conta conta = getUsuarioLogado(request);
//         String urlSubmit = request.getContextPath() + "/" + classe.getSimpleName().toLowerCase();
//         request.setAttribute("urlSubmit", urlSubmit);

//         try
//         {
//             if(acao.equals("cadastrar"))
//             {
//                 Classe entidade = preencherEntidade(request);
//                 dao.inserir(entidade, conta);
//                 inserirBibliotecaJogo(entidade, conta);
                    
//             }

//             else if(acao.equals("atualizar"))
//             {
//                 Classe entidadeAtualizada = preencherEntidade(request);
//                 dao.atualizar(entidadeAtualizada, conta);
                    
//             }
            
//             response.sendRedirect(urlSubmit + "?acao=listar");

//         }
//         catch(Exception e)
//         {
//             e.printStackTrace();
//             //response.sendRedirect("erro.jsp");

//         }

//     }

// }
