/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dbList.holdDAO;
import dbObject.hold;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author CC
 */
public class InsertHold extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("InsertCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id =Integer.parseInt(req.getParameter("id"));
            String name=req.getParameter("name");
            holdDAO dao = new holdDAO();
            if (dao.gethold(id) != null){
                String error = "ID already existed.";
                req.setAttribute("error", error);
                req.getRequestDispatcher("InsertCategory.jsp").forward(req, resp);
            }
            else {
                hold cat = new hold(id, name, id, id);
                dao.inserthold(cat);
                resp.sendRedirect("ListCategories");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListCategories");
        }
    }
}
