/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbObject.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phuonglh
 */
public class EmployeeDAO {
    
    public Employee getEmployeeByEmail(String email) {
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            String sql = "Select * from employee_account where email like '%" + email + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Employee stu = new Employee();
                stu.setId(rs.getInt("id"));
                stu.setFname(rs.getString("fname"));
                stu.setSurname(rs.getString("surname"));
                stu.setEmail(rs.getString("email"));
                stu.setPassword(rs.getString("password"));
                rs.close();
                st.close();
                con.close();
                return stu;
            }
        } catch (Exception e) {
            System.out.println("During search");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
