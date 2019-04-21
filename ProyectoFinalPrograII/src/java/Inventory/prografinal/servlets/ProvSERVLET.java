
package Inventory.prografinal.servlets;

import Inventory.prografinal.logic.ProvLOGIC;
import Inventory.prografinal.objects.ProvObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProvSERVLET", urlPatterns = {"/ProvSERVLET"})
public class ProvSERVLET extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* your code */
            String strFormid = request.getParameter("formid");
            
            if (strFormid.equals("1"))
                {
                    //get parameter
                    String strName = request.getParameter("name");
                     
                     
                    //access logic
                    ProvLOGIC CLogic = new ProvLOGIC();
                    int iRows = CLogic.insertProv(strName);
                    System.out.println("insert client rows: "+iRows);
                    
                    //send to fronted
                    request.getSession().setAttribute("rows", new Integer(iRows));
                    response.sendRedirect("genericMessage.jsp");
                    
                }
             
            
            if (strFormid.equals("2"))
                {
                 //access logic
                ProvLOGIC CLogic = new ProvLOGIC();
                ArrayList<ProvObj> CArray = CLogic.getAllProv();
                
               
                
                //send to frontend
                request.getSession().setAttribute("provs", CArray);
                response.sendRedirect("Proveedores.jsp");
                }
            
            if(strFormid.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProvLOGIC CLogic = new ProvLOGIC();
                int iRows = CLogic.deleteProvRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
             if(strFormid.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProvLOGIC CLogic = new ProvLOGIC();
                ProvObj CClient = CLogic.getProvById(iId);
                
                //send to frontend
                request.getSession().setAttribute("provs", CClient);
                response.sendRedirect("ProvUpdateForm.jsp");
            }   
            
            if(strFormid.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
               
                int iId = Integer.parseInt(strId);
                
                
                //access logic
                ProvLOGIC CLogic = new ProvLOGIC();
                int iRows = CLogic.updateProvRows(iId,strName);
                System.out.println("update supplier rows: " + iRows);
                
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
