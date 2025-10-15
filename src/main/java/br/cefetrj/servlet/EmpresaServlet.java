package br.cefetrj.servlet;

import br.cefetrj.model.Desenvolvedora;
import br.cefetrj.model.Distribuidora;
import br.cefetrj.model.Empresa;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/empresa")
public class EmpresaServlet extends GenericServlet<Empresa>
{
    @Override
    protected Empresa preencherEntidade(HttpServletRequest request)
    {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        
        if(request.getParameter("tipo").equals("desenvolvedora"))
        {
            Desenvolvedora empresa = new Desenvolvedora(nome);

            if(id == null || id.isEmpty())
                empresa.setId(null);
            else
                empresa.setId(Integer.parseInt(id));

            return empresa;

        }
        else if(request.getParameter("tipo").equals("distribuidora"))
        {
            Distribuidora empresa = new Distribuidora(nome);

            if(id == null || id.isEmpty())
                empresa.setId(null);
            else
                empresa.setId(Integer.parseInt(id));

            return empresa;

        }

        else
            return null;

    }

}
