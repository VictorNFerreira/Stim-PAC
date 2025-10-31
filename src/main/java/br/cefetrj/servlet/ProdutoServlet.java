// package br.cefetrj.servlet;

// import br.cefetrj.model.Produto;
// import br.cefetrj.model.Jogo;
// import br.cefetrj.dao.EmpresaDao;
// import br.cefetrj.dao.ProdutoDao;
// import br.cefetrj.model.Desenvolvedora;
// import br.cefetrj.model.Distribuidora;
// import br.cefetrj.model.Dlc;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServletRequest;

// @WebServlet("/produto")
// public class ProdutoServlet extends GenericServlet<Produto>
// {
//     @Override
//     protected Produto preencherEntidade(HttpServletRequest request)
//     {
//         String id = request.getParameter("id");
//         String nome = request.getParameter("nome");
//         EmpresaDao empresaDao = new EmpresaDao();
//         Desenvolvedora desenvolvedora = (Desenvolvedora) empresaDao.listarPorId(Integer.parseInt(request.getParameter("desenvolvedora")));
//         Distribuidora distribuidora = (Distribuidora) empresaDao.listarPorId(Integer.parseInt(request.getParameter("distribuidora")));

//         if(request.getParameter("tipo").equals("jogo"))
//         {
//             String genero = request.getParameter("genero");

//             Jogo produto = new Jogo(nome, desenvolvedora, distribuidora, genero);
//             produto.setPreco(Double.parseDouble(request.getParameter("preco")));

//             produto.getDesenvolvedora().getProdutosDesenvolvidos().add(produto);
//             produto.getDistribuidora().getProdutosPublicados().add(produto);

//             if(id == null || id.isEmpty())
//                 produto.setId(null);
//             else
//                 produto.setId(Integer.parseInt(id));

//             return produto;

//         }
        
//         else if(request.getParameter("tipo").equals("dlc"))
//         {
//             ProdutoDao produtoDao= new ProdutoDao();
//             Jogo jogoAssociado = (Jogo) produtoDao.listarPorId(Integer.parseInt(request.getParameter("jogo-associado")));

//             Dlc produto = new Dlc(nome, desenvolvedora, distribuidora, jogoAssociado);
//             produto.setPreco(Double.parseDouble(request.getParameter("preco")));

//             produto.getDesenvolvedora().getProdutosDesenvolvidos().add(produto);
//             produto.getDistribuidora().getProdutosPublicados().add(produto);
//             jogoAssociado.getDlcs().add(produto);

//             if(id == null || id.isEmpty())
//                 produto.setId(null);
//             else
//                 produto.setId(Integer.parseInt(id));

//             return produto;

//         }

//         else
//             return null;

//     }

// }
