/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.model;

/**
 *
 * @author saichaithanyasaraf
 */
public class Mail {
    private int Id;
    private String to;
    private String from;
    private String subject;
    private Message message;
    private String sentTime;
    private String recievedTime;

    public Mail() {
    }

    public Mail( String to, String from, String subject, String sentTime, String recievedTime) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.sentTime = sentTime;
        this.recievedTime = recievedTime;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSentTime() {
        return sentTime;
    }

    public void setSentTime(String sentTime) {
        this.sentTime = sentTime;
    }

    public String getRecievedTime() {
        return recievedTime;
    }

    public void setRecievedTime(String recievedTime) {
        this.recievedTime = recievedTime;
    }

    

   
}