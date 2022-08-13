/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.DAO;

import com.intranet.model.Role;

/**
 *
 * @author saichaithanyasaraf
 */
public interface RoleDAO {
 public int create(Role r);
 public Role read(Role r);
 public int update(Role r);
 public int delete(Role r);
}
