/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dbList.SendEmail;
import dbObject.Notification;
import dbList.holdDAO;
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
public class Overdue extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.InsertWait.doGet()");
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        
        try{
            holdDAO h_dao = new holdDAO();
            int id=Integer.parseInt(req.getParameter("id"));
                SendEmail sm = new SendEmail();
                Notification notif = new Notification("Overdue",h_dao.getpatron_id(id));
                sm.send(notif);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListHold");
        }
}
       

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        req.getRequestDispatcher("ListHold").forward(req, resp);
    }
    
}
