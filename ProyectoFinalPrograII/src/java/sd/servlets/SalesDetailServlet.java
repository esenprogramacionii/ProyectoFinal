package sd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sd.logic.SalesDetailLogic;
import sd.objects.SalesDetailObj;


@WebServlet(name = "SalesDetailServlet", urlPatterns = {"/SalesDetailServlet"})
public class SalesDetailServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
             /* your code */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strProduct = request.getParameter("product");
                int iProduct = Integer.parseInt(strProduct);
                String strSales = request.getParameter("sales");
                int iSales = Integer.parseInt(strSales);
                String strQuantity = request.getParameter("quantity");
                int iQuantity = Integer.parseInt(strQuantity);
                
                //access logic
                SalesDetailLogic CLogic = new SalesDetailLogic();
                int iRows = CLogic.insertSalesDetailRows(iProduct, iSales, iQuantity);
                System.out.println("insert salesdetail rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                SalesDetailLogic CLogic = new SalesDetailLogic();
                ArrayList<SalesDetailObj> CArray = CLogic.getAllSalesDetail();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("salesdetails", CArray);
                response.sendRedirect("salesdetailForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                SalesDetailLogic CLogic = new SalesDetailLogic();
                int iRows = CLogic.deleteSalesDetailRows(iId);
                
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
                SalesDetailLogic CLogic = new SalesDetailLogic();
                SalesDetailObj CSalesDetail = CLogic.getSalesDetailById(iId);
                
                //send to frontend
                request.getSession().setAttribute("salesdetail", CSalesDetail);
                response.sendRedirect("salesdetailUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strProduct = request.getParameter("product");
                String strSales = request.getParameter("sales");
                int iId = Integer.parseInt(strId);
                int iProduct = Integer.parseInt(strProduct);
                int iSales = Integer.parseInt(strSales);
                String strQuantity = request.getParameter("quantity");
                int iQuantity = Integer.parseInt(strQuantity);
                
                //access logic
                SalesDetailLogic CLogic = new SalesDetailLogic();
                int iRows = CLogic.updateClientRows(iId, iProduct, iSales, iQuantity);
                System.out.println("update salesdetail rows: " + iRows);
                
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

