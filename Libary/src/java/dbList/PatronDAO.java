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
    public ArrayList<Patron> getAllPatron(){
        ArrayList<Patron> listPatron = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Select * from patron_account";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    Patron cat = new Patron();
                    cat.setId(rs.getInt("id"));
                    cat.setFname(rs.getString("fname"));
                    cat.setSurname(rs.getString("surname"));
                    cat.setEmail(rs.getString("email"));
                    cat.setStatus(rs.getString("status"));
                    listPatron.add(cat);
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
        return listPatron;
    }
    
    
    public Patron getPatron(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Select * from patron_account where id = " + ID;
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
    public String getPatron_name(int patron_id){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select * from patron_account where id = '" + patron_id +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                String s = rs.getString("fname")+" "+rs.getString("surname");
                    return s;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String getPatron_email(int patron_id){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select * from patron_account where id = '" + patron_id +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                return rs.getString("email");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void insertPatron(Patron Patron){
        DBContext db = new DBContext();
        System.out.println("dbList.PatronDAO.insertPatron()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Insert into patron_account(fname,surname,email,status) values (" +"'"+ Patron.getFname()+ "',"+"'"+ Patron.getSurname()+ "',"+"'"+ Patron.getEmail()+ "','" + Patron.getStatus()+"'"+")";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);                
                st.close();
                con.close();
            } else {
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void updatePatron(Patron patron){
        System.out.println("dbList.PatronDAO.updatePatron()");
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql="Update patron_account set fname=?, surname=?, email=?,status=? where id=4";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, patron.getFname());
            st.setString(2, patron.getSurname());
            st.setString(3, patron.getEmail());
            st.setString(4, patron.getStatus());
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
            String sql = "Delete from patron_account where id = " + ID;
            Statement st = con.createStatement();
            int row = st.executeUpdate(sql);
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
