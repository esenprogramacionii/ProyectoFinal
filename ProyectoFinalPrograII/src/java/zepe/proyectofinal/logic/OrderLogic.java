
package zepe.proyectofinal.logic;

import zepe.proyectofinal.database.DatabaseX;
import zepe.proyectofinal.objects.OrderObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderLogic extends Logic

{
    public boolean insertOrderBool(int p_Iid, int p_Supplier, String p_date)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.order(id,supplier,date) "
                + "VALUES(0,"+p_Supplier+",'"+p_date+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertOrderRows(int p_Iid, int p_Supplier, String p_date)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
         String strSql = "INSERT INTO mydb.order(id,supplier,date) "
                + "VALUES(0,"+p_Supplier+",'"+p_date+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para obtener ultimo id insertado AQUI ES DONDE ESTOY AHORITA
    
     public int getlastid() {
        DatabaseX database = getDatabase();
        String StrSql = "SELECT LAST_INSERT_ID() as lastid";
        System.out.println(StrSql);
        int lastId = 0;
        ResultSet rs = database.executeQuery(StrSql);
        
        if(rs!=null)
        {

            try {
                while(rs.next())
                {
                    lastId = rs.getInt("lastid");
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }

        return lastId;
    
        }
     
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    //metodo3, para obtener toda la lista de categorías
    public ArrayList<OrderObj> getAllOrders() //Nombre del método
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.order ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<OrderObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iSupplier;
            String strDate;
            
            OrderObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iSupplier = CResult.getInt("supplier");
                    strDate = CResult.getString("date");
                    
                    
                    CTemp = new OrderObj(iId, iSupplier,strDate);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OrderLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
      public int deleteOrderRows(int p_iId) //metodo para borrar ordenes
    {
        int iRows = deleteTableRows(p_iId, "order");
        return iRows;
    }
}
    
    
    
    

