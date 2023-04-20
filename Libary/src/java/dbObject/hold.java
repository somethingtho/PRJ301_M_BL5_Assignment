/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import java.sql.Date;

/**
 *
 * @author phuonglh
 */
public class hold {
    private int Id;
    private Date s_time;
    private Date e_time;
    private int book_copy_id;
    private int patron_account_id;
    private String book_name;
    private String patron_name;
    private String status;

    public hold() {
    }

    public hold(int Id, Date s_time,Date e_time, int book_copy_id, int patron_account_id) {
        this.Id = Id;
        this.s_time = s_time;
        this.e_time = e_time;
        this.book_copy_id = book_copy_id;
        this.patron_account_id = patron_account_id;
    }

    public hold(int book_copy_id, int patron_account_id) {
        this.book_copy_id = book_copy_id;
        this.patron_account_id = patron_account_id;
    }
    

    public hold(int Id, Date s_time, Date e_time, String book_name, String patron_name) {
        this.Id = Id;
        this.s_time = s_time;
        this.e_time = e_time;
        this.book_name = book_name;
        this.patron_name = patron_name;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getS_time() {
        return s_time;
    }

    public void setS_time(Date s_time) {
        this.s_time = s_time;
    }
    
    public Date getE_time() {
        return e_time;
    }

    public void setE_time(Date e_time) {
        this.e_time = e_time;
    }

    public int getBook_copy_id() {
        return book_copy_id;
    }

    public void setBook_copy_id(int book_copy_id) {
        this.book_copy_id = book_copy_id;
    }

    public int getPatron_account_id() {
        return patron_account_id;
    }

    public void setPatron_account_id(int patron_account_id) {
        this.patron_account_id = patron_account_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPatron_name() {
        return patron_name;
    }

    public void setPatron_name(String patron_name) {
        this.patron_name = patron_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
