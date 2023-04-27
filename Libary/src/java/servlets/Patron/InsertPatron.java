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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author CC
 */
public class InsertPatron extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
       req.getRequestDispatcher("InsertPatron.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.InsertPatron.doPost()");
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        try{
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            String email=req.getParameter("email");
            Patron p= new Patron(0, fname, lname, email, "active");
            PatronDAO pdao = new PatronDAO();
            pdao.insertPatron(p);
            resp.sendRedirect("ListHold");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListHold");
        }
    }
}
