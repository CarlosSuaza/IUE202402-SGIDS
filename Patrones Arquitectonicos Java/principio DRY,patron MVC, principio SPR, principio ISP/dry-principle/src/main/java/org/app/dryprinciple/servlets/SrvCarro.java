package org.app.dryprinciple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.app.dryprinciple.clases.Carro;
import org.app.dryprinciple.services.CarroService;
import org.app.dryprinciple.services.CarroServiceImp;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SrvCarro", value = "/carro")
public class SrvCarro extends HttpServlet {

    CarroService carroService = new CarroServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            session.setAttribute("carros",carroService.getCarros());
            response.sendRedirect("carro.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       try {
           String marca = request.getParameter("marca");
           String modelo = request.getParameter("modelo");
           Carro carro = new Carro();
           carro.setMarca(marca);
           carro.setModelo(modelo);
           carroService.addCarro(carro);
           response.sendRedirect("carro.jsp");
       }catch(SQLException | ClassNotFoundException e){
           throw new RuntimeException(e);
       }


    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            int id = Integer.parseInt(request.getParameter("id"));
            Carro carro = new Carro();
            carro.setMarca(marca);
            carro.setModelo(modelo);
            carroService.updateCarro(carro,id);
            response.sendRedirect("carro.jsp");
        }catch(SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            carroService.removeCarro(id);
            response.sendRedirect("carro.jsp");
        }catch(SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}