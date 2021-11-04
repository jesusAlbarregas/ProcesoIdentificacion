/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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

        String url = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy HH:mm:ss");

        if (request.getParameter("usuario") != null && request.getParameter("clave") != null) {

            if (request.getParameter("usuario").equals("jesus") && request.getParameter("clave").equals("1234")) {
                HttpSession sesionOK = request.getSession();
                sesionOK.setAttribute("usuario", request.getParameter("usuario"));

                if (request.getParameter("recordar") != null) {
                    Cookie cookieUser = new Cookie("usuario", request.getParameter("usuario"));
                    cookieUser.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookieUser);
                }
                HttpSession sesionOk = request.getSession();
                String usuario = "";
                Cookie cookie = null;
                Cookie cookieFecha = null;

                String fechaUltimoAcceso = null;

                if (sesionOk.getAttribute("usuario") == null) {
                    request.setAttribute("error", "Es necesario identificarse");
                    url = "index.jsp";

                } else {
                    usuario = (String) sesionOk.getAttribute("usuario");
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {

                        for (int i = 0; i < cookies.length; i++) {
                            if (cookies[i].getName().equals("ultimoAcceso")) {
                                cookieFecha = cookies[i];
                                break;
                            }
                        }
                    }

                    if (cookieFecha != null) {
                        fechaUltimoAcceso = URLDecoder.decode(cookieFecha.getValue(), "UTF-8");

                    } else {
                        fechaUltimoAcceso = "Es la primera vez que accedes a la aplicación";
                    }
                    Date fechaActual = new Date();

                    String UltimoAcceso = dateFormat.format(fechaActual);

                    Cookie cookieF = new Cookie("ultimoAcceso", URLEncoder.encode(UltimoAcceso, "UTF-8"));
                    cookieF.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookieF);
                    request.setAttribute("acceso", fechaUltimoAcceso);
                    url = "JSP/menu.jsp";
                }

            } else {
                request.setAttribute("error", "Usuario no identificado");
                url = "index.jsp";
            }
        } else {
            request.setAttribute("error", "Es necesario identificarse");
            url = "index.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
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
