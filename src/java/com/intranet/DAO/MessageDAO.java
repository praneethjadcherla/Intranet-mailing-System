/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.DAO;

import com.intranet.model.Message;

/**
 *
 * @author saichaithanyasaraf
 */
public interface MessageDAO {
 public int create(Message msg);   
 public Message read(Message msg);
 public int  update(Message msg);
 public int  delete(Message msg);
}
