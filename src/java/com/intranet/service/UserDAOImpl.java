/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.DAO.UserDAO;
import com.intranet.db.DataSource;
import com.intranet.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saichaithanyasaraf
 */
public class UserDAOImpl implements UserDAO{

    DataSource ds=new DataSource();
    
    @Override
    public int create(User u) {
        int i=0;String str="";
        try {
            ds.setCon();
            ds.setPs("insert into User1(firstName,id,lastName,mailId,phoneNumber,password) values(?,?,?,?,?,?)");
            ds.getPs().setString(1, u.getFirstName());
            ds.getPs().setInt(2,u.getId());
            ds.getPs().setString(3,u.getLastName());
            ds.getPs().setString(4,u.getMailId());
            ds.getPs().setString(5,u.getPhoneNumber());
            ds.getPs().setString(6,u.getPassword());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
            str=ex.toString();
            System.out.println(ex);
        }
        return i;
    }

    @Override
    public User read(User u) {
        try {
            ds.setCon();
            ds.setPs("select * from User1 where mailId=?");
            ds.getPs().setString(1, u.getMailId());
            ResultSet rs=ds.getPs().executeQuery();
            while(rs.next()){
                if(rs.getString("password").equals(u.getPassword())){
                    u.setFirstName(rs.getString("firstName"));
                    u.setId(rs.getInt("Id"));
                    u.setPhoneNumber(rs.getString("phoneNumber"));
                    u.setLastName(rs.getString("lastName"));
                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return u;
    }

    @Override
    public int update(User u) {
        int i=0;
    
        try {
            ds.setCon();
            ds.setPs("update User1 set password=?,phonenumber=? where id=?");
            ds.getPs().setInt(1,u.getId());
            ds.getPs().setString(2,u.getPassword());
            ds.getPs().setString(3,u.getPhoneNumber());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);    
        }
        return i;
    }

    @Override
    public int delete(User u) {
        int i=0;
            try {
                ds.setCon();
                ds.setPs("delete from user1 where id=?");
                ds.getPs().setInt(1,u.getId());
                i=ds.getPs().executeUpdate();
                ds.getCon().commit();;
                ds.getCon().close();
            } catch (SQLException |ClassNotFoundException ex) {
          System.out.println(ex);

            }
    
           return i;
    }
    
    public static void main(String[] args) {
       UserDAO ud=new UserDAOImpl();
       
       User  u = new User("sai"," ertewerfret", "abc@mail","7093857600", "aaaa");
       u.setId(123);
       ud.create(u);
       
     
    }
}