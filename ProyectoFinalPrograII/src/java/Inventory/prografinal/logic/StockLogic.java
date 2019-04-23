
package Inventory.prografinal.logic;


import Inventory.prografinal.database.DatabaseX;
import Inventory.prografinal.objects.StockViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Inventory.prografinal.objects.BStoreObj;
import Inventory.prografinal.objects.FinalObj;
import Inventory.prografinal.objects.StockObj;

public class StockLogic extends logic
    
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
    
    //METODO
    public ArrayList<FinalObj> getTotal() //Nombre del método
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.final ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<FinalObj> CArray = null;
        
        if(CResult!=null)
            
        {
            String PName;
            int PId;
            int Stock;
            
            FinalObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    PName = CResult.getString("ProductName");
                    PId = CResult.getInt("ProductID");
                    Stock = CResult.getInt("Stock");
                    
                    CTemp = new FinalObj(PName, PId,Stock);
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
    
    //METODO PARA OBTENER STOCK POR TIENDAS 
    public ArrayList<BStoreObj> getBStore() 
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.bystore ";
        System.out.println(strSql);
        ResultSet BResult = database.executeQuery(strSql);
        ArrayList<BStoreObj> BArray = null;
        
        if(BResult!=null)
            
        {
            String BName;
            String BStore;
            int BStock;
            
            BStoreObj BTemp;
            BArray = new ArrayList<>();
            
            try 
            {
                while(BResult.next())
                {
                    BName = BResult.getString("Product Name");
                    BStore = BResult.getString("Store Name");
                    BStock = BResult.getInt("Stock");
                    
                    BTemp = new BStoreObj(BName, BStore, BStock);
                    BArray.add(BTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StockLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return BArray;

    }
    
}
