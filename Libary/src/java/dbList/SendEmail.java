/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbList;
import dbConnect.DBContext;
import dbObject.Notification;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author CC
 */
public class SendEmail {
    public void send(Notification notif){
        insertNotif(notif);
        mail(notif);
    }
    public void insertNotif(Notification notif) {
        DBContext db = new DBContext();
        bookDAO bookdao = new bookDAO();
        System.out.println("dbList.SendEmail.insertNotif()");
        try {
            Connection con = db.getConnection();
            if (con != null) {
                String sql = "Insert into notification(send_at,type,patron_account_id) values (CURRENT_TIMESTAMP,'"+notif.getType()+"'," + notif.getP_id() + ")";
                Statement st = con.createStatement();
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            } else {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void mail(Notification notif) {
        System.out.println("dbList.SendEmail.mail()");
        final String username = "dungthhe170357@fpt.edu.vn";
        final String password = "croky060903";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dungthhe170357@fpt.edu.vn"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(notif.getP_email()));
            message.setSubject(notif.getType());
            message.setText(notif.getMess(notif.getType()));

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
