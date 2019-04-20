
package sales.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sales.logic.SDetailLogic;

@WebServlet(name = "SalesDetailServlet", urlPatterns = {"/SalesDetailServlet"})
public class SalesDetailServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String strFormId = request.getParameter("formid"); //
        
             if(strFormId.equals("1"))
            {
                //get parameters
                String strProd = request.getParameter("product");
                String strsale = request.getParameter("sale");
                String strQu = request.getParameter("quantity");

                int Sproduct = Integer.parseInt(strProd);
                int SQ = Integer.parseInt(strQu);
                int sale = Integer.parseInt(strsale);
                
                //access logic
                SDetailLogic CLogic = new SDetailLogic();
                int iRows = CLogic.insertSalesDRows(Sproduct,sale,SQ);
                System.out.println("insert client rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                request.getSession().setAttribute("product", Sproduct );
                request.getSession().setAttribute("quantity", SQ );

                
                response.sendRedirect("genericMessage1.jsp");
            }
            
             
                   if(strFormId.equals("2"))
            {
                //METODO PARA QUITAR ELEMENTOS DE LA TABLA STOCK
                String strprod = request.getParameter("prod");
                String strQ = request.getParameter("quant");
                String Store = request.getParameter("Sstore");

                //ESTO ES PARA INSERTAR A LA TABLA STOCK 
                /*int Id = Integer.parseInt(Id);
                int prod = Integer.parseInt(strprod);
                int Quant = Integer.parseInt(strQ);
                int store = Integer.parseInt(Store);
                
                //access logic
                StockLogic CLogic = new StockLogic();
                int iRows = CLogic.insertStockRows(id, product,store,Quant);
                
                //send to frontend, puedo enviar más de un atributo en la session
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage1.jsp");*/
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
