/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.intranet.controller;

import com.intranet.DAO.UserDAO;
import com.intranet.model.User;
import com.intranet.service.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saichaithanyasaraf
 */
@WebServlet(name = "UserController", urlPatterns = {"/User"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
              String mailId=request.getParameter("mailId");
              String password=request.getParameter("password");
            
              String rePage=request.getHeader("referer");
              HttpSession session=request.getSession();
              
              if(rePage.contains("login")){
                   User u=new User(mailId,password);
                   UserDAO ud= new UserDAOImpl();
                   out.print(u.getMailId());
                   u=ud.read(u);
                   if(u.getId()>0){
                       session.setAttribute("user", u);
                       response.sendRedirect("Welcome.jsp");
                   }
              }
              else{
              String firstName=request.getParameter("firstName");
              String lastName=request.getParameter("lastName");
              String rpassword=request.getParameter("rpassword");
              String phoneNumber=request.getParameter("phoneNumber");
              
              if(password.equals(rpassword)){
                User user=new User(firstName, lastName, mailId, phoneNumber, password);
                user.setId(111);
                UserDAO ud=new UserDAOImpl();
                if(ud.create(user)>0){
                        response.sendRedirect("login.html");
                }
                }
              }
              }
              
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
