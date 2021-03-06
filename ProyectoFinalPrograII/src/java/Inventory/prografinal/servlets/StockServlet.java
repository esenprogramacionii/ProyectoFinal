
package Inventory.prografinal.servlets;


import Inventory.prografinal.logic.ProductLogic;
import Inventory.prografinal.logic.ProvLOGIC;
import Inventory.prografinal.logic.StockLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Inventory.prografinal.objects.BStoreObj;
import Inventory.prografinal.objects.FinalObj;
import Inventory.prografinal.objects.ProductView;
import Inventory.prografinal.objects.ProvObj;


@WebServlet(name = "StockServlet", urlPatterns = {"/StockServlet"})
public class StockServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            String strFormId = request.getParameter("formid"); //Pedir el Id correspodiente a acción a ejecutar
            
            /*if(strFormId.equals("1")) //Obtener todos los campos de una tabla
            {
                //access logic
                StockLogic CLogic = new StockLogic();
                ArrayList<StockViewObj> CArray = CLogic.getStock();
                
                
                //send to frontend
               // request.getSession().setAttribute("stock", CArray);
                response.sendRedirect("stockForm.jsp");
            }*/
            
              if(strFormId.equals("2")) //Obtener todos los campos de una tabla
            {
                //access logic
                StockLogic CLogic = new StockLogic();
                ArrayList<FinalObj> CArray = CLogic.getTotal();
                
                StockLogic BLogic = new StockLogic();
                ArrayList<BStoreObj> BArray = BLogic. getBStore();
                
                //send to frontend
                request.getSession().setAttribute("stock", CArray);
                request.getSession().setAttribute("stock1", BArray);
                
                response.sendRedirect("stockForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String Id = request.getParameter("transaction");
                String strprod = request.getParameter("product");
                String strQ = request.getParameter("quantity");
                String Store = request.getParameter("store");

                int id = Integer.parseInt(Id);
                int product = Integer.parseInt(strprod);
                int Quant = Integer.parseInt(strQ);
                int store = Integer.parseInt(Store);
                
                //access logic
                StockLogic CLogic = new StockLogic();
                int iRows = CLogic.insertStockRows(id, product,store,Quant);
                
                //send to frontend, puedo enviar más de un atributo en la session
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage1.jsp");
            }
            
            if(strFormId.equals("4")) //Obtener todos los campos de una tabla
            {
                //access logic
                StockLogic BLogic = new StockLogic();
                ArrayList<BStoreObj> BArray = BLogic.getBStore();
                
               ProvLOGIC ProvLogic = new ProvLOGIC();
               ArrayList<ProvObj>  PrArray = ProvLogic.getAllProv();
                
                //send to frontend
                request.getSession().setAttribute("supplier", PrArray);
                request.getSession().setAttribute("bystore", BArray);
                response.sendRedirect("NewOrder.jsp");
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
