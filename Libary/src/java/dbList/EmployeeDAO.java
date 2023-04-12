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
    
    public Employee verifyEmployee(String email) {
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Select * from Categories where email = " + email;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                Employee cat = new Employee();
                cat.setId(rs.getInt("id"));
                cat.setFname(rs.getString("fname"));
                cat.setSurname(rs.getString("surname"));
                cat.setEmail(rs.getString("email"));
                cat.setPassword(rs.getString("password"));
                rs.close();
                st.close();
                con.close();
                return cat;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
