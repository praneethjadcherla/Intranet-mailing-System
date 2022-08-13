/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.DAO;

import com.intranet.model.Mail;
import com.intranet.model.MailBox;
import com.intranet.model.User;
import java.util.List;

/**
 *
 * @author saichaithanyasaraf
 */
public interface MailBoxDAO {
    public int create(MailBox m);
    public MailBox read(MailBox m);
    public List<Mail> read(User u);
    public int update(MailBox m);
    public int delete(MailBox m);
}
