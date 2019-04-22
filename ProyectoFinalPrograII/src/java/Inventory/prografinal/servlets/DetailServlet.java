
package Inventory.prografinal.servlets;


import Inventory.prografinal.logic.DetailLogic;
import Inventory.prografinal.logic.storeLogic;
import Inventory.prografinal.objects.DetailViewObj;
import Inventory.prografinal.objects.storeObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetailServlet", urlPatterns = {"/DetailServlet"})
public class DetailServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid"); //Pedir el Id correspodiente a acción a ejecutar
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String Iid = request.getParameter("id");
                String strprod = request.getParameter("product");
                String strQ = request.getParameter("quantity");
                String strorder = request.getParameter("order");

                int id = Integer.parseInt(Iid);
                int product = Integer.parseInt(strprod);
                int Quant = Integer.parseInt(strQ);
                int order = Integer.parseInt(strorder);
                
                //access logic
                DetailLogic CLogic = new DetailLogic();
                int iRows = CLogic.insertdetailRows(id, product,Quant,order);
                System.out.println("insert client rows: " + iRows);
                
                storeLogic PLogic = new storeLogic();
                ArrayList<storeObj> SArray = PLogic.getAllStores();
                
                
                //send to frontend, puedo enviar más de un atributo en la session
                request.getSession().setAttribute("store", SArray);
                request.getSession().setAttribute("rows", new Integer(iRows) );
                request.getSession().setAttribute("product", product );
                request.getSession().setAttribute("stock", Quant );
                response.sendRedirect("genericMessage2.jsp");
            }
           
             if(strFormId.equals("2")) //Obtener todos los campos de la tabla orderdetail
            {
                //access logic
                DetailLogic CLogic = new DetailLogic();
                ArrayList<DetailViewObj> CArray = CLogic.getAllViews();
                
                //send to frontend
                request.getSession().setAttribute("detail", CArray);
                response.sendRedirect("DetailForm.jsp");
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
