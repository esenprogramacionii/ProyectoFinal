
package zepe.proyectofinal.servlets;

import zepe.proyectofinal.logic.OrderLogic;
import zepe.proyectofinal.objects.OrderObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zepe.proyectofinal.logic.StockLogic;
import zepe.proyectofinal.objects.BStoreObj;


@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String strFormId = request.getParameter("formid"); //Pedir el Id correspodiente a acción a ejecutar
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String Iid = request.getParameter("id"); //Este id que se introduce es el que necesito, pero es autoincrementable
                //En la línea de arriba es que está el problema porque se está manndando como cero y sql hace el resto
                String strSupplier = request.getParameter("supplier");
                String strDate =  request.getParameter("date");
                int id = Integer.parseInt(Iid);
                int supplier = Integer.parseInt(strSupplier);
                
                //access logic, aquí quiero meter los campos a la tabla y que me diga el último id insertado
                OrderLogic CLogic = new OrderLogic();
                int iRows = CLogic.insertOrderRows(id, supplier, strDate); 
                int lastid = CLogic.getlastid();
                
                System.out.println(lastid);
                
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                request.getSession().setAttribute("lastid", lastid ); //Aquí es donde quiero mandar la order id asociada para llenar la otra tabla
                response.sendRedirect("genericMessageORD.jsp");
            }
            
            if(strFormId.equals("2")) //Obtener todos los campos de una tabla
            {
                //access logic
                OrderLogic CLogic = new OrderLogic();
                ArrayList<OrderObj> CArray = CLogic.getAllOrders();
                
                //send to frontend
                request.getSession().setAttribute("orders", CArray);
                response.sendRedirect("OrderForm.jsp");
            }
            
             /*if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                OrderLogic CLogic = new OrderLogic();
                int iRows = CLogic.deleteOrderRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }*/
            
            
            
 
            
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
