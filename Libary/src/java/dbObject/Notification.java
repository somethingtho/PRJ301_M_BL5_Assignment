/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import dbList.PatronDAO;
import java.sql.Date;

/**
 *
 * @author CC
 */
public class Notification {
    Date send_at;
    String type;
    int p_id,id;
    String mess,p_email;

    public Notification() {
    }

    public Notification(String type, int p_id) {
        this.type = type;
        this.p_id = p_id;
    }

    public Date getSend_at() {
        return send_at;
    }

    public void setSend_at(Date send_at) {
        this.send_at = send_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMess(String type) {
        switch(type){
            case "On hold":
                mess="Your requested book in the waiting list have been move to hold. Please visit the libary within 7 days to borrow it.";
                break;
            case "Overdue":
                mess="You have gone over the borrow book's 30 days limit. Please visit the libary within 7 days to return the book and pay the fine. If you do not show up after the 7 days period, the libary will disable your account.";
                break;
            case "Reminder":
                mess="You only have 7 days left in your 30 days borrow limit. Please visit the libary within the next 7 days to return the book. If you do not show up after the 7 days period, you will have to pay a fine.";
        }
        return mess;
    }


    public String getP_email() {
        PatronDAO p_dao = new PatronDAO();
        p_email=p_dao.getPatron_email(p_id);
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }
    
}
