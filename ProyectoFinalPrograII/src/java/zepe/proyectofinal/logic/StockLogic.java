
package zepe.proyectofinal.logic;

import zepe.proyectofinal.database.DatabaseX;
import zepe.proyectofinal.objects.StockViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zepe.proyectofinal.objects.StockObj;

public class StockLogic extends Logic
    
    {
    
    //Metodos para insercion de datos a stock
    //metodo2
    public int insertStockRows(int p_Iid, int p_Iprod, int p_Store, int p_Stock)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
         String strSql = "INSERT INTO mydb.stock(transactionid, productid, storeid, stock) "
                + "VALUES(0,"+p_Iprod+","+p_Store+","+p_Stock+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    //Metodo para la tabla stock
       public ArrayList<StockObj> getAllOrders() //Nombre del método
    {
     
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.stock ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<StockObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iProduct;
            int iStore;
            int iStock;
            
            
            StockObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("transactionid");
                    iProduct = CResult.getInt("productid");
                    iStore = CResult.getInt("storeid");
                    iStock = CResult.getInt("stock");
                    
                    
                    CTemp = new StockObj(iId, iProduct, iStore, iStock);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StockLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    
    
    
    // Para la tabla View de inventory
    public ArrayList<StockViewObj> getInventory() //Nombre del método
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.inventory ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<StockViewObj> CArray = null;
        
        if(CResult!=null)
            
        {
            int iTrans;
            String StrP;
            String StrS;
            int iStock;
            
            StockViewObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iTrans = CResult.getInt("transactionid");
                    StrP = CResult.getString("product name");
                    StrS = CResult.getString("store name");
                    iStock = CResult.getInt("stock");
                    
                    CTemp = new StockViewObj(iTrans, StrP, StrS, iStock);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StockLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
}
