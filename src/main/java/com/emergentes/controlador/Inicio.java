package com.emergentes.controlador;

import com.emergentes.Dao.ProductosDAO;
import com.emergentes.Dao.ProductosDaoImplements;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();       
        try{
        String action;
        action= (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        //System.out.println("Opcion enviada: "+action);        
        int id;
        Productos pro = new Productos();
        ProductosDAO dao = new ProductosDaoImplements();
      
        switch (action) {
            case "add":                
                request.setAttribute("producto", pro);
                request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                pro = dao.getById(id);
                request.setAttribute("producto", pro);
                request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                response.sendRedirect("Inicio");
                break;
            case "view":                
                List<Productos> producto= dao.getAll();
                request.setAttribute("producto", producto);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                break;
        }}
        catch(Exception ex){
            System.out.println("Error"+ ex.getMessage());         
                }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductosDAO dao = new ProductosDaoImplements();
        int id = Integer.parseInt(request.getParameter("id"));
        String des = request.getParameter("descripcion");
        int  cant = Integer.parseInt(request.getParameter("cantidad"));
        float prec = Float.parseFloat(request.getParameter("precio"));
        String cat = request.getParameter("categoria");

        Productos avi = new Productos(des,cant,prec,cat);
       

        try {
            if (id == 0) {
                dao.insert(avi);

            } else {
                  Productos abi = new Productos(id,des,cant,prec,cat);
                dao.update(abi);
            }

        } catch (Exception ex) {
            System.out.println("Error");

        }
        response.sendRedirect("Inicio");
    }

}
