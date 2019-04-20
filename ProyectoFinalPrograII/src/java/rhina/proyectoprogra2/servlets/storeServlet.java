/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rhina.proyectoprogra2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rhina.proyectoprogra2.logic.storeLogic;
import rhina.proyectoprogra2.objects.storeObj;

@WebServlet(name = "storeServlet", urlPatterns = {"/storeServlet"})
public class storeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //paso uno de nuevo servlet: formid
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strName = request.getParameter("name");
                
                //access logic
                storeLogic CLogic = new storeLogic();
                int iRows = CLogic.insertStoreRows(strName);
                System.out.println("insert store rows: " + iRows);
                                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                
            }
            
             if(strFormId.equals("2"))
            {
                //work
                //access logic
                storeLogic CLogic = new storeLogic();
                ArrayList<storeObj> CArray = CLogic.getAllStores();
                
                //send to frontend
                request.getSession().setAttribute("stores", CArray);
                response.sendRedirect("storeForm.jsp");
                
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                storeLogic CLogic = new storeLogic();
                int iRows = CLogic.deleteStoreRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");                
            }
            
           if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                storeLogic CLogic = new storeLogic();
                storeObj CStore = CLogic.getStoreById(iId);
                
                //send to frontend
                request.getSession().setAttribute("store", CStore);
                response.sendRedirect("storeUpdateForm.jsp"); 
                
            }
           
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                int iId = Integer.parseInt(strId);
                
                //access logic
                storeLogic CLogic = new storeLogic();
                int iRows = CLogic.updateStoreRows(iId,strName);
                System.out.println("update store rows: " + iRows); 
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                 
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
