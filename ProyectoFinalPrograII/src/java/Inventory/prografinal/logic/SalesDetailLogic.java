package Inventory.prografinal.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Inventory.prografinal.database.DatabaseX;
import Inventory.prografinal.objects.SalesDetailObj;

public class SalesDetailLogic extends logic
{   
    //metodo2
    public int insertSalesDetailRows(int p_iProduct, int p_iSales, int p_iQuantity)
    {
        //INSERT INTO mydb.salesdetail(id,product,store,quantity) VALUES(0,1,1,10);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.salesdetail(id,product,sales,quantity) "
                + "VALUES(0,"+p_iProduct+","+p_iSales+","+p_iQuantity+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3, para obtener toda la lista dde clientes
    public ArrayList<SalesDetailObj> getAllSalesDetail() 
    {
        //select * from mydb.salesdetail;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.salesdetail ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<SalesDetailObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iProduct;
            int iSales;
            int iQuantity;
            
            
            SalesDetailObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iProduct = CResult.getInt("product");
                    iSales = CResult.getInt("sales");
                    iQuantity = CResult.getInt("quantity");
                    
                    CTemp = new SalesDetailObj(iId, iProduct, iSales, iQuantity);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(SalesDetailLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteSalesDetailRows(int p_iId) //metodo para borrar clientes 
    {
        int iRows = deleteTableRows(p_iId, "salesdetail");
        return iRows;
    }

    public SalesDetailObj getSalesDetailById(int p_iId) //Seleccionan un cliente usando una condicion 
    {
        //select * from mydb.salesdetail;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.salesdetail where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        SalesDetailObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iProduct;
            int iSales;
            int iQuantity;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iProduct = CResult.getInt("product");
                    iSales = CResult.getInt("sales");
                    iQuantity = CResult.getInt("quantity");
                    
                    CTemp = new SalesDetailObj(iId, iProduct, iSales, iQuantity);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(SalesDetailLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateClientRows(int p_iId, int p_iProduct, int p_iSales, int p_iQuantity )//metodo para actualizar rows
    {
        //update mydb.salesdetail set product = 1, store = 25, qunatity = 10 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update mydb.salesdetail "
                + "set product = "+p_iProduct+",sales = "+p_iSales+", quantity = "+p_iQuantity+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}


