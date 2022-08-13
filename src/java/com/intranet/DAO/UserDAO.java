/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.DAO;
import com.intranet.model.User;
/**
 *
 * @author saichaithanyasaraf
 */
public interface UserDAO {
    public int create(User u);
    public User read(User u);
    public int update(User u);
    public int delete(User u);
}
