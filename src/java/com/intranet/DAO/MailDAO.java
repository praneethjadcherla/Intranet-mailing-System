/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.DAO;

import com.intranet.model.*;
import java.util.List;

/**
 *
 * @author saichaithanyasaraf
 */
public interface MailDAO {
    public int create(Mail m);
    public int read();
    public List<Mail> read(User u);
    public int update(Mail m);
    public int delete(Mail m);
    
    
}
