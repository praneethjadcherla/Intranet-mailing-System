/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saichaithanyasaraf
 */
public class DataSource {
    private Connection con;
    private PreparedStatement ps;
    
    String url="jdbc:oracle:thin:@localhost:1521:xe",user="mail",password="mail";

    public Connection getCon() {
        return con;
    }

    public void setCon() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con = DriverManager.getConnection(url, user, password);
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(String sql) throws SQLException {
        this.ps = con.prepareCall(sql);
    }
    
    public static void main(String[] arg) throws ClassNotFoundException{
        DataSource ds=new DataSource();
        try {
            ds.setCon();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
