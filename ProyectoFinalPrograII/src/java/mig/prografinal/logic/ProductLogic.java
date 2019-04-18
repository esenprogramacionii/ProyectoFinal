
package mig.prografinal.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mig.prografinal.database.DatabaseX;
import mig.prografinal.objects.ProductObj;
import mig.prografinal.objects.ProductView;

public class ProductLogic extends logic
{
    
 
    public ArrayList<ProductView> getAllProducts() 
    {
        //select * from travelsys.trip;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.productcatview ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductView> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strBrand;
            String strDescription;
            int intYear;
            double dPrice;
            String strCategory;
            
            ProductView CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("pname");
                    strBrand = CResult.getString("brand");
                    strCategory = CResult.getString("category");
                    strDescription = CResult.getString("description");
                    intYear = CResult.getInt("pyear");
                    dPrice = CResult.getDouble("price");
                    
                    CTemp = new ProductView(iId, strName, strBrand, strCategory, strDescription, intYear, dPrice);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
    }

    public int insertProductRows(String p_strName, String p_strBrand, int p_iCategory,
            String p_strDescription,int p_intYear, double p_dPrice) 
    {
        //
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.product"
                + "(id,strName,strBrand, iCategory,strDescription, intYear, dPrice) "
                + "VALUES(0,"+p_strName+","+p_strBrand+","+p_iCategory+","
                + ""+p_strDescription+","+p_intYear+","+p_dPrice+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
     public int deleteProductRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "client");
        return iRows;
    }
     
    public ProductObj getProductById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.product where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProductObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strBrand;
            int iCategory;
            String strDescription;
            int intYear;
            double dPrice;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("pname");
                    strBrand = CResult.getString("brand");
                    iCategory = CResult.getInt("category");
                    strDescription = CResult.getString("description");
                    intYear = CResult.getInt("pyear");
                    dPrice = CResult.getDouble("price");
                    
                    CTemp = new ProductObj(iId, strName, strBrand, iCategory, strDescription, intYear, dPrice);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
    
     public int updateProductRows(int p_iId, String p_strName, String p_strBrand, int p_iCategory,  String p_strDescription,
             int p_intYear, double p_dPrice) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update travelsys.client "
                + "set name = '"+p_strName+"', brand = '"+p_strBrand+"', categry = "+p_iCategory+", description = '"+p_strDescription+"',"
                + "year = "+p_intYear+", price = "+p_dPrice+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
