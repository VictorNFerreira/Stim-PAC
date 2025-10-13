package br.cefetrj.servlet;

import br.cefetrj.model.Biblioteca;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;


@WebServlet("/biblioteca")
public class BibliotecaServlet extends GenericServlet<Biblioteca>
{
    @Override
    protected Biblioteca preencherEntidade(HttpServletRequest request)
    {
        Biblioteca biblioteca = new Biblioteca();
        return biblioteca;

    }
    
}
