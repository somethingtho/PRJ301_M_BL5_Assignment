/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import dbList.bookDAO;
import dbList.holdDAO;
import dbList.waitDAO;
import dbObject.hold;
import dbObject.wait;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author CC
 */
public class ListHold extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.ListHold.doGet()");
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        holdDAO dao = new holdDAO();
        waitDAO w_dao = new waitDAO();
        bookDAO b_dao =new bookDAO();
        ArrayList<wait> list2 = w_dao.getAllWait();
        
        for (wait cat : list2){
            if(b_dao.getstatus(cat.getB_name())){
            hold hold = new hold(cat.getB_id(), cat.getP_id());
            dao.inserthold(hold);
            w_dao.deletewait(cat.getId());
            }
        }
        
        ArrayList<hold> list1 = dao.getAllhold();
        req.setAttribute("listhold", list1);
        req.getRequestDispatcher("ListHold.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        this.doGet(req, resp);
    }
    
}
