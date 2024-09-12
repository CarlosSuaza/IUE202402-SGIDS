package org.iuedesarrollosoftware.orm.servlets;

import jakarta.persistence.NoResultException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.iuedesarrollosoftware.orm.entidades.AutorEntity;
import org.iuedesarrollosoftware.orm.repositorios.AutorRepositorio;
import org.iuedesarrollosoftware.orm.repositorios.AutorRepositorioImp;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "SrvAutor", value = "/autor")
public class SrvAutor extends HttpServlet {

    AutorRepositorio autorRepositorio = new AutorRepositorioImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoResultException {
        try{
            HttpSession session = request.getSession();
            session.setAttribute("autores", autorRepositorio.findAll());
            response.sendRedirect("autor.jsp");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String biografia = request.getParameter("biografia");
            LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
            LocalDate fechaMuerte = LocalDate.parse(request.getParameter("fechaMuerte"));
            AutorEntity autor = new AutorEntity();
            autor.setNombres(nombres);
            autor.setApellidos(apellidos);
            autor.setFechanacimiento(fechaNacimiento);
            autor.setFechamuerte(fechaMuerte);
            autor.setBiografia(biografia);
            autor.setFechaactualizacion(LocalDate.now());
            autor.setActivo(true);
            autorRepositorio.save(autor);
            response.sendRedirect("autor");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           String id = request.getParameter("id");
           String nombres = request.getParameter("nombres");
           String apellidos = request.getParameter("apellidos");
           String biografia = request.getParameter("biografia");
           LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
           LocalDate fechaMuerte = LocalDate.parse(request.getParameter("fechaMuerte"));
           AutorEntity autor = new AutorEntity();
           autor.setNombres(nombres);
           autor.setApellidos(apellidos);
           autor.setFechanacimiento(fechaNacimiento);
           autor.setFechamuerte(fechaMuerte);
           autor.setBiografia(biografia);
           autor.setId(UUID.fromString(id));
           autor.setFechaactualizacion(LocalDate.now());
           autor.setActivo(true);
           autorRepositorio.save(autor);
           response.sendRedirect("autor");
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("_id");
            autorRepositorio.delete(UUID.fromString(id));
            response.sendRedirect("autor");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}