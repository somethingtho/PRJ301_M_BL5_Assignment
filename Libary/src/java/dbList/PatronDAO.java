/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbConnect.DBContext;
import dbObject.Patron;
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
public class PatronDAO {
    public ArrayList<Patron> getAllCategories(){
        ArrayList<Patron> listCategories = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.PatronDAO.getAllCategories()");
                String sql = "Select * from Categories";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    Patron cat = new Patron();
                    cat.setId(rs.getInt("id"));
                    cat.setFname(rs.getString("fname"));
                    cat.setSurname(rs.getString("surname"));
                    cat.setEmail(rs.getString("email"));
                    cat.setStatus(rs.getString("status"));
                    listCategories.add(cat);
                }
                rs.close();
                st.close();
                con.close();
            } else {
                System.out.println("Not connected");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listCategories;
    }
    
    public Map<Integer, Patron> getMapCategories(){
        Map<Integer, Patron> listCategories = new HashMap<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.PatronDAO.getMapCategories()");
                String sql = "Select * from Categories";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    Patron cat = new Patron();
                    cat.setId(rs.getInt("id"));
                    cat.setFname(rs.getString("fname"));
                    cat.setSurname(rs.getString("surname"));
                    cat.setEmail(rs.getString("email"));
                    cat.setStatus(rs.getString("status"));
                    listCategories.put(cat.getId(), cat);
                }
                rs.close();
                st.close();
                con.close();
            } else {
                System.out.println("Not connected");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listCategories;
    }
    
    public Patron getPatron(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Select * from Categories where id = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                Patron cat = new Patron();
                    cat.setId(rs.getInt("id"));
                    cat.setFname(rs.getString("fname"));
                    cat.setSurname(rs.getString("surname"));
                    cat.setEmail(rs.getString("email"));
                    cat.setStatus(rs.getString("status"));
                rs.close();
                st.close();
                con.close();
                System.out.println("dbList.PatronDAO.getPatron()");
                return cat;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}