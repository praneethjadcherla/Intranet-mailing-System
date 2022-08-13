/*


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.DAO.MailDAO;
import com.intranet.db.DataSource;
import com.intranet.model.Mail;
import com.intranet.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saichaithanyasaraf
 */
public class MailDAOImpl implements MailDAO {

    @Override
    public int create(Mail m) {
        int i=0;
        try {
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("insert into mail2(mid1,to1,from1,subject1,sentTime,recievedTime) values(?,?,?,?,?,?)");
            ds.getPs().setInt(1,m.getId());
            ds.getPs().setString(2,m.getTo());
            ds.getPs().setString(3, m.getFrom());
            ds.getPs().setString(4, m.getSubject());
            ds.getPs().setString(5, m.getSentTime());
            ds.getPs().setString(6,m.getRecievedTime());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
           System.out.println(ex);
        }
    
        return i;
    }
    
    public int read(){
        try{
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("select max(mId1) from mail2");
            ResultSet rs=ds.getPs().executeQuery();
            Mail mail=new Mail();
            if(rs.next()){
                return rs.getInt(1);
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
           System.out.println(ex);
        }
        return 0;
    }
    
    @Override
    public List<Mail> read(User u) {
        List<Mail> mails=new ArrayList<>();
        try
        {
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("select *from Mail where to1=?");
            ds.getPs().setString(1,u.getMailId());
            ResultSet rs=ds.getPs().executeQuery();
            Mail mail=new Mail();
            while(rs.next()){
                mail.setFrom(rs.getString("from1"));
                mail.setSubject(rs.getString("subject1"));
                mails.add(mail);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return mails;
    }
    

    @Override
    public int update(Mail m) {
        int i=0;
        try {
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("update mail2 set to1=?,from1=? where mid1=?");
            ds.getPs().setString(1,m.getTo());
            ds.getPs().setString(2,m.getFrom());
            ds.getPs().setInt(3,m.getId());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
      
        }
                return i;
    }
        

    @Override
    public int delete(Mail m) {
int i=0;
try
{
          DataSource ds=new DataSource();
          ds.setCon();
          ds.setPs("delete from mail2 where to1=? and from1=?");
          ds.getPs().setString(1,m.getTo());
          ds.getPs().setString(2,m.getFrom());
          i=ds.getPs().executeUpdate();
        ds.getCon().commit();
         ds.getCon().close();


}   
 catch(SQLException | ClassNotFoundException ex)
{
System.out.println(ex);
}
    return i;
    
}
    public static void main(String[] args)
    {
    MailDAO md=new MailDAOImpl();
        System.out.println(md.read());
    }

    
}