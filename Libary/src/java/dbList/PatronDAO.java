/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import db.DBContext;
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
                System.out.println("Connected");
                String sql = "Select * from Categories";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    Patron cat = new Patron();
                    cat.setId(rs.getInt("ID"));
                    cat.setName(rs.getString("Name"));
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
                System.out.println("Connected");
                String sql = "Select * from Categories";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    Patron cat = new Patron();
                    cat.setId(rs.getInt("ID"));
                    cat.setName(rs.getString("Name"));
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
    
    public void insertPatron(Patron Patron){
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("Connected");
                String sql = "Insert into Categories(ID, Name) values (" + Patron.getId()
                        + ",'" + Patron.getName() + "')";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);                
                st.close();
                con.close();
            } else {
                System.out.println("Not connected");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePatron(Patron Patron){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Update Categories set Name = ? where ID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, Patron.getName());
            st.setInt(2, Patron.getId());
            int row = st.executeUpdate();
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deletePatron(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Delete from Categories where ID = " + ID;
            Statement st = con.createStatement();
            int row = st.executeUpdate(sql);
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Patron getPatron(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Select * from Categories where ID = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                Patron cat = new Patron();
                cat.setId(rs.getInt("ID"));
                cat.setName(rs.getString("Name"));
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
