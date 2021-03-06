
package Inventory.prografinal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Inventory.prografinal.logic.ProductLogic;
import Inventory.prografinal.logic.categoryLogic;
import Inventory.prografinal.objects.ProductObj;
import Inventory.prografinal.objects.ProductView;
import Inventory.prografinal.objects.categoryObj;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet 
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
                String strName = request.getParameter("name");
                String strBrand = request.getParameter("brand");
                String strDescription = request.getParameter("description");
                String strYear = request.getParameter("year");
                String strPrice = request.getParameter("price");
                String strCategory = request.getParameter("category");
                
                
               
                int intYear = Integer.parseInt(strYear);
                Double dPrice = Double.parseDouble(strPrice);
                int iCategory = Integer.parseInt(strCategory);
                
                //access logic
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.insertProductRows(strName, strBrand, strDescription, intYear, dPrice, iCategory);
                System.out.println("insert product rows: " + iRows);
                                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");                 
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                ProductLogic CLogic = new ProductLogic();
                ArrayList<ProductView> CArray = CLogic.getAllProducts();
                
                //send to frontend
                request.getSession().setAttribute("productcatview", CArray);
                response.sendRedirect("ProductForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.deleteProductRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }            
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("Id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductLogic CLogic = new ProductLogic();
                ProductObj CProduct = CLogic.getProductById(iId);
                
                categoryLogic CCategoryLogic = new categoryLogic();
                ArrayList<categoryObj> CArray = CCategoryLogic.getAllCategories();
                
                request.getSession().setAttribute("category", CArray);
                request.getSession().setAttribute("product", CProduct);
                
                response.sendRedirect("ProductUpdateForm.jsp");
            }            
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("name");
                String strBrand = request.getParameter("brand");
                String strDescription = request.getParameter("description");
                String strYear = request.getParameter("year");
                String strPrice = request.getParameter("price");
                String strCategory = request.getParameter("category");
                
                int iId = Integer.parseInt(strId);
                int intYear = Integer.parseInt(strYear);
                double dPrice = Double.parseDouble(strPrice);
                int iCategory = Integer.parseInt(strCategory);
                
                //access logic
                ProductLogic CLogic = new ProductLogic();
                int iRows = CLogic.updateProductRows(iId,strName, strBrand, strDescription, intYear, dPrice, iCategory);
                System.out.println("update product rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }            
            
            if(strFormId.equals("6"))
            {
                //load all dropdowns
                categoryLogic CCategoryLogic = new categoryLogic();
                ArrayList<categoryObj> CCategoryArray = CCategoryLogic.getAllCategories();
                
                request.getSession().setAttribute("category", CCategoryArray);
                
                response.sendRedirect("ProductNew.jsp");
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
