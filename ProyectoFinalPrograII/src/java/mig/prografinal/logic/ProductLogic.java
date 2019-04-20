
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
                    iId = CResult.getInt("ID");
                    strName = CResult.getString("Product");
                    strBrand = CResult.getString("Brand");
                    strCategory = CResult.getString("Category");
                    strDescription = CResult.getString("Description");
                    intYear = CResult.getInt("Year");
                    dPrice = CResult.getDouble("Price");
                    
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

    public int insertProductRows(String p_strName, String p_strBrand,
            String p_strDescription,int p_intYear, double p_dPrice, int p_iCategory) 
    {
        //
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.product"
                + "(id,name,brand,description, year, price,category) "
                + "VALUES(0,'"+p_strName+"','"+p_strBrand+"',"
                + "'"+p_strDescription+"',"+p_intYear+","+p_dPrice+","+p_iCategory+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
     public int deleteProductRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "name");
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
                    strName = CResult.getString("name");
                    strBrand = CResult.getString("brand");
                    iCategory = CResult.getInt("category");
                    strDescription = CResult.getString("description");
                    intYear = CResult.getInt("year");
                    dPrice = CResult.getDouble("price");
                    
                    CTemp = new ProductObj(iId, strName, strBrand, strDescription, intYear, dPrice, iCategory);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
    
     public int updateProductRows(int p_iId, String p_strName, String p_strBrand,  String p_strDescription,
             int p_intYear, double p_dPrice, int p_iCategory) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update mydb.product "
                + "set name = '"+p_strName+"', brand = '"+p_strBrand+"', description = '"+p_strDescription+"',"
                + "year = "+p_intYear+", price = "+p_dPrice+", category = "+p_iCategory+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
}
