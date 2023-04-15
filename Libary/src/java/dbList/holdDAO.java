/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbObject.hold;
import java.sql.Connection;
import java.sql.Date;
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
public class holdDAO {
    public ArrayList<hold> getAllhold(){
        ArrayList<hold> listhold = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.holdDAO.getAllhold()");
                String sql = "Select * from hold";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    hold cat = new hold();
                    cat.setId(rs.getInt("id"));
                    cat.setS_time(rs.getDate("s_time"));
                    cat.setE_time(rs.getDate("e_time"));
                    cat.setBook_copy_id(rs.getInt("book_copy_id"));
                    cat.setPatron_account_id(rs.getInt("patron_account_id"));
                    listhold.add(cat);
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
        return listhold;
    }
    
    public Map<Integer, hold> getMaphold(){
        Map<Integer, hold> listhold = new HashMap<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.holdDAO.getMaphold()");
                String sql = "Select * from hold";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    hold cat = new hold();
                    cat.setId(rs.getInt("id"));
                    cat.setS_time(rs.getDate("s_time"));
                    cat.setE_time(rs.getDate("e_time"));
                    cat.setBook_copy_id(rs.getInt("book_copy_id"));
                    cat.setPatron_account_id(rs.getInt("patron_account_id"));
                    listhold.put(cat.getId(), cat);
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
        return listhold;
    }
    
    public void inserthold(hold hold){
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.holdDAO.inserthold()");
                String sql = "Insert into hold(s_time,e_time,book_copy_id,patron_account_id) values ("+hold.getS_time()+"," + hold.getS_time()+",'" + hold.getBook_copy_id()+ "'"+ ",'" + hold.getPatron_account_id()+ "')";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);                
                st.close();
                con.close();
            } else {
                System.out.println("dbList.holdDAO.inserthold()");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updatehold(hold hold){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Update hold set s_time = ?,book_copy_id = ?,patron_account_id = ? where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1, (Date) hold.getS_time());
            st.setInt(2, hold.getBook_copy_id());
            st.setInt(3, hold.getPatron_account_id());
            st.setInt(4, hold.getId());
            int row = st.executeUpdate();
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deletehold(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Delete from hold where id = " + ID;
            Statement st = con.createStatement();
            int row = st.executeUpdate(sql);
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public hold gethold(int ID){
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "Select * from hold where id = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                hold cat = new hold();
                    cat.setId(rs.getInt("id"));
                    cat.setS_time(rs.getDate("s_time"));
                    cat.setE_time(rs.getDate("e_time"));
                    cat.setBook_copy_id(rs.getInt("book_copy_id"));
                    cat.setPatron_account_id(rs.getInt("patron_account_id"));
                rs.close();
                st.close();
                con.close();
                System.out.println("dbList.holdDAO.gethold()");
                return cat;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
