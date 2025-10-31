package br.cefetrj.servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/postman")
public class PostmanServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        response.getWriter().write("(\"message\": \"Entrou no GET\")");
        System.out.println("Entrou no GET");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        response.getWriter().write("(\"message\": \"Entrou no POST\")");
        System.out.println("Entrou no POST");

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        response.getWriter().write("(\"message\": \"Entrou no PUT\")");
        System.out.println("Entrou no PUT");

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        response.getWriter().write("(\"message\": \"Entrou no DELETE\")");
        System.out.println("Entrou no DELETE");

    }

}
