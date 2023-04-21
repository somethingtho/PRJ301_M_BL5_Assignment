/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;

import dbConnect.DBContext;
import dbObject.wait;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CC
 */
public class waitDAO {
    public ArrayList<wait> getAllWait(){
        ArrayList<wait> listwait = new ArrayList<>();
        DBContext db = new DBContext();
        System.out.println("dbList.waitDAO.getAllwait()");
        bookDAO bookdao = new bookDAO();
        PatronDAO patronDAO = new PatronDAO();
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM waitlist";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()){
                    wait cat = new wait();
                    cat.setB_id(rs.getInt("book_copy_id"));
                    cat.setP_id(rs.getInt("patron_id"));
                    listwait.add(cat);
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
        return listwait;
    }
}
