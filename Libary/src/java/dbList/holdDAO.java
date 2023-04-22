/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbObject.Check;
import dbObject.wait;
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
        System.out.println("dbList.holdDAO.getAllhold()");
        bookDAO bookdao = new bookDAO();
        PatronDAO patronDAO = new PatronDAO();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT CAST(\n" +
"             CASE\n" +
"                  WHEN hold.e_time > CURRENT_TIMESTAMP\n" +
"                     THEN 'Good'\n" +
"                  ELSE 'Overdue'\n" +
"             END AS varchar(10)) as Status, *\n" +
"FROM hold";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    hold cat = new hold();
                    cat.setId(rs.getInt("id"));
                    cat.setS_time(rs.getDate("s_time"));
                    cat.setE_time(rs.getDate("e_time"));
                    cat.setBook_name(bookdao.getbook_name(rs.getInt("book_copy_id")));
                    cat.setPatron_name(patronDAO.getPatron_name(rs.getInt("patron_account_id")));
                    cat.setStatus(rs.getString("Status"));
                    listhold.add(cat);
                }
                rs.close();
                st.close();
                con.close();
            } else {
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
        System.out.println("dbList.holdDAO.getMaphold()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
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
        bookDAO bookdao = new bookDAO();
        System.out.println("dbList.holdDAO.inserthold()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Insert into hold(s_time,e_time,book_copy_id,patron_account_id) values (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP+30,'" + hold.getBook_copy_id()+ "'"+ ",'" + hold.getPatron_account_id()+ "')";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);                
                st.close();
                con.close();
                bookdao.updatebook(hold.getBook_copy_id(), 1);
            } else {
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void insertCheck(Check check){
        DBContext db = new DBContext();
        System.out.println("dbList.holdDAO.insertCheck()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Insert into checkout(id,s_time,book_copy_id,patron_account_id,employee_account_id) values ("+ check.getId()+"," +"CURRENT_TIMESTAMP," +check.getBook_copy_id()+ "," + check.getPatron_account_id()+"," + check.getEmployee_account_id()+ ")";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);
                bookDAO dao = new bookDAO();
                dao.updatebook(check.getBook_copy_id(), 0);
                st.close();
                con.close();
            } else {
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void insertWait(wait wait){
        DBContext db = new DBContext();
        System.out.println("dbList.holdDAO.insertWait()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Insert into waitlist(book_name,patron_id) values (" + wait.getB_name()+ "," + wait.getP_id()+")";
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
    
    public void deletehold(int ID){
        DBContext db = new DBContext();
        System.out.println("dbList.holdDAO.deletehold()");
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
        System.out.println("dbList.holdDAO.gethold()");
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
                return cat;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public int getbook_id(int id){
        DBContext db = new DBContext();
        System.out.println("dbList.holdDAO.getbook_id()");
        try{
            Connection con = db.getConnection();
            String sql = "select * from hold where id = '" + id +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                    return rs.getInt("book_copy_id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public int getpatron_id(int id){
        DBContext db = new DBContext();
        System.out.println("dbList.holdDAO.getpatron_id()");
        try{
            Connection con = db.getConnection();
            String sql = "select * from hold where id = '" + id +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                    return rs.getInt("patron_account_id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}
