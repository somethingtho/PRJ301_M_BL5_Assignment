/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import dbConnect.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author CC
 */
public class Employee {
    int id;
    String fname;
    String surname;
    String email;
    String password;

    public Employee() {
    }

    public Employee(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public Employee(int id, String fname, String surname, String email, String password) {
        this.id = id;
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isValidate() {
        boolean valid=false;
        try{
        Connection con = (new DBContext()).getConnection();
        if (con != null) {
                System.out.println("Connected");
                String sql = "Select * from employee_account";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Employee log = new Employee();
                    if(email.equals(rs.getString("email"))&&password.equals(rs.getString("password")))
                        valid=true;
                }
                rs.close();
                st.close();
                con.close();
            } else {
                System.out.println("Not connected");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        return valid;

    }
   
}
