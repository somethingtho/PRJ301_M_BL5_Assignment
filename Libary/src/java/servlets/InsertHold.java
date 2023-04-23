/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dbList.holdDAO;
import dbList.bookDAO;
import dbObject.hold;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author CC
 */
public class InsertHold extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
       req.getRequestDispatcher("InsertHold.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.InsertHold.doPost()");
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        try{
            String title=req.getParameter("name");
            System.out.println("servlets.InsertHold.doPost()"+title);
            int p_id=Integer.parseInt(req.getParameter("id"));
            bookDAO bookdao = new bookDAO();
            holdDAO dao= new holdDAO();
            if(bookdao.getstatus(title)){
                int b_id=bookdao.getbook_id(title);
                hold cat = new hold(b_id, p_id);
                dao.inserthold(cat);
                resp.sendRedirect("ListHold");
            }
            else{
                session.setAttribute("p_id", p_id);
                session.setAttribute("b_name", title);
                resp.sendRedirect("Waiting");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            resp.sendRedirect("ListHold");
        }
    }
    public Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }
}
