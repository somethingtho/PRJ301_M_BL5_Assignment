/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbObject.book;
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
public class bookDAO {
    public ArrayList<book> getAllbook(){
        System.out.println("dbList.bookDAO.getAllbook()");
        ArrayList<book> listbook = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Select * from book_copy";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    book cat = new book();
                    cat.setId(rs.getInt("id"));
                    cat.setBook_id(rs.getInt("book_id"));
                    cat.setPublisher_id(rs.getInt("publisher_id"));
                    cat.setYear_published(rs.getInt("year_published"));
                    listbook.add(cat);
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
        return listbook;
    }
    
    public Map<Integer, book> getMapbook(){
        System.out.println("dbList.bookDAO.getMapbook()");
        Map<Integer, book> listbook = new HashMap<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Select * from book";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    book cat = new book();
                    cat.setId(rs.getInt("id"));
                    cat.setBook_id(rs.getInt("book_id"));
                    cat.setPublisher_id(rs.getInt("publisher_id"));
                    cat.setYear_published(rs.getInt("year_published"));
                    listbook.put(cat.getId(), cat);
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
        return listbook;
    }
    
        
    public int getbook_id(String book_name){
        System.out.println("dbList.bookDAO.getbook_id()");
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select top 1 * from book_copy bc left join book b on bc.book_id=b.id where is_returned=0 and b.title = '" + book_name +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                System.out.println(rs.getInt("id"));
                    return rs.getInt("id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public void updatebook(int id,int status){
        System.out.println("dbList.bookDAO.updatebook()");
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql="Update book_copy set is_returned=? where id="+id;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, status);
            int row = st.executeUpdate();
            st.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getbook_name(int book_id){
        System.out.println("dbList.bookDAO.getbook_name()");
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select top 1 * from book_copy bc left join book b on bc.book_id=b.id where b.id = '" + book_id +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                System.out.println(rs.getString("title"));
                    return rs.getString("title");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean getstatus(String book_name){
        System.out.println("dbList.bookDAO.getstatus()");
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select * from book_copy bc left join book b on bc.book_id=b.id where b.title = '" + book_name +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                if(rs.){
                    return true;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
