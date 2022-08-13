/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.DAO.MailDAO;
import com.intranet.DAO.MessageDAO;
import com.intranet.db.DataSource;
import com.intranet.model.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saichaithanyasaraf
 */
public class MessageDAOImpl implements MessageDAO{

    @Override
    public int create(Message msg) {
        int i=0;
        try {
           
            DataSource ds=new   DataSource();
            ds.setCon();
            ds.setPs("insert into message1(id,message) values(?,?)");
            ds.getPs().setInt(1,msg.getId());
            ds.getPs().setString(2,msg.getMessage());
            i =ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
       System.out.println(ex);
        }
    return i;
    }

    @Override
    public Message read(Message msg) {
        try {
            DataSource ds=new   DataSource();
            ds.setCon();
            ds.setPs("select *from message1 where message=?");
            ds.getPs().setString(1,msg.getMessage());
        } catch (SQLException | ClassNotFoundException ex) {
         System.out.println(ex);
        }
        return msg;  
    }

    @Override
    public int update(Message msg) {
        int i=0;
        try {
            DataSource ds=new   DataSource();
            ds.setCon();
            ds.setPs("update message1 set message=? where id=?");
            ds.getPs().setString(1,msg.getMessage());
            ds.getPs().setInt(2,msg.getId());
              i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return i;
    }

    @Override
    public int delete(Message msg) {
        int i=0;
        try {
            DataSource ds=new   DataSource();
            ds.setCon();
            ds.setPs("delete  from message1 where  message=?");
            ds.getPs().setString(1, msg.getMessage());
             i=ds.getPs().executeUpdate();
        ds.getCon().commit();
         ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
          System.out.println(ex);
        }
            
            return i;
    }
public static void main( String[] args)
{
MessageDAO md=new MessageDAOImpl();
Message m= new Message("message",123);
    System.out.println(md.create(m));


}
}