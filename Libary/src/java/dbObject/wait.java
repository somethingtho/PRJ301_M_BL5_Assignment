/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import dbList.PatronDAO;
import dbList.bookDAO;

/**
 *
 * @author CC
 */
public class wait {
    int b_id,p_id,id;
    String b_name,p_name,piclink;
    bookDAO b_dao = new bookDAO();
    PatronDAO p_dao =new PatronDAO();
    public wait() {
    }

    public wait(String b_name, int p_id) {
        this.b_name = b_name;
        this.p_id = p_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_name() {
        return b_name;
    }

    public String getP_name() {
        p_name=p_dao.getPatron_name(p_id);
        return p_name;
    }
    public String getPiclink() {
        bookDAO b_dao = new bookDAO();
        piclink=b_dao.getpiclink(b_name);
        return piclink;
    }
}
