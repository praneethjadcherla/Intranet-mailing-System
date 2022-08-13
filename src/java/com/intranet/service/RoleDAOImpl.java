/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.DAO.RoleDAO;
import com.intranet.db.DataSource;
import com.intranet.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saichaithanyasaraf
 */
public class RoleDAOImpl implements RoleDAO {
DataSource ds=new DataSource();
public int create(Role r)
{
    int i=0;
    try {
        ds.setCon();
        ds.setPs("insert into role2(id,roleName,userId) values(?,?,?)");
        ds.getPs().setInt(1,r.getId());
        ds.getPs().setString(2,r.getRoleName());
        ds.getPs().setInt(3,r.getUserId());
        i=ds.getPs().executeUpdate();
        
        ds.getCon().commit();
        ds.getCon().close();
    } catch (SQLException | ClassNotFoundException ex) 
    {
         System.out.println(ex);
    }
    return i;
}
  public Role read(Role r)
  {
    
   
    
    try {
        ds.setCon();
        ds.setPs("select * from role2 where UserId=? ");
        ds.getPs().setInt(1, r.getUserId());
        ResultSet rs=ds.getPs().executeQuery();
        while(rs.next()){
            if(rs.getString("roleName").equals(r.getRoleName()))
                r.setId(rs.getInt("Id"));
                
            }
        }
    
catch(SQLException | ClassNotFoundException ex)        
        {
            System.out.println(ex);
        }
return r;
  }
        @Override
        public int update(Role r) {
        int i=0;
    
        try {
            ds.setCon();
            ds.setPs("update role2 set  id=?, roleName=? where userId=?");
            ds.getPs().setInt(1,r.getId());
            ds.getPs().setString(2,r.getRoleName());
            ds.getPs().setInt(3,r.getUserId());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch(SQLException | ClassNotFoundException ex) {
            System.out.println(ex);    
        }
        return i;
    }
        
        
        
        @Override
        public int delete(Role r) {
        int i=0;
        try {
            ds.setCon();
            ds.setPs("delete from role2 where userId=?");
            ds.getPs().setInt(1,r.getUserId());
            i=ds.getPs().executeUpdate();
            ds.getCon().commit();;
            ds.getCon().close();
        }
        catch(SQLException |ClassNotFoundException ex) {
            System.out.println(ex);            
        }
        
        return i;
    }
        
        
    public static void main(String[] args)
        {
            RoleDAO rd=new RoleDAOImpl();
            Role r  = new Role("praneeth",16);
            rd.create(r);
            
         r=rd.read(r);
          System.out.println(r.getId());
           
            System.out.println(rd.update(r));
            System.out.println(rd.delete(r));
        }
    } 


 
