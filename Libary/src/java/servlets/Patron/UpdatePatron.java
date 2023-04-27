/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets.Patron;

import dbList.PatronDAO;
import dbObject.Patron;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author CC
 */
public class UpdatePatron extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            PatronDAO dao = new PatronDAO();
            Patron cat = dao.getPatron(id);
            if (cat==null){
                resp.sendRedirect("ListPatron");
            }
            else
            {
                req.setAttribute("Patron", cat);
                req.getRequestDispatcher("UpdatePatron.jsp").forward(req, resp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListPatron");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String status = req.getParameter("status");
            String email = req.getParameter("email");
            
            Patron cat = new Patron(0, fname, lname, email, status);
            PatronDAO dao = new PatronDAO();
            dao.updatePatron(cat);
            resp.sendRedirect("ListPatron");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListPatron");
        }
    }
    
}
