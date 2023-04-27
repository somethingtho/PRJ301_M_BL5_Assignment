/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets.Hold;

import dbList.EmployeeDAO;
import dbList.bookDAO;
import dbList.holdDAO;
import dbObject.Check;
import dbObject.Employee;
import dbObject.hold;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author CC
 */
public class CheckOut extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.CheckOut.doGet()");
        HttpSession session = req.getSession();
        if (session.getAttribute("email") == null){
            resp.sendRedirect("login");
            return;
        }
        
        try{
            int id=Integer.parseInt(req.getParameter("id"));
            String email = String.valueOf(session.getAttribute("email"));
            EmployeeDAO employeeDAO = new EmployeeDAO();
            int e_id=employeeDAO.getEmployee_id(email);
            holdDAO dao = new holdDAO();
            int b_id=dao.getbook_id(id);
            int p_id=dao.getpatron_id(id);
                Check cat = new Check(id, b_id, p_id,e_id);
                dao.insertCheck(cat);
                dao.deletehold(id);
                resp.sendRedirect("ListHold");
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
