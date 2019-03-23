
package mig.prografinal.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mig.prografinal.database.DatabaseX;
import mig.prografinal.objects.ProductObj;


public class ProductLogic extends logic
{
    //metodo1: todos los registros country columnas
    //sql: select * from esentravel.country
    public ArrayList<ProductObj> getAllProducts()
    {
        //codificar el metodo
        DatabaseX CDatabase = getDatabase();
        String strSql = "select * from esentravel.country";
        ResultSet CResult = CDatabase.executeQuery(strSql);
        ArrayList<ProductObj> CArray = null;
        
        //evaluar el result que venga lleno
        if(CResult!=null)
        {
            try 
            {
                int iId;
                String strName;
                String strBrand;
                String strDescription;
                int iYear;
                double dPrice;
                int iCategory;
                ProductObj CTemp;
                CArray = new ArrayList<>();
                
                while(CResult.next())
                {
                    iId = CResult.getInt("id"); //id
                    strName = CResult.getString("pname"); //name
                    strBrand = CResult.getString("brand"); //code
                    strDescription = CResult.getString("description");
                    iYear = CResult.getInt("pyear");
                    dPrice = CResult.getDouble("dPrice");
                    iCategory = CResult.getInt("category");
                    
                    CTemp = new ProductObj(iId, strName, strBrand, strDescription, iYear, dPrice, iCategory);
                    
                    //agregando al array un instancia de countryobj
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
}
