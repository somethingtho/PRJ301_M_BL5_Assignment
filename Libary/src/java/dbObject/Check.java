/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

import java.sql.Date;

/**
 *
 * @author CC
 */
public class Check {
    private int Id;
    private Date s_time;
    private int book_copy_id;
    private int patron_account_id;
    private int employee_account_id;

    public Check() {
    }

    public Check(int Id, Date s_time, int book_copy_id, int patron_account_id,int employee_account_id) {
        this.Id = Id;
        this.s_time = s_time;
        this.book_copy_id = book_copy_id;
        this.patron_account_id = patron_account_id;
        this.employee_account_id = employee_account_id;
    }
    public Check(int Id, int book_copy_id, int patron_account_id,int employee_account_id) {
        this.Id = Id;
        this.book_copy_id = book_copy_id;
        this.patron_account_id = patron_account_id;
        this.employee_account_id = employee_account_id;
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

    public int getEmployee_account_id() {
        return employee_account_id;
    }

    public void setEmployee_account_id(int employee_account_id) {
        this.employee_account_id = employee_account_id;
    }
    
}
