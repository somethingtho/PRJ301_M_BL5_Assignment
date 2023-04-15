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
        ArrayList<book> listbook = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.bookDAO.getAllbook()");
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
        Map<Integer, book> listbook = new HashMap<>();
        DBContext db = new DBContext();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                System.out.println("dbList.bookDAO.getMapbook()");
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
        DBContext db = new DBContext();
        try{
            Connection con = db.getConnection();
            String sql = "select top 1 * from book_copy bc left join book b on bc.book_id=b.id where bc.is_returned=0 and b.title = '" + book_name +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                    return rs.getInt("id");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
