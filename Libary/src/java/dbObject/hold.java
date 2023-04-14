/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author phuonglh
 */
public class hold {
    private int Id;
    private String s_time;
    private int book_copy_id;
    private int patron_account_id;

    public hold() {
    }

    public hold(int Id, String s_time, int book_copy_id, int patron_account_id) {
        this.Id = Id;
        this.s_time = s_time;
        this.book_copy_id = book_copy_id;
        this.patron_account_id = patron_account_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
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

    @Override
    public String toString() {
        return "hold{" + "Id=" + Id + ", s_time=" + s_time + ", book_copy_id=" + book_copy_id + ", patron_account_id=" + patron_account_id + '}';
    }
    
}
