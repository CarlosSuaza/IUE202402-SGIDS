package org.iuedesarrollosoftware.orm.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.iuedesarrollosoftware.orm.entidades.AutorEntity;
import org.iuedesarrollosoftware.orm.repositorios.AutorRepositorio;
import org.iuedesarrollosoftware.orm.repositorios.AutorRepositorioImp;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "SrvDetalleAutor", value = "/detalleAutor")
public class SrvDetalleAutor extends HttpServlet {

    AutorRepositorio autorRepositorio = new AutorRepositorioImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("-id");
            AutorEntity autorEntity = autorRepositorio.findOne(UUID.fromString(id));
            HttpSession session = request.getSession();
            session.setAttribute("autor", autorEntity);
            response.sendRedirect("detalle-autor.jsp");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}