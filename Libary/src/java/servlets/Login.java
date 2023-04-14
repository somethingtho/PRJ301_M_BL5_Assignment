/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;
import dbList.EmployeeDAO;
import dbObject.Employee;
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
public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(email +"," + password);
        
        EmployeeDAO userDAO = new EmployeeDAO();
        Employee user = userDAO.getEmployeeByEmail(email);
        if (email==null || password==null || user==null || email=="" || password==""){
            req.setAttribute("loginFailed", true);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("ListHold.jsp");
        }
    }
}
