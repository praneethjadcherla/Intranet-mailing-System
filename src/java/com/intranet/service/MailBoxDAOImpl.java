/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.DAO.MailBoxDAO;
import com.intranet.DAO.MailDAO;
import com.intranet.db.DataSource;
import com.intranet.model.Mail;
import com.intranet.model.MailBox;
import com.intranet.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saichaithanyasaraf
 */
public class MailBoxDAOImpl  implements MailBoxDAO
{

    @Override
    public int create(MailBox m) {
       int i=0;
        try {
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("insert into mailbox1(id,name) values(?,?)");
            ds.getPs().setInt(1,m.getId());
            ds.getPs().setString(2,m.getName());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
           System.out.println(ex);
        }
     return i;
    }

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
    public int update(MailBox m) {
    int i=0;
        try {
            DataSource ds=new DataSource();
            ds.setCon();
            ds.setPs("update mailbox1 set name=? where id=?");
            ds.getPs().setString(1,m.getName());
            ds.getPs().setInt(2,m.getId());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
      
        }
                return i;

    }

    @Override
    public int delete(MailBox m) {
       int i=0;
try
{
          DataSource ds=new DataSource();
          ds.setCon();
          ds.setPs("delete from mail2 where id=?");
          ds.getPs().setInt(1,m.getId());
  
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
    MailBoxDAO md=new MailBoxDAOImpl();    
    
 MailBox m=new MailBox(123,"abc");
md.create(m);

m=md.read(m);

System.out.println(md.update(m));
System.out.println(md.delete(m));

    }

    @Override
    public MailBox read(MailBox m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
